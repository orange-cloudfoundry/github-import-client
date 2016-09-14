package com.orange.client.githubimport;

import com.orange.client.githubimport.model.Request.IssueRequest;
import com.orange.client.githubimport.model.Response.StatusResponse;
import feign.Param;
import feign.RequestLine;

import java.util.Date;
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
interface GithubImport {

    @RequestLine("POST /repos/{owner}/{repo}/import/issues")
    StatusResponse importIssue(@Param("owner") String owner, @Param("repo") String repo, IssueRequest issueRequest);

    @RequestLine("GET /repos/{owner}/{repo}/import/issues/{id}")
    StatusResponse checkStatusIssue(@Param("owner") String owner, @Param("repo") String repo, @Param("id") Integer id);

    @RequestLine("GET /repos/{owner}/{repo}/import/issues?since={since}")
    List<StatusResponse> checkStatusIssues(@Param("owner") String owner, @Param("repo") String repo, @Param("since") Date date);
}
