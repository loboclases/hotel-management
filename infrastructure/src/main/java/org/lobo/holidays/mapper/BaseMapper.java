package org.lobo.holidays.mapper;

import java.util.List;

/**
 * The interface Base mapper.
 *
 * @param <D> the Domain type parameter
 * @param <E> the Entity type parameter
 * @author joseluis.anton
 */
public interface BaseMapper<D,E> {
  D entityToDomain(E entity);
  E domainToEntity(D domain);
  List<D> entityToDomain(List<E> entities);
  List<E> domainToEntity(List<D> domains);
}
