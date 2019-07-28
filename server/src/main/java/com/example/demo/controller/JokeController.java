package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.exception.JokeNotFoundException;
import com.example.demo.model.Joke;

import com.example.demo.service.JokeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
public class JokeController {
    @Autowired
    private JokeService jokeservice;

       // Get All jokes
       @GetMapping(value="/api/jokes")
       public List<Joke> getAllJoke(){
           return jokeservice.findAllJokes();
       }
       @PostMapping(value = "/api/jokes")
       public Joke newJoke(@RequestBody Joke joke){
           return jokeservice.newJoke(joke);
       }
       @PutMapping(value = "/api/jokes/{id}")
       public Joke updateJoke(@PathVariable(name = "id") Integer jokeId, @RequestBody Joke joke){
           return jokeservice.updateJoke(jokeId, joke);
       }
   
       @DeleteMapping(value = "/api/jokes/{id}")
       public void deleteJoke(@PathVariable(name = "id") Integer id){
    	   jokeservice.deleteJoke(id);
       }
       @GetMapping(value="/api/xxx")
       public void run() {
    	   throw new EntityNotFoundException("CVICSE+++++");
       }
       @GetMapping("/jokes/{id}")
       public Joke getJokeById(@PathVariable(value="id") Integer jokeId) {
    	   try {
    		   return jokeservice.getJokeById(jokeId);
    	   }catch(JokeNotFoundException e){
    		   throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Joke not Found",e);
    	   }
       }
}