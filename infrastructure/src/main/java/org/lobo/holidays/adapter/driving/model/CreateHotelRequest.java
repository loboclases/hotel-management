package org.lobo.holidays.adapter.driving.model;

import lombok.Data;

@Data
public class CreateHotelRequest {
  private Integer stars;
  private String name;
  private String description;
  private String location;
}
