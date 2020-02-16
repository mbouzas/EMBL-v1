package embl.person.person.body;

import lombok.Data;

import javax.persistence.Column;

/**
 *
 * DTO expected as body on POST,PUT requests.
 *
 * @author Manuel Bouzas
 */
@Data
public class PersonRequest {

    String first_name;

    String last_name;

    String age;

    String favourite_colour;

    String[] hobby;
}
