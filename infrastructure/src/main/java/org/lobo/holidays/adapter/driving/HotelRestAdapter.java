package org.lobo.holidays.adapter.driving;

import org.lobo.holidays.adapter.driving.model.CreateHotelRequest;
import org.lobo.holidays.domain.Hotel;
import org.lobo.holidays.usecase.CreateHotelUseCase;
import org.lobo.holidays.usecase.command.CreateHotelCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * The type Hotel rest adapter.
 */
@RestController
@RequestMapping("/hotels")
public class HotelRestAdapter {

  @Autowired
  private CreateHotelUseCase createHotelUseCase;

  /**
   * Create hotel mono.
   *
   * @param createHotelRequest the create hotel request
   * @return the mono
   */
  @PostMapping
  public Mono<Hotel> createHotel(@RequestBody CreateHotelRequest createHotelRequest){
    CreateHotelCommand createHotelCommand=CreateHotelCommand.builder()
        .stars(createHotelRequest.getStars())
        .name(createHotelRequest.getName())
        .description(createHotelRequest.getDescription())
        .location(createHotelRequest.getLocation())
        .build();
    return createHotelUseCase.createHotel(createHotelCommand);
  }
}
