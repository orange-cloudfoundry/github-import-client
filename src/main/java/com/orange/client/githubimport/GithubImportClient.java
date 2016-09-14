package com.orange.client.githubimport;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.orange.client.githubimport.adapter.ISODateAdapter;
import com.orange.client.githubimport.decoder.GitHubErrorDecoder;
import com.orange.client.githubimport.interceptor.GithubImportInterceptor;
import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.DoubleToIntMapTypeAdapter;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import okhttp3.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Date;
import java.util.Map;

/**
 * Copyright (C) 2016 Orange
 * <p>
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution
 * or at 'https://opensource.org/licenses/Apache-2.0'.
 * <p>
 * Author: Arthur Halet
 * Date: 13/09/2016
 */
public class GithubImportClient {
    private String githubToken;
    private Feign.Builder feignBuilder;
    private okhttp3.OkHttpClient.Builder okHttpClientBuilder;
    private String proxyHost;
    private Integer proxyPort;
    private String proxyUsername;
    private String proxyPassword;

    public GithubImportClient(String githubToken) {
        this(githubToken, null, null, null, null);
    }

    public GithubImportClient(String githubToken, String proxyHost, Integer proxyPort) {
        this(githubToken, proxyHost, proxyPort, null, null);
    }

    public GithubImportClient(String githubToken, String proxyHost, Integer proxyPort, String proxyUsername, String proxyPassword) {
        this.githubToken = githubToken;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.proxyUsername = proxyUsername;
        this.proxyPassword = proxyPassword;
        this.okHttpClientBuilder = this.createOkHttpClientBuilder();
        this.feignBuilder = this.createFeignBuilder();
    }

    public String getGithubToken() {
        return githubToken;
    }

    public void setGithubToken(String githubToken) {
        this.githubToken = githubToken;
    }

    public Feign.Builder getFeignBuilder() {
        return feignBuilder;
    }

    public void setFeignBuilder(Feign.Builder feignBuilder) {
        this.feignBuilder = feignBuilder;
    }

    public GithubImport connect() {
        return this.feignBuilder.target(GithubImport.class, "https://api.github.com");
    }

    public okhttp3.OkHttpClient.Builder getOkHttpClientBuilder() {
        return okHttpClientBuilder;
    }

    public void setOkHttpClientBuilder(okhttp3.OkHttpClient.Builder okHttpClientBuilder) {
        this.okHttpClientBuilder = okHttpClientBuilder;
    }

    public okhttp3.OkHttpClient.Builder createOkHttpClientBuilder() {
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        if (proxyHost != null && proxyPort != null) {
            builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
        }
        if (proxyUsername != null) {
            Authenticator proxyAuthenticator = new Authenticator() {
                public Request authenticate(Route route, Response response) throws IOException {
                    String credential = Credentials.basic(proxyUsername, proxyPassword);
                    return response.request().newBuilder()
                            .header("Proxy-Authorization", credential)
                            .build();
                }
            };
            builder.proxyAuthenticator(proxyAuthenticator);
        }

        return builder;
    }

    public Feign.Builder createFeignBuilder() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()

                .registerTypeAdapter(new TypeToken<Map<String, Object>>() {
                }.getType(), new DoubleToIntMapTypeAdapter())

                .registerTypeAdapter(Date.class, new ISODateAdapter())
                .create();

        Decoder decoder = new GsonDecoder(gson);
        Encoder encoder = new GsonEncoder(gson);
        return Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .client(new OkHttpClient(okHttpClientBuilder.build()))
                .logLevel(Logger.Level.BASIC)
                .requestInterceptor(new GithubImportInterceptor(this.githubToken))
                .errorDecoder(new GitHubErrorDecoder(decoder));
    }
}
