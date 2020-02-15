package embl.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {

 void deleteByPersonId(String personId);

}
