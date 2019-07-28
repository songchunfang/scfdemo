package com.example.demo.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.exception.JokeNotFoundException;
import com.example.demo.model.Joke;
import com.example.demo.repository.JokeRepository;
import com.example.demo.service.JokeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class  JokeServiceImpl implements JokeService{
    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public List<Joke> findAllJokes(){
        List<Joke> jokes=jokeRepository.findAll();
        return jokes;
    }
    @Override
    public Joke newJoke(Joke joke){
        return jokeRepository.save(joke);
    }
    @Override
    public Joke updateJoke(Integer id,Joke newJoke){
        try {
        	return jokeRepository.findById(id).get();
        }catch(JokeNotFoundException e) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Joke Not Found");
        }
    	//Joke joke = jokeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        //joke.setContent(newJoke.getContent());
       // joke.setTitle(newJoke.getTitle());

       // return jokeRepository.save(joke);
    }
    @Override
    public void deleteJoke(Integer id){
        jokeRepository.deleteById(id);
}
public Joke getJokeById(int id) throws JokeNotFoundException{
	
		return jokeRepository.findById(id).orElseThrow(()->new JokeNotFoundException("Joke Can not found in JokePepository"));

}
}