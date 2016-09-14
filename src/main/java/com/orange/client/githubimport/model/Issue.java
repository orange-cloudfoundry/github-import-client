
package com.orange.client.githubimport.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Issue {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("created_at")
    @Expose
    private Date createdAt;

    @SerializedName("closed_at")
    @Expose
    private Date closedAt;

    @SerializedName("updated_at")
    @Expose
    private Date updatedAt;

    @SerializedName("assignee")
    @Expose
    private String assignee;

    @SerializedName("milestone")
    @Expose
    private Integer milestone;

    @SerializedName("closed")
    @Expose
    private Boolean closed;

    @SerializedName("labels")
    @Expose
    private List<String> labels = new ArrayList<String>();

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Issue withTitle(String title) {
        this.title = title;
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

    public Issue withBody(String body) {
        this.body = body;
        return this;
    }

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

    public Issue withCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * @return The closedAt
     */
    public Date getClosedAt() {
        return closedAt;
    }

    /**
     * @param closedAt The closed_at
     */
    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public Issue withClosedAt(Date closedAt) {
        this.closedAt = closedAt;
        return this;
    }

    /**
     * @return The updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Issue withUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * @return The assignee
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * @param assignee The assignee
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Issue withAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    /**
     * @return The milestone
     */
    public Integer getMilestone() {
        return milestone;
    }

    /**
     * @param milestone The milestone
     */
    public void setMilestone(Integer milestone) {
        this.milestone = milestone;
    }

    public Issue withMilestone(Integer milestone) {
        this.milestone = milestone;
        return this;
    }

    /**
     * @return The closed
     */
    public Boolean getClosed() {
        return closed;
    }

    /**
     * @param closed The closed
     */
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Issue withClosed(Boolean closed) {
        this.closed = closed;
        return this;
    }

    /**
     * @return The labels
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * @param labels The labels
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Issue withLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

}
