package org.lobo.holidays.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.lobo.holidays.domain.Valuation;
import org.lobo.holidays.domain.ValuationStatus;
import org.lobo.holidays.port.driven.ValuationRepository;
import org.lobo.holidays.port.driven.guest.GuestPort;
import org.lobo.holidays.usecase.CreateValuationUseCase;
import org.lobo.holidays.usecase.GetHotelValuationsUseCase;
import org.lobo.holidays.usecase.command.CreateValuationCommand;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type Valuation service.
 * @author joseluis.anton
 */
@RequiredArgsConstructor
public class ValuationService implements CreateValuationUseCase, GetHotelValuationsUseCase {

  @NonNull
  private ValuationRepository valuationRepository;
  @NonNull
  private GuestPort guestPort;

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public Mono<Valuation> createValuation(CreateValuationCommand createValuation) {

   return guestPort.findGuestById(createValuation.getAuthorId()).map(author->{
     Valuation valuation=new Valuation();
     valuation.setStatus(ValuationStatus.DRAFT);
     valuation.setValue(createValuation.getValue());
     valuation.setComment(createValuation.getComment());
     valuation.setAuthor(author);
     return valuation;
   }).flatMap(valuation -> valuationRepository.createValuation(valuation,createValuation.getHotelId()));
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public Flux<Valuation> findValuationByHotel(Long hotelId) {
    return valuationRepository.findValuationByHotelId(hotelId);
  }
}
