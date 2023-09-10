package ru.otus.demo.controllers;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.otus.demo.decorators.ItemDecorator;
import ru.otus.demo.dtos.ItemDto;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemDecorator itemDecorator;

    @GetMapping("/{id}")
    public ItemDto one(@PathVariable UUID id) {
        return itemDecorator.getOne(id);
    }

    @GetMapping
    public List<ItemDto> all() {
        return itemDecorator.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto create(@RequestParam String name, @RequestParam boolean available) {
        return itemDecorator.createOne(name, available);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        itemDecorator.deleteOne(id);
    }

    @PutMapping("/{id}")
    public ItemDto update(@PathVariable UUID id, @RequestBody ItemDto itemDto) {
        return itemDecorator.updateOne(id, itemDto);
    }

//    @RabbitListener(queues = "${otus.rabbitmq.queue}")
//    public void listenTo(Message message) {
//        try {
//            String reqMessage = new String(message.getBody(), StandardCharsets.UTF_8);
//            System.out.println(reqMessage);
//        } catch (Throwable th) {
//            log.error("Fatal error: can't process Generated Report response", th);
//        }
//    }

}