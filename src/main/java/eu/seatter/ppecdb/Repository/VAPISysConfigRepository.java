package eu.seatter.ppecdb.Repository;

import eu.seatter.ppecdb.Model.VAPISysConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VAPISysConfigRepository extends CrudRepository<VAPISysConfig, Long> {

}
