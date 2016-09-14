
package com.orange.client.githubimport.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.Date;

@Generated("org.jsonschema2pojo")
public class Comment {

    @SerializedName("created_at")
    @Expose
    private Date createdAt;

    @SerializedName("body")
    @Expose
    private String body;

    /**
     * @return The createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Comment withCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * @return The body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    public Comment withBody(String body) {
        this.body = body;
        return this;
    }

}
