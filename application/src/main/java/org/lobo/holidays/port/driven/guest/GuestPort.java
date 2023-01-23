package org.lobo.holidays.port.driven.guest;

import org.lobo.holidays.domain.Guest;
import reactor.core.publisher.Mono;

/**
 * The interface Guest port.
 * @author joseluis.anton
 */
public interface GuestPort {

  /**
   * Find guest by id mono.
   *
   * @param id the id
   * @return the mono
   */
  Mono<Guest> findGuestById(Long id);
}
