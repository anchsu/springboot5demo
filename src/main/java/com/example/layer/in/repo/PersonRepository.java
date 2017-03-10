package com.example.layer.in.repo;

import com.example.layer.in.entity.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * https://github.com/spring-projects/spring-data-examples/tree/master/mongodb/reactive
 * 
 * @author ex200
 *
 */
public interface PersonRepository {

	Mono<Person> getPerson(int id);

	Flux<Person> allPeople();

	Mono<Void> savePerson(Mono<Person> person);

}
