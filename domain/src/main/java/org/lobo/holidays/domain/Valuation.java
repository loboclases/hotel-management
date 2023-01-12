package org.lobo.holidays.domain;

import lombok.Data;

/**
 * The type Valuation.
 *
 * @author joseluis.anton
 */
@Data
public class Valuation {

  private Float value;
  private String comment;
  private Guest author;
}
