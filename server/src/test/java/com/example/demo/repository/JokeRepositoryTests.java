package com.example.demo.repository;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Joke;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeRepositoryTests {
@Autowired
JokeRepository jokeRepository;
Joke joke1,joke2;
@Before
public void setup() {
	this.jokeRepository.deleteAll();
	joke1=new Joke();
	joke1.setId(4);
	joke1.setContent("content1111");
	joke1.setTitle("title1111");
	jokeRepository.save(joke1);
	joke2=new Joke();
	joke2.setId(5);
	joke2.setContent("content2222");
	joke2.setTitle("title122222");
	jokeRepository.save(joke2);
}
@Test
public void getJokeList_then_returnJokeList() {
	List<Joke> jokeList=this.jokeRepository.findAll();
	assertThat(jokeList.size()).isEqualTo(2);
	Joke joke=jokeList.get(0);
	assertThat(joke.getTitle()).isNotNull();
	assertThat(joke).extracting("content").contains("11111");
	}
@After
public void cleanJokes() {
	this.jokeRepository.deleteAll();
}
}
