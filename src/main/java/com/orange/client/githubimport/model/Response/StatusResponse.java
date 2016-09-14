package com.orange.client.githubimport.model.Response;

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
public class StatusResponse {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("import_issues_url")
    @Expose
    private String importIssuesUrl;

    @SerializedName("repository_url")
    @Expose
    private String repositoryUrl;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("errors")
    @Expose
    private List<Error> errors;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The importIssuesUrl
     */
    public String getImportIssuesUrl() {
        return importIssuesUrl;
    }

    /**
     * @param importIssuesUrl The import_issues_url
     */
    public void setImportIssuesUrl(String importIssuesUrl) {
        this.importIssuesUrl = importIssuesUrl;
    }

    /**
     * @return The repositoryUrl
     */
    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    /**
     * @param repositoryUrl The repository_url
     */
    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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

    @Override
    public String toString() {
        return "StatusResponse{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", url='" + url + '\'' +
                ", importIssuesUrl='" + importIssuesUrl + '\'' +
                ", repositoryUrl='" + repositoryUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", errors=" + errors +
                '}';
    }

    private class Error {
        @SerializedName("location")
        @Expose
        private String location;

        @SerializedName("resource")
        @Expose
        private String resource;

        @SerializedName("field")
        @Expose
        private String field;

        @SerializedName("value")
        @Expose
        private String value;

        @SerializedName("code")
        @Expose
        private String code;

        /**
         * @return The location
         */
        public String getLocation() {
            return location;
        }

        /**
         * @param location The location
         */
        public void setLocation(String location) {
            this.location = location;
        }

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

        /**
         * @return The value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value The value
         */
        public void setValue(String value) {
            this.value = value;
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

        @Override
        public String toString() {
            return "Error{" +
                    "location='" + location + '\'' +
                    ", resource='" + resource + '\'' +
                    ", field='" + field + '\'' +
                    ", value='" + value + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }
}
