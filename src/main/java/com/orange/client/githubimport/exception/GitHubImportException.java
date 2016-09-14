package com.orange.client.githubimport.exception;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
public class GitHubImportException extends RuntimeException {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("errors")
    @Expose
    private List<Error> errors;

    @SerializedName("documentation_url")
    @Expose
    private String documentationUrl;

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GitHubImportException{" +
                "message='" + message + '\'' +
                ", errors=" + errors +
                ", documentationUrl='" + documentationUrl + '\'' +
                '}';
    }

    /**
     * @return The errors
     */
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * @param errors The errors
     */
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    /**
     * @return The documentationUrl
     */
    public String getDocumentationUrl() {
        return documentationUrl;
    }

    /**
     * @param documentationUrl The documentation_url
     */
    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }

    private class Error {

        @SerializedName("resource")
        @Expose
        private String resource;

        @SerializedName("code")
        @Expose
        private String code;

        @SerializedName("field")
        @Expose
        private String field;

        /**
         * @return The resource
         */
        public String getResource() {
            return resource;
        }

        /**
         * @param resource The resource
         */
        public void setResource(String resource) {
            this.resource = resource;
        }

        /**
         * @return The code
         */
        public String getCode() {
            return code;
        }

        /**
         * @param code The code
         */
        public void setCode(String code) {
            this.code = code;
        }

        /**
         * @return The field
         */
        public String getField() {
            return field;
        }

        /**
         * @param field The field
         */
        public void setField(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "resource='" + resource + '\'' +
                    ", code='" + code + '\'' +
                    ", field='" + field + '\'' +
                    '}';
        }
    }
}
