package org.lobo.holidays.adapter.driven;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.lobo.holidays.adapter.driven.persistence.repository.DatabaseHotelRepository;
import org.lobo.holidays.domain.Hotel;
import org.lobo.holidays.mapper.HotelMapper;
import org.lobo.holidays.port.driven.HotelRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HotelRepositoryImpl implements HotelRepository {

  @NonNull
  private DatabaseHotelRepository hotelRepository;
  @NonNull
  private HotelMapper hotelMapper;


  @Override
  public Mono<Hotel> findHotelById(Long id) {
    return hotelRepository.findById(id).map(hotelMapper::entityToDomain);
  }

  @Override
  public Flux<Hotel> findHotelByName(String name) {
    return hotelRepository.findByName(name).map(hotelMapper::entityToDomain);
  }

  @Override
  public Mono<Hotel> saveHotel(Hotel hotel) {
    return Mono.just(hotel).map(hotelMapper::domainToEntity).flatMap(hotelRepository::save).map(hotelMapper::entityToDomain);
  }
}
