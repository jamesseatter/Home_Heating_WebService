package eu.seatter.ppecdb.Controller;

import eu.seatter.ppecdb.JPAUtility;
import eu.seatter.ppecdb.Repository.UTemperatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Collections;
import java.util.Map;


/**
 * Created by james on 26/06/2018.
 */

@Controller
@RequestMapping(path="/secure/api")
public class SecureController {

    private final static Logger logger = LoggerFactory.getLogger(SecureController.class);

    @Autowired
    private UTemperatureRepository UTemperatureRepository;

    @PostMapping(path="/insertTemperature/{temperature}", produces = "application/json")
    @ResponseBody
    public Map insertNewRecord(@PathVariable Float temperature) {
        logger.info(" Post/insertTemperature/" + temperature);
        String alertStatus="Error";
        EntityManager em = JPAUtility.getEntityManager();

        try {
            em.getTransaction().begin();

            StoredProcedureQuery query = em.createNamedStoredProcedureQuery("insert.Temperature");
            query.setParameter("tempC", 99.99f);
            query.execute();
            alertStatus = (String) query.getOutputParameterValue("alertstatus");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        finally {
            em.close();
            JPAUtility.close();
        }

        return Collections.singletonMap("alertstatus", alertStatus);
    }

}
