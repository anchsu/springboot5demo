package com.example.layer.out.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.layer.in.entity.Person;
import com.example.layer.process.action.PersonAction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonAction personAction;

	@GetMapping()
	public Flux<Person> getPerson() {
		System.out.println("getPerson! ");
		return personAction.allPeople();
	}
	
	@GetMapping("/name")
	public Flux<String> getPersonNames() {
		System.out.println("getPersonNames! ");
		return personAction.allPeople().map(Person::getLastName);
	}
	
	@GetMapping("/adults")
	public Flux<Person> getAdults() {
		System.out.println("getadults! ");
		return personAction.allPeople().filter(person -> person.getAge() > 17);
	}
	
	@GetMapping(value = "/{identifier}")
	public Mono<Person> getPersonBy(@PathVariable("identifier") final int identifier) {
		System.out.println("getPersonBy! " +identifier);
		return personAction.getPerson(identifier);
	}
	
	@PostMapping()
	public Mono<Void> savePerson(@RequestBody final Mono<Person> persons) {
		System.out.println("savePerson!");
		return personAction.savePerson(persons);
	}
	
	
	
}
