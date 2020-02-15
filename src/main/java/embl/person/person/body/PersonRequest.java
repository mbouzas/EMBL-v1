package embl.person.person.body;

import lombok.Data;

import javax.persistence.Column;

/**
 * DTO expected as body on POST requests.
 */
@Data
public class PersonRequest {

    String first_name;

    String last_name;

    String age;

    String favourite_colour;

    String[] hobby;
}
