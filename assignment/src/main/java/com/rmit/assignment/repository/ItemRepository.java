package com.rmit.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rmit.assignment.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    void deleteById(Long id);

}
