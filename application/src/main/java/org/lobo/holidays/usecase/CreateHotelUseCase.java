package org.lobo.holidays.usecase;

import org.lobo.holidays.domain.Hotel;
import org.lobo.holidays.usecase.command.CreateHotelCommand;
import reactor.core.publisher.Mono;

/**
 * The interface Create hotel use case.
 * @author joseluis.anton
 */
public interface CreateHotelUseCase {

  /**
   * Create hotel.
   *
   * @param createHotelCommand the hotel
   * @return the mono
   */
  Mono<Hotel> createHotel(CreateHotelCommand createHotelCommand);
}
