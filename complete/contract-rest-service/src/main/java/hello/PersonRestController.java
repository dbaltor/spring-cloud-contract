package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;
import javax.validation.Valid;

@RestController
class PersonRestController {

	private final PersonService personService;

	public PersonRestController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/persons/{id}")
	public Person findPersonById(@PathVariable("id") Long id) {
		return personService.findPersonById(id);
	}

	@PostMapping(path = "/persons")
	public ResponseEntity<PersonId> createUser(@RequestBody /*@Valid*/ Person person) {
		var createdPerson = personService.createPerson();
	  	return ResponseEntity
			.status(201)
			.body(new PersonId(createdPerson.getId()));
	}

	@PutMapping(path = "/persons/{id}")
	public ResponseEntity<Person> updatePerson(@RequestBody @Valid Person person, @PathVariable long id) {
		/*System.out.println("Person to update:");
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getSurname());*/
		var updatedPerson = personService.updatePerson(id, person);

		System.out.println("Person updated:");
		System.out.println(updatedPerson);

		return ResponseEntity.ok(updatedPerson);
	}
}
