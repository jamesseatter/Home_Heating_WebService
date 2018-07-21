package eu.seatter.ppecdb.Repository;

import eu.seatter.ppecdb.Model.VAPILastTemp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VAPILastTempRepository extends CrudRepository<VAPILastTemp,Long> {

}
