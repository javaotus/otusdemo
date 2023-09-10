package ru.otus.demo.decorators;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import ru.otus.demo.dtos.ItemDto;
import ru.otus.demo.mappers.ItemMapper;
import ru.otus.demo.services.ItemService;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemDecorator {
    private final AmqpTemplate amqpTemplate;

    private final Binding binding;
    private final ItemMapper itemMapper;
    private final ItemService itemService;

    public List<ItemDto> getAll() {
        return itemMapper.toDtoList(itemService.getAll());
    }

    public ItemDto getOne(UUID id) {

        String uuid = UUID.randomUUID().toString();

        amqpTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), uuid);

        log.info("The message has been send! --> {}", uuid);

        return null;
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