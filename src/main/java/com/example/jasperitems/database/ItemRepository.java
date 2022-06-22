package com.example.jasperitems.database;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {
    List<Item> findAll();
    Optional<Item> findById(Long id);
}
