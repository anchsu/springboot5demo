package com.example.layer.in.repo.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.layer.in.entity.Person;
import com.example.layer.in.repo.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonRepositoryImpl implements PersonRepository {

	private final Map<Integer, Person> people = new HashMap<>();
	
	public PersonRepositoryImpl() {
		this.people.put(1, new Person(1, "Foo", "Bar", 18));
		this.people.put(2, new Person(2, "Jane", "Doe", 36));
		this.people.put(3, new Person(3, "Jane", "Doe", 28));
		this.people.put(4, new Person(4, "Seb", "Devaux", 32));
		this.people.put(5, new Person(5, "Virginie", "Devaux", 30));
		this.people.put(6, new Person(6, "Layla", "Devaux", 1));
		
		this.people.put(7, new Person(7, "Seb", "Z", 32));
		this.people.put(8, new Person(8, "testAgeNull", "testAgeNull", null));
		this.people.put(9, new Person(9, null, "testFirstNameNull", 50));
		this.people.put(10, new Person(10, "testLastNameNull", null, 50));
		this.people.put(11, new Person(11, "testLastNameEmpty", "", 50));
		
	}

	@Override
	public Mono<Person> getPerson(int id) {
		return Mono.justOrEmpty(this.people.get(id));
	}

	@Override
	public Flux<Person> allPeople() {
		return Flux.fromIterable(this.people.values());
	}

	@Override
	public Mono<Void> savePerson(Mono<Person> personMono) {
		return personMono.then(person -> {
			int id = people.size() + 1;
			person.setIdentifier(id);
			people.put(id, person);
			System.out.format("Saved %s with id %d%n", person, id);
			return Mono.empty();
		});
	}
	
	
}
