package embl.person.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Hobby Entity, represents  Hobbies of a Person.
 *
 * @author Manuel Bouzas
 */
@Entity
@Table(name = "Hobby")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hobby {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_hobby")
    @JsonIgnore
    long idHobby;

    @JsonIgnore
    @Column(name = "person_id")
    private String personId;

    @Column(name = "hobbies")
    private String hobbies;

}
