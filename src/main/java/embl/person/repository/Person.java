package embl.person.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Person Entity, represents a Person.
 *
 * @author Manuel Bouzas
 */
@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private String age;

    @Column(name = "favourite_colour")
    private String favouriteColour;

}
