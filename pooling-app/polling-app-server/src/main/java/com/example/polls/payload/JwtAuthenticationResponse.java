package com.example.polls.payload;

public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String usernameOrEmail;

    public String getUsernameOrEmai() {
		return usernameOrEmail;
	}

//	public void setUsernameOrEmail(String usernameOrEmail) {
//		
//	}

	public JwtAuthenticationResponse(String accessToken, String usernameOrEmail) {
        this.accessToken = accessToken;
        this.usernameOrEmail = usernameOrEmail;
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
}
