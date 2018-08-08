/**
 * 
 */
package com.duff.client.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duff.client.entity.Beer;
import com.duff.client.exception.BeerNotFoundException;
import com.duff.client.presenter.BeerPresenter;
import com.duff.client.presenter.Playlist;
import com.duff.client.repository.BeerRepository;
import com.google.common.collect.Lists;

/**
 * The Class BeerService.
 *
 */
@Service
public class BeerService implements IBeerService {

	/** The beer repository. */
	@Autowired
	private BeerRepository beerRepository;

	@Autowired
	private SpotifyService spotifyService;

	@Override
	public List<BeerPresenter> getPlaylistBeers(Integer temperature) {

		List<Beer> beers = beerRepository.findAllByOrderByStyleAsc().orElseThrow(() -> new BeerNotFoundException());
		//Discover the average value between the temperatures of the beers
		beers.forEach(beer -> {
			beer.setAverageTemperature(
					Math.subtractExact(Math.addExact(beer.getMinTemperature(), beer.getMaxTemperature()), 2));
		});

		 
		return spotifyService.findPlaylistByBeerNameStyle(
				beers.stream()
				.filter(e -> e.getAverageTemperature().equals(beers.stream()
				.map(Beer::getAverageTemperature)
				.min(Comparator.comparingInt(i -> Math.abs(i - temperature))).get()))
				.map(Beer::getStyle)
				.collect(Collectors.toList()));
	}

}
