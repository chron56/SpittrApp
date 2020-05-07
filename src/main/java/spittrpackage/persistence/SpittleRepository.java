package spittrpackage.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spittrpackage.domain.Spittle;
import java.util.List;

@Repository
public interface SpittleRepository  extends JpaRepository<Spittle, Integer> {

    @Query(nativeQuery = true, value = "select * from spittles where SpitterID = :id")
    List<Spittle> getSpittersSpittlesFromDB(@Param("id") int anId);

}