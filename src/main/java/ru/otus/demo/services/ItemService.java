package ru.otus.demo.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.otus.demo.dtos.ItemDto;
import ru.otus.demo.exceptions.Code404ItemNotFoundException;
import ru.otus.demo.persistence.entitites.Item;
import ru.otus.demo.persistence.repositories.ItemRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public List<Item> getAllIn(List<UUID> ids) {
        return itemRepository.findAllById(ids);
    }

    public Item getOne(UUID id) {
        return itemRepository.findById(id).orElseThrow(() -> new Code404ItemNotFoundException(Item.class, id));
    }

    public Item createOne(String name, boolean available) {
        return mergeEntityResult(Item.builder().name(name).available(available).build());
    }

    @Transactional
    public Item updateOne(UUID id, ItemDto itemDto) {
        Item old = getOne(id);
        old.setName(itemDto.getName());
        old.setAvailable(itemDto.isAvailable());
        return mergeEntityResult(old);
    }

    public void deleteOne(UUID id) {
        itemRepository.deleteById(id);
    }

    private Item mergeEntityResult(Item item) {
        return itemRepository.save(item);
    }

}