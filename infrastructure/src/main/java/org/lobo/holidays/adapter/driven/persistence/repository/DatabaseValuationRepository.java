package org.lobo.holidays.adapter.driven.persistence.repository;

import org.lobo.holidays.adapter.driven.persistence.model.ValuationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * The type Database hotel repository.
 * @author joseluis.anton
 */
public interface DatabaseValuationRepository extends ReactiveCrudRepository<ValuationEntity,Long> {

}
