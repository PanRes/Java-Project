package com.persado.assignment.project.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Converter interface.
 *
 * @param <D> the domain type parameter
 * @param <T> the transport(dto) type parameter
 */
public interface Converter<D, T> {

	/**
	 * Transforms a transport object to domain.
	 *
	 * @param dto the dto
	 * @return the entity
	 */
	D toEntity(final T dto);

	/**
	 * Transforms a domain object to transport.
	 *
	 * @param entity the entity
	 * @return the dto
	 */
	T toDto(final D entity);

	/**
	 * Transforms a {@link Collection} of transport objects to a {@link List} of domain objects.
	 *
	 * @param dtos the dtos
	 * @return the list of entities
	 */
	default List<D> toEntitiesList(final Collection<T> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	/**
	 * Transforms a {@link Collection} of domain objects to a {@link List} of transport objects.
	 *
	 * @param entities the entities
	 * @return the list of dtos
	 */
	default List<T> toDtosList(final Collection<D> entities) {
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}


}
