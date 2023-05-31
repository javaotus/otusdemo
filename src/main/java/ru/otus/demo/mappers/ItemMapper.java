package ru.otus.demo.mappers;

import org.mapstruct.Mapper;

import ru.otus.demo.dtos.ItemDto;
import ru.otus.demo.persistence.entitites.Item;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
public interface ItemMapper {
    Item toEntity(ItemDto ingredientDto);
    ItemDto toDto(Item ingredient);
    List<ItemDto> toDtoList(List<Item> ingredients);
    List<Item> toEntityList(List<ItemDto> ingredients);
}