package org.lobo.holidays.port.driven;

import org.lobo.holidays.domain.Valuation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The interface Valuation repository.
 *
 * @author joseluis.anton
 */
public interface ValuationRepository {

  /**
   * Create valuation.
   *
   * @param valuation the valuation
   * @param hotelId   the hotel id
   * @return the mono
   */
  Mono<Valuation> createValuation(Valuation valuation, Long hotelId);

  /**
   * Update valuation mono.
   *
   * @param valuation the valuation
   * @return the mono
   */
  Mono<Valuation> updateValuation(Valuation valuation);

  /**
   * Find valuation mono.
   *
   * @param valuationId the valuation id
   * @return the mono
   */
  Mono<Valuation> findValuation(Long valuationId);

  /**
   * Find valuation by hotel id.
   *
   * @param hotelId the hotel id
   * @return the flux
   */
  Flux<Valuation> findValuationByHotelId(Long hotelId);

  /**
   * Find valuation by author.
   *
   * @param authorId the author id
   * @return the flux
   */
  Flux<Valuation> findValuationByAuthor(Long authorId);
}
