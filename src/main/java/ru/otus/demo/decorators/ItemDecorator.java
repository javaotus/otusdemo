package ru.otus.demo.decorators;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import ru.otus.demo.dtos.ItemDto;
import ru.otus.demo.mappers.ItemMapper;
import ru.otus.demo.services.ItemService;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ItemDecorator {

    private final ItemMapper itemMapper;
    private final ItemService itemService;

    public List<ItemDto> getAll() {
        return itemMapper.toDtoList(itemService.getAll());
    }

    public ItemDto getOne(UUID id) {
        return itemMapper.toDto(itemService.getOne(id));
    }

    public ItemDto createOne(String name, boolean vegetable) {
        return itemMapper.toDto(itemService.createOne(name, vegetable));
    }

    public ItemDto updateOne(UUID id, ItemDto ingredientDto) {
        return itemMapper.toDto(itemService.updateOne(id, ingredientDto));
    }

    public void deleteOne(UUID id) {
        itemService.deleteOne(id);
    }

}