package com.perf.springbootkafkaapp.repo;

import com.perf.springbootkafkaapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

    Item findById(long id);
    
}