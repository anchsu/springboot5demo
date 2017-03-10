package com.example.layer.process.action;

import com.example.layer.in.entity.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonAction {

	Mono<Person> getPerson(int id);

	Flux<Person> allPeople();

	Mono<Void> savePerson(Mono<Person> person);
	
}
