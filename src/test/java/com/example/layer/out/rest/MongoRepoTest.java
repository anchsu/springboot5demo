package com.example.layer.out.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.layer.in.entity.PersonMongo;
import com.example.layer.in.repo.impl.MyMongoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoRepoTest {

	@Autowired
	private MyMongoRepository repo;
	
	
	
	
	@Test
	public void test() {
		this.repo.save(new PersonMongo("1", "1", 1));
		System.out.println(this.repo.findAll());
	}
	
	
}
