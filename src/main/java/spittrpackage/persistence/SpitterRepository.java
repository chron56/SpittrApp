package spittrpackage.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spittrpackage.domain.Spitter;

@Repository
public interface SpitterRepository  extends JpaRepository<Spitter, Integer> {

    Spitter getByUsername(String username);

}