package embl.person.service;

import embl.person.person.body.PersonPostRequest;
import embl.person.repository.Hobby;
import embl.person.repository.Person;
import embl.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Encapsulate business logic related to person.
 */
@Transactional
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    /**
     * @param personPost Data required to create a new Person.
     * @return Newly created Person.
     */
    public void createPerson(Map<String, List<PersonPostRequest>> personPost) {
        personPost.get("Person").forEach(p -> {
            Person person = saveNewPersons(p);
            Person save = personRepository.save(person);
        });
    }

    private Person saveNewPersons(PersonPostRequest p) {
        Person person = new Person();
        person.setFirstName(p.getFirst_name());
        person.setLastName(p.getLast_name());
        person.setAge(p.getAge());
        person.setFavouriteColour(p.getFavourite_colour());
        for (String hobby : p.getHobby()) {
            Hobby newHobby = new Hobby();
            newHobby.setHobbies(hobby);
            person.getHobbies().add(newHobby);
        }
        return person;
    }

}
