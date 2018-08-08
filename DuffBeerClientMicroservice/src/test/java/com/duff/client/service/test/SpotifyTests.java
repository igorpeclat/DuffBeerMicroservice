package com.duff.client.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.duff.client.param.SpotifyParam;
import com.duff.client.service.SpotifyAbstractService;
import com.duff.client.service.SpotifyService;
import com.wrapper.spotify.SpotifyApi;

/**
 * The Class SpotifyTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotifyTests {
	
	@Autowired
	private SpotifyParam spotifyParam;
	
	/** The spotify service. */
	@Autowired
	private SpotifyService spotifyService;
	
	
	/**
	 * Validate login.
	 */
	@Test
	public void validateLogin() {
		Assert.notNull(SpotifyAbstractService.getSpotifyApiAccess(spotifyParam), "Acccess Token must not be null");
	}
	
	
	/**
	 * Search play list.
	 */
	@Test
	public void searchPlayList() {
		Assert.notNull(spotifyService.findPlaylistByName("IPA"), "must not be null");
	}

}