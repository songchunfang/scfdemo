package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Joke;
import com.example.demo.repository.JokeRepository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;;
@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeServiceTests {
@Autowired
JokeService jokeservice;
@MockBean
JokeRepository jokerepository;
@Before
public void setup() {
	jokerepository.deleteAll();
	Joke joke=new Joke("Joke1");
	joke.setId(11);
	Joke joke1=new Joke("Joke2");
	joke1.setId(22);
	List<Joke> allJokes=Arrays.asList(joke,joke1);
	Mockito.when(jokerepository.findById(joke.getId())).thenReturn(Optional.of(joke));
	Mockito.when(jokerepository.findById(joke.getId())).thenReturn(Optional.of(joke));
	Mockito.when(jokerepository.findById(0)).thenReturn(null);
	Mockito.when(jokerepository.save(new Joke("Joke2"))).thenReturn(joke1);
	Mockito.when(jokerepository.findAll()).thenReturn(allJokes);
}
@Test
public void given2Jokes_when_getAllJokes_thenReturn2Records() {
	Joke joke= new Joke("Joke1");
	Joke joke1= new Joke("Joke2");
	List<Joke> allJokes=this.jokeservice.findAllJokes();
	assertThat(allJokes).hasSize(2).extracting(Joke::getTitle).contains(joke.getTitle(),joke1.getTitle());
}
@Test
public void givenRightJokeId_ThenReturnJoke() {
	Joke joke=this.jokeservice.getJokeById(11);
	assertThat(joke).extracting("title").contains("Joke1");
}
}
