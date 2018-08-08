package com.duff.client.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.duff.client.service.SpotifyAbstractService;
import com.duff.client.service.SpotifyService;
import com.wrapper.spotify.SpotifyApi;

/**
 * The Class SpotifyTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotifyTests {
	
	/** The client id. */
	private final String clientId = "70bb62fd56414fd599d931a7c78ebd3b";

	/** The client secret. */
	private final String clientSecret = "7ca712d4c3844df1b5728b2e1d62fb63";
	
	/** The spotify api. */
	private SpotifyApi spotifyApi =  SpotifyAbstractService.getSpotifyApi(clientId, clientSecret);
	
	/** The spotify service. */
	@Autowired
	private SpotifyService spotifyService;
	
	
	/**
	 * Validate login.
	 */
	@Test
	public void validateLogin() {
		Assert.notNull(spotifyApi.getAccessToken(), "Acccess Token must not be null");
	}
	
	
	/**
	 * Search play list.
	 */
	@Test
	public void searchPlayList() {
		Assert.notNull(spotifyService.playlistLookup("IPA"), "must not be null");
	}

}