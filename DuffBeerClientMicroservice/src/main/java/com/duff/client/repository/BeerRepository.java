/**
 * 
 */
package com.duff.client.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.duff.client.entity.Beer;


/**
 * The Interface BeerRepository.
 */
@Repository
public interface BeerRepository extends CrudRepository<Beer, Integer> {
	
	/**
	 * Find all by order by style asc.
	 *
	 * @return the list
	 */
	Optional<List<Beer>> findAllByOrderByStyleAsc();

	/**
	 * Find by style.
	 *
	 * @param style the style
	 * @return the optional
	 */
	Optional<Beer> findByStyle(String style);

}
