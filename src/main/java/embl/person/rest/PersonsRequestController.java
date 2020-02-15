package embl.person.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import embl.person.person.body.PersonPostRequest;
import embl.person.repository.Person;
import embl.person.repository.PersonRepository;
import embl.person.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class PersonsRequestController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    /**
     * @return List of Instructions associated to the given id
     */
    @GetMapping("/person")
    public Map< String ,List<Person>> findAllPersons() {
        List<Person> people = personRepository.findAll();
        Map< String ,List<Person>> stringListMap = new HashMap<>();
        stringListMap.put("Person", people);

        //HashMap<String, Object> hashmap = new HashMap<String, Object>();
        //ObjectMapper mapper = new ObjectMapper();
        //String json = null;
        //try {
        //     json = mapper.writeValueAsString(stringListMap);
        //} catch (JsonProcessingException e) {
        //    e.printStackTrace();
        //}

        return stringListMap ;

    }

    @GetMapping("/person/{personId}")
    public  List<Person> findPerson(@PathVariable String personId) {
        return personRepository.findAll();

    }
    /**
     * @param person List of Persons to store in the DB.
     * @return List of Persons
     */
    @PostMapping("/persons")
    public void persons(@Valid @RequestBody Map<String,List<PersonPostRequest>> person) {

        personService.createPerson(person);

    }

    /**
     * @param personId   person will be removed
     */
    @DeleteMapping("/person/{personId}")
    public void deletePerson(@PathVariable String personId) {
    }




}
