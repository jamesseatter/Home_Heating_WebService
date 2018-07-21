package eu.seatter.ppecdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// The below is the spring boot 1.4 version, the above is the 2.0 version.
//import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
// WAR class definition
//public class Application extends SpringBootServletInitializer {
public class Application {
    final static Logger logger = LoggerFactory.getLogger(Application.class);

    //WAR Config
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }

    public static void main( String[] args ) {
        // logger.info("Application Starting");
        SpringApplication.run(Application.class,args);
        // logger.info("Application Exiting");
    }

}
