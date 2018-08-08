package com.duff.client.service;

import java.util.List;

import com.duff.client.entity.Beer;
import com.duff.client.presenter.BeerPresenter;

/**
 * The Interface IBeerService.
 */
public interface IBeerService {
	
	/**
	 * Gets the playlist perfect beers.
	 *
	 * @param beers the beers
	 * @return the playlist perfect beers
	 */
	List<BeerPresenter> getPlaylistBeers(Integer temperature);

}
