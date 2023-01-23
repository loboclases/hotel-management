package org.lobo.holidays.usecase;

import org.lobo.holidays.domain.Valuation;
import reactor.core.publisher.Flux;

/**
 * The interface Get hotel valuations use case.
 * @author joseluis.anton
 */
public interface GetHotelValuationsUseCase {

  /**
   * Find valuation by hotel flux.
   *
   * @param hotelId the hotel id
   * @return the flux
   */
  Flux<Valuation> findValuationByHotel(Long hotelId);
}
