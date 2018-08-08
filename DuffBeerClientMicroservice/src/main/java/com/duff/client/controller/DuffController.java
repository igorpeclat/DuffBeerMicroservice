package com.duff.client.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.duff.client.entity.Beer;
import com.duff.client.exception.BeerNotFoundException;
import com.duff.client.exception.BeerStyleExistException;
import com.duff.client.param.DuffBeerTemperatureParam;
import com.duff.client.repository.BeerRepository;
import com.duff.client.service.BeerService;

/**
 * The Class DuffController.
 */
@RestController
@RequestMapping("beer")
public class DuffController {

	/** The beer repository. */
	@Autowired
	private BeerRepository beerRepository;
	@Autowired
	private BeerService beerService;
	
	
	/**
	 * Save.
	 *
	 * @param beer the beer
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Beer beer) {
		validateStyleCreated(beer.getStyle());
		URI location = buildURI(beer);
		return ResponseEntity.created(location).build();
	}
	
	/**
	 * Update.
	 *
	 * @param beer the beer
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Beer beer) {
		beer = validateStyleExists(beer.getStyle());
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Delete.
	 *
	 * @param style the style
	 * @return the response entity
	 */
	@DeleteMapping("{style}")
	public ResponseEntity<?> delete(@PathVariable("style") String style) {
		beerRepository.delete(validateStyleExists(style));
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Gets the.
	 *
	 * @param style the style
	 * @return the response entity
	 */
	@GetMapping("{style}")
	public ResponseEntity<?> find(@PathVariable("style") String style) {
		return ResponseEntity.ok(validateStyleExists(style));
	}
	
	/**
	 * Find all.
	 *
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(validateFindAll());
	}
	
	/**
	 * Gets the beer by average temperature.
	 *
	 * @param temperature the temperature
	 * @return the beer by average temperature
	 */
	@PostMapping("temperature")
	public ResponseEntity<?> getBeerByAverageTemperature(@RequestBody DuffBeerTemperatureParam param) {
		return ResponseEntity.ok(beerService.getPlaylistBeers(param.getTemperature()));
	}

	/**
	 * Builds the URI.
	 *
	 * @param beer the beer
	 * @return the uri
	 */
	private URI buildURI(Beer beer) {
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{style}")
				.buildAndExpand(beerRepository.save(beer).getStyle())
				.toUri();
		return location;
	}
	
	/**
	 * Verify the {@literal style} exists.
	 *
	 * @param style
	 */
	private Beer validateStyleExists(String style) {
		return this.beerRepository
			.findByStyle(style)
			.orElseThrow(() -> new BeerNotFoundException(style));
	}
	
	/**
	 * Verify the {@literal style} exists.
	 *
	 * @param style
	 */
	private List<Beer> validateFindAll() {
		return this.beerRepository
			.findAllByOrderByStyleAsc()
			.orElseThrow(() -> new BeerNotFoundException());
	}
	
	/**
	 * Verify the {@literal style} already exists.
	 *
	 * @param style the style
	 */
	private void validateStyleCreated(String style) {
		if (this.beerRepository.findByStyle(style).isPresent()) {
		    throw new BeerStyleExistException();
		}
	}

}
