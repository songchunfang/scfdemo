package com.example.demo.controller;

import java.util.List;


import com.example.demo.model.Card;

import com.example.demo.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    private CardService cardService;

       // Get All Cards
       @GetMapping(value="/api/cards")
       public List<Card> getAllCard(){
           return cardService.findAllCards();
       }
       @PostMapping(value = "/api/cards")
       public Card newCard(@RequestBody Card card){
           return cardService.newCard(card);
       }
       @PutMapping(value = "/api/cards/{id}")
       public Card updateCard(@PathVariable(name = "id") Integer cardId, @RequestBody Card card){
           return cardService.updateCard(cardId, card);
       }
   
       @DeleteMapping(value = "/api/cards/{id}")
       public void deleteCard(@PathVariable(name = "id") Integer id){
           cardService.deleteCard(id);
       }
}