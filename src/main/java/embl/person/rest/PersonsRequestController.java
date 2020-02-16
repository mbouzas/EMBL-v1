package embl.person.rest;


import embl.person.person.body.PersonRequest;
import embl.person.repository.Person;
import embl.person.repository.PersonRepository;
import embl.person.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Provides the REST calls for Person
 *
 * @author Manuel Bouzas
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class PersonsRequestController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    /**
     * @return  Map of all Persons.
     */
    @GetMapping("/person")
    public Map< String ,List<Person>> findAllPersons() {
        return personService.findAllPersons() ;
    }

    /**
     * @return  a Person.
     */
    @GetMapping("/person/{personId}")
    public Person findPerson( @PathVariable long personId) {
        return personService.findPersonById(personId) ;
    }


    /**
     * @param person List of Persons to store in the DB.
     * @return List of Persons.
     */
    @PostMapping("/persons")
    public void persons(@Valid @RequestBody Map<String,List<PersonRequest>> person) {
        personService.createPerson(person);
    }

    /**
     * @param personId Id of the Person to be updated.
     * @param updatePerson Data required to update an existing Person.
     * @return The updated Person.
     */
    @PutMapping("/person/{personId}")
    public Person updateConfig(
            @PathVariable long personId,
            @RequestBody Map<String,PersonRequest> updatePerson) {
        return personService.updatePerson(personId, updatePerson);
    }

    /**
     * @param personId   person will be removed.
     */
    @DeleteMapping("/person/{personId}")
    public void deletePerson(@PathVariable long personId) {
        personRepository.deleteById(personId);
    }

}
