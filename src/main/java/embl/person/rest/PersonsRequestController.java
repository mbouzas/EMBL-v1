package embl.person.rest;


import embl.person.repository.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api")
public class PersonsRequestController {


    /**
     * @param personId to fetch the data Person.
     * @return List of Instructions associated to the given id
     */
    @GetMapping("/person/{personId}")
    public  Person findPerson(@PathVariable String personId) {
        return null;

    }

    /**
     * @param Person List of Persons to store in the DB.
     * @return List of Persons
     */
    @PostMapping("/persons")
    public Collection<String> persons(@Valid @RequestBody Set<String> Person) {
        return null;

    }

    /**
     * @param personId   person will be removed
     */
    @DeleteMapping("/person/{personId}")
    public void deletePerson(@PathVariable String personId) {
    }




}