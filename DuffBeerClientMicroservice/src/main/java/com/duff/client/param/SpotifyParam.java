package com.duff.client.param;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class SpotifyParam.
 */
@Component
public class SpotifyParam {
	
	/** The client id. */
	@Value("${spotify.clientId}")
	private String clientId;

	/** The client secret. */
	@Value("${spotify.clientSecret}")
	private String clientSecret;
	
	/** The refresh access token. */
	private Optional<String> refreshAccessToken;

	/**
	 * Gets the client id.
	 *
	 * @return the client id
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Sets the client id.
	 *
	 * @param clientId the new client id
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Gets the client secret.
	 *
	 * @return the client secret
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * Sets the client secret.
	 *
	 * @param clientSecret the new client secret
	 */
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	/**
	 * Gets the refresh access token.
	 *
	 * @return the refresh access token
	 */
	public Optional<String> getRefreshAccessToken() {
		return refreshAccessToken;
	}

	/**
	 * Sets the refresh access token.
	 *
	 * @param refreshAccessToken the new refresh access token
	 */
	public void setRefreshAccessToken(Optional<String> refreshAccessToken) {
		this.refreshAccessToken = refreshAccessToken;
	}

}
