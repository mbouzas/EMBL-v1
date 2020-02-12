package embl.person.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Person Entity, represents a Person.
 *
 * @author Manuel Bouzas
 */
@Entity
@Table(name = "Person")
public class Person {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private String age;

    @Column(name = "favourite_colour")
    private String favouriteColour;

}
