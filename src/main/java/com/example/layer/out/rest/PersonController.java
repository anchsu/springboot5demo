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
import reactor.util.function.Tuple2;

/**
 * https://www.youtube.com/watch?v=vksw3j0uOZo
 * 
 * http://rxmarbles.com/#amb
 * 
 * @author ex200
 *
 */
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
	
	@GetMapping(value="/name")
	public Flux<String> getPersonNames() {
		System.out.println("getPersonNames! ");
		return personAction.allPeople().map(Person::getLastName);
	}
	
	@GetMapping(value="/adults")
	public Flux<Person> getAdults() {
		System.out.println("getadults! ");
		return personAction.allPeople().filter(person -> person.getAge() != null && person.getAge() > 17);
	}
	
	@GetMapping(value = "/{identifier}")
	public Mono<Person> getPersonBy(@PathVariable("identifier") final int identifier) {
		System.out.println("getPersonBy! " +identifier);
		return personAction.getPerson(identifier);
	}
	
	@PostMapping()
	public Mono<Void> savePerson(@RequestBody final Mono<Person> person) {
		System.out.println("savePerson!");
		return personAction.savePerson(person);
	}
	
	@GetMapping(value = "/test")
	public Flux<Person> test() {
		System.out.println("test! ");
		
		// result empty stream
//		return personAction.allPeople().ignoreElements();

		// first elemt
		//return personAction.allPeople().next();

		// somme des ages
		//return personAction.allPeople().filter(person -> person.getAge() != null).reduce(0, (somme, person) -> somme + person.getAge());

		// somme des ages
//		return personAction.allPeople().filter(person -> person.getAge() != null).map(Person::getAge).reduce(0, (somme, age) -> somme + age);
		
		//return personAction.allPeople().blockFirst();

        //return personAction.allPeople().elapsed();

        return this.getAdults().mergeWith(this.getPerson())
                .doOnNext(System.out::println)
                .doAfterTerminate((() -> System.out.println("end")));

    }
		
}
