package de.mop.dzgateoutreport;

import de.mop.dzgateoutreport.kafka.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DzGateOutReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(DzGateOutReportApplication.class, args);

    }

}
