package com.example.shopping.model.Mapper.Base;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface IEntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    default Set<E> toEntitySet(Collection<D> dtoList) {
        return toEntity(dtoList).collect(Collectors.toSet());
    };

    default Set <D> toDtoSet(Collection<E> entityList) {
        return toDto(entityList).collect(Collectors.toSet());
    };
    default List<E> toEntityList(Collection<D> dtoList) {
        return toEntity(dtoList).collect(Collectors.toList());
    };

    default List <D> toDtoList(Collection<E> entityList) {
        return toDto(entityList).collect(Collectors.toList());
    };
    default Stream<E> toEntity(Collection<D> dtoList) {
        return dtoList.stream()
                .filter(Objects::nonNull)
                .map(this::toEntity);
    };

    default Stream <D> toDto(Collection<E> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::toDto);
    };
}
