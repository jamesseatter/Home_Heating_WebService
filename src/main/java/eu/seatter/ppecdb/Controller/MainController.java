package eu.seatter.ppecdb.Controller;

import eu.seatter.ppecdb.Model.VAPIAlertLast7Days;
import eu.seatter.ppecdb.Model.VAPILastTemp;
import eu.seatter.ppecdb.Model.VAPISysConfig;
import eu.seatter.ppecdb.Model.VAPITemperatureLast365Days;
import eu.seatter.ppecdb.Repository.VAPIAlertLast7DaysRepository;
import eu.seatter.ppecdb.Repository.VAPILastTempRepository;
import eu.seatter.ppecdb.Repository.VAPISysConfigRepository;
import eu.seatter.ppecdb.Repository.VAPITemperatureLast365DaysRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/api")
public class MainController {

    private final static Logger logger = LoggerFactory.getLogger(MainController.class);


    @Autowired
    private VAPITemperatureLast365DaysRepository VAPITemperatureLast365DaysRepository;

    @Autowired
    private VAPILastTempRepository VAPILastTempRepository;

    @Autowired
    private VAPISysConfigRepository VAPISysConfigRepository;

    @Autowired
    private VAPIAlertLast7DaysRepository VAPIAlertLast7DaysRepository;

    @Autowired
    private DataSource dataSource;


    @CrossOrigin
    @GetMapping(path="/all")
    public @ResponseBody
    Iterable getAllTemperatures() {
        int size;
        logger.info(" GET/all");
        Iterable data = VAPITemperatureLast365DaysRepository.findAll();
        size = getSize(data);
        logger.info(" GET/all: returned : {} rows", size);
        return data;
    }

    @CrossOrigin
    @GetMapping(path="/last")
    public @ResponseBody Iterable<VAPILastTemp> getLastTemperature() {
        logger.info(" GET/last");
        return VAPILastTempRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path = {"/lastdays/{lastDays}", "/lastdays"})
    public @ResponseBody Iterable<VAPITemperatureLast365Days> getTemperatureByAgeDays(@PathVariable Optional<Integer> lastDays) {

        int days = 1;
        if(lastDays.isPresent()) {
            days = lastDays.get();
        }
        logger.info(" GET/lastdays: {}",(lastDays.isPresent()?lastDays.get():""));

        LocalDate lDate = LocalDate.now().plusDays(-days);
        java.sql.Date sqlDateVal = java.sql.Date.valueOf(lDate);
        logger.info(" GET/lastdays: date : {} ",sqlDateVal.toString());
        List<VAPITemperatureLast365Days> data = VAPITemperatureLast365DaysRepository.findByDateGreaterThanEqual(sqlDateVal);
        logger.info(" GET/lastdays: returned : {} rows", data.size());
        return data;
    }

    @CrossOrigin
    @GetMapping(path="/sysconfig")
    public @ResponseBody Iterable<VAPISysConfig> getSysConfig() {
        logger.info(" GET/sysconfig");

        return VAPISysConfigRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(path="/alerts")
    public @ResponseBody Iterable<VAPIAlertLast7Days> getAllAlerts() {
        logger.info(" GET/alerts");
        return VAPIAlertLast7DaysRepository.findAll();
    }

    private int getSize(Iterable data) {
        if (data instanceof List<?>) {
            return ((List<?>) data).size();
        }
        return 0;
    }



}
