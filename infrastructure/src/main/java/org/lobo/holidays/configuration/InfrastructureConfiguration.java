package org.lobo.holidays.configuration;

import org.lobo.holidays.mapper.HotelMapper;
import org.lobo.holidays.port.driven.HotelRepository;
import org.lobo.holidays.service.HotelService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "org.lobo.holidays.persistence.repository" )
@ComponentScan("org.lobo.holidays")
public class InfrastructureConfiguration {

  @Bean
  public HotelService hotelService(HotelRepository hotelRepository){
    return new HotelService(hotelRepository);
  }
}
