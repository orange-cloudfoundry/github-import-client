package com.orange.client.githubimport.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Copyright (C) 2016 Orange
 * <p>
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution
 * or at 'https://opensource.org/licenses/Apache-2.0'.
 * <p>
 * Author: Arthur Halet
 * Date: 14/09/2016
 */
public class GithubImportInterceptor implements RequestInterceptor {
    private static final String acceptHeader = "application/vnd.github.golden-comet-preview+json";
    private String githubToken;

    public GithubImportInterceptor(String githubToken) {
        this.githubToken = githubToken;
    }

    public String getGithubToken() {
        return githubToken;
    }

    public void setGithubToken(String githubToken) {
        this.githubToken = githubToken;
    }

    public void apply(RequestTemplate template) {
        template.header("Accept", acceptHeader);
        template.header("Authorization", "token " + githubToken);
    }
}
