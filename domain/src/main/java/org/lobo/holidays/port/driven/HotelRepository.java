package org.lobo.holidays.port.driven;

import org.lobo.holidays.domain.Hotel;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

/**
 * The interface Hotel repository.
 *
 * @author joseluis.anton
 */
public interface HotelRepository {

  /**
   * Find hotel by id.
   *
   * @param id the id
   * @return the mono
   */
  Mono<Hotel> findHotelById(Long id);

  /**
   * Find hotel by name.
   *
   * @param name the name
   * @return the flux
   */
  Flux<Hotel> findHotelByName(String name);

  /**
   * Save hotel.
   *
   * @param hotel the hotel
   * @return the mono
   */
  Mono<Hotel> saveHotel(Hotel hotel);
}
