package org.lobo.holidays.usecase.command;

import lombok.Builder;
import lombok.Data;

/**
 * The type Create hotel command.
 * @author joseluis.anton
 */
@Data
@Builder
public class CreateHotelCommand {

  private String name;
  private Integer stars;
  private String location;
  private String description;
}
