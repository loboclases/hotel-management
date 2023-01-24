package org.lobo.holidays.adapter.driven.persistence.repository;

import org.lobo.holidays.adapter.driven.persistence.model.HotelEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * The type Database hotel repository.
 * @author joseluis.anton
 */
public interface DatabaseHotelRepository extends ReactiveCrudRepository<HotelEntity,Long> {

  @Query("select * from hotel where name=:name")
  Flux<HotelEntity> findByName(@Param("name") String name);
}
