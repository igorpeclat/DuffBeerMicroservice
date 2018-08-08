package com.duff.client.service;

import java.util.List;

import com.duff.client.presenter.BeerPresenter;
import com.duff.client.presenter.Playlist;
import com.wrapper.spotify.SpotifyApi;

/**
 * The Interface ISpotifyService.
 */
public interface ISpotifyService {
	
	/**
	 * Playlist lookup.
	 *
	 * @param name the name
	 * @return the playlist
	 */
	Playlist findPlaylistByName(String name);

	/**
	 * Beers playlist.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<BeerPresenter> findPlaylistByBeerNameStyle(List<String> name);

}
