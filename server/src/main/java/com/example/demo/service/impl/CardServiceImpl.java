package com.example.demo.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import com.example.demo.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  CardServiceImpl implements CardService{
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> findAllCards(){
        List<Card> cards=cardRepository.findAll();
        return cards;
    }
    @Override
    public Card newCard(Card card){
        return cardRepository.save(card);
    }
    @Override
    public Card updateCard(Integer id,Card newCard){
        Card card = cardRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        card.setContent(newCard.getContent());
        card.setJokeId(newCard.getJokeId());

        return cardRepository.save(card);
    }
    @Override
    public void deleteCard(Integer id){
        cardRepository.deleteById(id);
}
	@Override
	public List<Card> getCardByJokeId(Integer jokeId) {
		return cardRepository.findAllByJokeId(jokeId);
	}
}