package org.lobo.holidays.usecase;

import org.lobo.holidays.domain.Valuation;
import org.lobo.holidays.usecase.command.CreateValuationCommand;
import reactor.core.publisher.Mono;

/**
 * The interface Create valuation use case.
 *
 * @author joseluis.anton
 */
public interface CreateValuationUseCase {

  /**
   * Create valuation. The valuation will be created in Draft Status, so it will need to be approved afterward
   *
   * @param createValuation the create valuation
   * @return the mono
   */
  Mono<Valuation> createValuation(CreateValuationCommand createValuation);

}
