package embl.person.service;

import embl.person.person.body.PersonRequest;
import embl.person.repository.Hobby;
import embl.person.repository.HobbyRepository;
import embl.person.repository.Person;
import embl.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Autowired
    HobbyRepository hobbyRepository;
    /**
     * @param personPost Data required to create a new Person.
     * @return Newly created Person.
     */
    public void createPerson(Map<String, List<PersonRequest>> personPost) {
        personPost.get("Person").forEach(p -> {
            Person person = new Person();
            person = saveNewPersons(p, person);
            Person save = personRepository.save(person);
        });
    }

    /**
     * @param personId Id of the configuration.
     * @return Configuration with the given id.
     */
    public Person findPersonById(long personId) {
        Person person = personRepository.findById(personId).orElse(null);
        if (person == null) {
            throw new EntityNotFoundException("No person found with id \"" + personId + "\".");
        }
        return person;
    }
    /**
     * @param personId Id of the Person to be updated.
     * @param personRequest Data to be set in the Person with the given id.
     * @return Updated configuration.
     */
    public Person updatePerson(long personId, Map<String,PersonRequest> personRequest) {
        Person person = findPersonById(personId);
        hobbyRepository.deleteByPersonId(String.valueOf(person.getId()));
        person.getHobbies().removeAll(person.getHobbies());
        person = saveNewPersons(personRequest.get("Person"), person);
        return personRepository.save(person);
    }



    private Person saveNewPersons(PersonRequest p, Person person) {

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

    private Person updatePerson(PersonRequest p, Person person){
        person.setFirstName(p.getFirst_name());
        person.setLastName(p.getLast_name());
        person.setAge(p.getAge());
        person.setFavouriteColour(p.getFavourite_colour());
        //person.getHobbies().removeAll(person.getHobbies());
        for (String hobby : p.getHobby()) {
            Hobby newHobby = new Hobby();
            newHobby.setHobbies(hobby);
            person.getHobbies().add(newHobby);
        }
        return person;
    }
}
