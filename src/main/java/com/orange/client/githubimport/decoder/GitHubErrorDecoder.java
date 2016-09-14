package com.orange.client.githubimport.decoder;

import com.orange.client.githubimport.exception.GitHubImportException;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

import java.io.IOException;

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
public class GitHubErrorDecoder implements ErrorDecoder {

    private Decoder decoder;
    private ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    public GitHubErrorDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    public Exception decode(String methodKey, Response response) {
        try {
            return (Exception) decoder.decode(response, GitHubImportException.class);
        } catch (IOException fallbackToDefault) {
            return defaultDecoder.decode(methodKey, response);
        }
    }
}
