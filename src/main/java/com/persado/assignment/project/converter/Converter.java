package com.persado.assignment.project.converter;

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

}
