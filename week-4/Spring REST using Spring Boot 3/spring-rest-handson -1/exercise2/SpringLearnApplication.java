//Kavya Narmeta, Superset ID: 6397911
package com.cognizant.springlearn;
//Kavya Narmeta, Superset ID: 6397911
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Kavya Narmeta, Superset ID: 6397911
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	//Kavya Narmeta, Superset ID: 6397911
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
  //Kavya Narmeta, Superset ID: 6397911
    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        displayDate();
        LOGGER.info("END");
    }
  //Kavya Narmeta, Superset ID: 6397911
    public static void displayDate() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Date: {}", date);
        } catch (ParseException e) {
            LOGGER.error("Parse error", e);
        }

        LOGGER.info("END");
    }
}
