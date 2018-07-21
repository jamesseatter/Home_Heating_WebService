package eu.seatter.ppecdb.Repository;

import eu.seatter.ppecdb.Model.VAPITemperatureLast365Days;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface VAPITemperatureLast365DaysRepository extends CrudRepository<VAPITemperatureLast365Days,Long> {
    List<VAPITemperatureLast365Days> findByDateGreaterThanEqual(Date date);
    // TODO Analysis showed the below is better, does it work correctly ?
    //List<VAPITemperatureLast365Days> findByDateGreaterThanEqual(Timestamp date);
}
