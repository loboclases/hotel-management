package org.lobo.holidays.usecase.command;

import lombok.Builder;
import lombok.Data;
import org.lobo.holidays.domain.Guest;

/**
 * The type Create valuation command.
 * @author joseluis.anton
 */
@Data
@Builder
public class CreateValuationCommand {
  private Float value;
  private String comment;
  private Long authorId;
  private Long hotelId;
}
