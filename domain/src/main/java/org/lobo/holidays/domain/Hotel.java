package org.lobo.holidays.domain;

import java.util.List;
import lombok.Data;

/**
 * The type Hotel.
 *
 * @author joseluis.anton
 */
@Data
public class Hotel {
  private Long id;
  private Integer stars;
  private String name;
  private String description;
  private Float avgValuation;
  private String location;
  private List<Valuation> valuations;

}
