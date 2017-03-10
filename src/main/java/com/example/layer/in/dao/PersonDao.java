package com.example.layer.in.dao;

import com.example.layer.in.entity.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonDao {

	Mono<Person> getPerson(int id);

	Flux<Person> allPeople();

	Mono<Void> savePerson(Mono<Person> person);
	
}
