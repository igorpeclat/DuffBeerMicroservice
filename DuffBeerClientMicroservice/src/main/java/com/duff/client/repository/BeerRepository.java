/**
 * 
 */
package com.duff.client.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.duff.client.entity.Beer;

/**
 * The Interface BeerRepository.
 */
@Repository
public interface BeerRepository extends CrudRepository<Beer, Integer> {

	Optional<Beer> findByStyle(String style);

}
