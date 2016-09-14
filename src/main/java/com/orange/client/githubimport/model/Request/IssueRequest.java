
package com.orange.client.githubimport.model.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orange.client.githubimport.model.Comment;
import com.orange.client.githubimport.model.Issue;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class IssueRequest {

    @SerializedName("issue")
    @Expose
    private Issue issue;

    @SerializedName("comments")
    @Expose
    private List<Comment> comments = new ArrayList<Comment>();

    /**
     * @return The issue
     */
    public Issue getIssue() {
        return issue;
    }

    /**
     * @param issue The issue
     */
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public IssueRequest withIssue(Issue issue) {
        this.issue = issue;
        return this;
    }

    /**
     * @return The comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments The comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public IssueRequest withComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

}
