package com.duff.client.service;

import java.io.IOException;
import java.util.Optional;

import com.duff.client.param.SpotifyParam;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

/**
 * The Class SpotifyAbstractService.
 */
public abstract class SpotifyAbstractService {

	private static SpotifyApi spotifyApi;

	/**
	 * Gets the spotify api access.
	 *
	 * @param spotifyParam
	 *            the spotify param
	 * @return the spotify api access
	 */
	public static SpotifyApi getSpotifyApiAccess(SpotifyParam spotifyParam) {
		spotifyApiBuild(spotifyParam);
		try {
			final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
			ClientCredentials clientCredentials = clientCredentialsRequest.execute();
			// Set access token for further "spotifyApi" object usage
			spotifyApi.setAccessToken(clientCredentials.getAccessToken());
			spotifyParam.setRefreshAccessToken(Optional.of(clientCredentials.getAccessToken()));
		} catch (IOException | SpotifyWebApiException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return spotifyApi;
	}

	/**
	 * Spotify api build.
	 *
	 * @param spotifyParam the spotify param
	 */
	public static void spotifyApiBuild(SpotifyParam spotifyParam) {
		if (spotifyParam.getRefreshAccessToken() == null) {
			spotifyApi = new SpotifyApi.Builder().setClientId(spotifyParam.getClientId())
					.setClientSecret(spotifyParam.getClientSecret()).build();
		} else {
			spotifyApi = new SpotifyApi.Builder().setClientId(spotifyParam.getClientId())
					.setClientSecret(spotifyParam.getClientSecret())
					.setRefreshToken(spotifyParam.getRefreshAccessToken().orElse(null)).build();
		}
	}

}
