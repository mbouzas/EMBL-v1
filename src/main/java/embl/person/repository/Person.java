package embl.person.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Person Entity, represents a Person.
 *
 * @author Manuel Bouzas
 */
@Entity(name = "Person")
@Table(name = "Person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    @JsonIgnore
    long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private String age;

    @Column(name = "favourite_colour")
    private String favouriteColour;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private List<Hobby>  hobbies = new ArrayList<>();

    public String [] gethobby() {
        String[] array = new String[hobbies.size()];
        int index = 0;
        for (Hobby value : hobbies) {
            array[index] = value.getHobbies();
            index++;
        }
        return array;

    }


}
