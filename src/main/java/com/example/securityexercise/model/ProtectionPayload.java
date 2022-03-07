package com.example.securityexercise.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProtectionPayload {
    @Data
    class RequiredStatusChecks {
        boolean strict = true;
    }
    @Data
    class RequiredPullRequestReviews {
        boolean dismiss_stale_reviews= true;
        boolean require_code_owner_reviews= true;
        int required_approving_review_count= 2;
    }
    private RequiredStatusChecks required_status_checks = null;
    private RequiredPullRequestReviews required_pull_request_reviews = new RequiredPullRequestReviews();
    boolean enforce_admins = true;
    String restrictions = null;


}
