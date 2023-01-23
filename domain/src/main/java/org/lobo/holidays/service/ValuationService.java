package org.lobo.holidays.service;

import org.lobo.holidays.domain.Valuation;
import org.lobo.holidays.domain.ValuationStatus;
import org.lobo.holidays.port.driven.ValuationRepository;
import reactor.core.publisher.Mono;

/**
 * The type Valuation service.
 * @author joseluis.anton
 */
public class ValuationService {
  private ValuationRepository valuationRepository;

  /**
   * Validate valuation.
   *
   * @param valuation the valuation
   * @return the valuation
   */
  public Mono<Valuation> validate(Valuation valuation){
    //TODO SOME MORE LOGIC :)
    valuation.setStatus(ValuationStatus.APPROVED);
    return valuationRepository.updateValuation(valuation);
  }
}
