package eu.seatter.ppecdb.Repository;


import eu.seatter.ppecdb.Model.VAPIAlertLast7Days;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VAPIAlertLast7DaysRepository extends CrudRepository<VAPIAlertLast7Days, Long> {
}
