package com.orange.client.githubimport;

import com.orange.client.githubimport.exception.GitHubImportException;
import com.orange.client.githubimport.model.Comment;
import com.orange.client.githubimport.model.Issue;
import com.orange.client.githubimport.model.Request.IssueRequest;
import com.orange.client.githubimport.model.Response.StatusResponse;
import com.orange.client.githubimport.model.Since;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * Copyright (C) 2016 Arthur Halet
 * <p>
 * This software is distributed under the terms and conditions of the 'MIT'
 * license which can be found in the file 'LICENSE' in this package distribution
 * or at 'http://opensource.org/licenses/MIT'.
 * <p>
 * Author: Arthur Halet
 * Date: 14/09/2016
 */
public class GithubImportTest {

    private static final String GH_TOKEN = System.getProperty("gh.token", null);
    private static final String GH_OWNER = System.getProperty("gh.owner", null);
    private static final String GH_REPO = System.getProperty("gh.repo", null);
    private static final String PROXY_HOST = System.getProperty("http.proxyHost", null);
    private static final String PROXY_PASSWD = System.getProperty("http.proxyPassword", null);
    private static final int PROXY_PORT = Integer.getInteger("http.proxyPort", 80);
    private static final String PROXY_USER = System.getProperty("http.proxyUsername", null);
    private GithubImportClient githubImportClient;

    @Before
    public void setUp() throws Exception {
        githubImportClient = new GithubImportClient(GH_TOKEN, PROXY_HOST, PROXY_PORT, PROXY_USER, PROXY_PASSWD);
    }

    @Test
    public void when_importing_issue_it_should_respond_a_valid_status() throws Exception {
        IssueRequest issueRequest = this.forgeImportRequest();
        StatusResponse statusResponse = this.githubImportClient.connect()
                .importIssue(GH_OWNER, GH_REPO, issueRequest);
        this.assertCreatedStatusResponse(statusResponse);
    }

    @Test
    public void when_importing_issue_incorrectly_it_should_respond_an_error_response() throws Exception {
        IssueRequest issueRequest = this.forgePartialImportRequest();
        try {
            this.githubImportClient.connect()
                    .importIssue(GH_OWNER, GH_REPO, issueRequest);
            fail("Should throw an GitHubImportException");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(GitHubImportException.class);
        }

    }

    @Test
    public void when_checking_status_after_creating_import_it_should_give_the_correct_expected_response() throws Exception {
        IssueRequest issueRequest = this.forgeImportRequest();
        StatusResponse statusResponse = this.githubImportClient.connect()
                .importIssue(GH_OWNER, GH_REPO, issueRequest);
        this.assertCreatedStatusResponse(statusResponse);
        StatusResponse importedStatus = this.githubImportClient.connect().checkStatusIssue(GH_OWNER, GH_REPO, statusResponse.getId());
        this.assertStatusResponse(importedStatus);
    }

    @Test
    public void when_checking_all_status_after_creating_import_it_should_give_the_correct_expected_response() throws Exception {
        IssueRequest issueRequest = this.forgeImportRequest();
        StatusResponse statusResponse = this.githubImportClient.connect()
                .importIssue(GH_OWNER, GH_REPO, issueRequest);
        this.assertCreatedStatusResponse(statusResponse);
        List<StatusResponse> importedResponses = this.githubImportClient.connect().checkStatusIssues(GH_OWNER, GH_REPO, new Since(new Date(0)));
        assertThat(importedResponses.size()).isGreaterThan(1);
    }

    private void assertStatusResponse(StatusResponse statusResponse) {
        assertThat(statusResponse).isNotNull();
        assertThat(statusResponse.getId()).isNotNull();
    }

    private void assertCreatedStatusResponse(StatusResponse statusResponse) {
        assertStatusResponse(statusResponse);
        assertThat(statusResponse.getStatus()).isEqualTo("pending");
    }

    private IssueRequest forgeImportRequest() {
        Issue issue = new Issue()
                .withTitle("test import")
                .withBody("this is a simple test")
                .withLabels(Arrays.asList("label1"))
                .withCreatedAt(new Date(0));
        Comment comment = new Comment()
                .withBody("test comment")
                .withCreatedAt(new Date());
        return new IssueRequest()
                .withIssue(issue)
                .withComments(Arrays.asList(comment));
    }

    private IssueRequest forgePartialImportRequest() {
        Issue issue = new Issue()
                .withTitle("test import in error");
        return new IssueRequest()
                .withIssue(issue);
    }
}