package com.example.demo.repository;


import com.example.demo.model.Card;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card>  findAllByJokeId(int jokeId);

}