package eu.seatter.ppecdb.Repository;

import eu.seatter.ppecdb.Model.UTemperature;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by james on 26/06/2018.
 */
@Repository
public interface UTemperatureRepository  extends CrudRepository<UTemperature, Long> {
//    // Explicitly mapped to named stored procedure {@code User.plus1} in the {@link EntityManager}.
//    // By default, we would've try to find a procedure declaration named User.plus1BackedByOtherNamedStoredProcedure
    @Procedure(name = "insert.Temperature")
    String insertTemperatureNamedStoredProcedure(@Param("tempC") Float tempC);

//    // Directly map the method to the stored procedure in the database (to avoid the annotation madness on your domain classes).
//    @Procedure(name="alertstatus")
//    String insert_temperature(Float tempC);

}
