package com.skhata.schoolMgmtSystem.payload;

/**
 * Created by Rakesh Gurung on 14,Aug,2019
 */
public class JwtAuthenticationResponse {
    private Boolean success;
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(Boolean success, String accessToken) {
        this.success = success;
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
