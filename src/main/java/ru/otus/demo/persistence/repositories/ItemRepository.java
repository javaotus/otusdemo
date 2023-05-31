package ru.otus.demo.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.otus.demo.persistence.entitites.Item;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {}