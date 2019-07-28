package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Joke;

public interface JokeService{
    public List<Joke> findAllJokes();
    public  Joke newJoke(Joke joke);
    public Joke updateJoke(Integer id,Joke newJoke);
    public void deleteJoke(Integer id);
    public Joke getJokeById(int id);
}