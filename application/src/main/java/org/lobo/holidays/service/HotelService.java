package org.lobo.holidays.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.lobo.holidays.domain.Hotel;
import org.lobo.holidays.port.driven.HotelRepository;
import org.lobo.holidays.usecase.CreateHotelUseCase;
import org.lobo.holidays.usecase.command.CreateHotelCommand;
import reactor.core.publisher.Mono;

/**
 * The type Hotel service.
 * @author joseluis.anton
 */
@RequiredArgsConstructor
public class HotelService implements CreateHotelUseCase {

  @NonNull
  private HotelRepository hotelRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public Mono<Hotel> createHotel(CreateHotelCommand createHotelCommand) {
    Hotel hotel=new Hotel();
    hotel.setName(createHotelCommand.getName());
    hotel.setDescription(createHotelCommand.getDescription());
    hotel.setStars(createHotelCommand.getStars());
    hotel.setLocation(createHotelCommand.getLocation());
    hotel.setAvgValuation(0.0f);
    return hotelRepository.saveHotel(hotel);
  }
}
