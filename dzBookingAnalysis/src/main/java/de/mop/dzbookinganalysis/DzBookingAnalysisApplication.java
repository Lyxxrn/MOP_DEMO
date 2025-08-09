package de.mop.dzbookinganalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import de.mop.dzbookinganalysis.kafka.KafkaProducer;
import de.mop.dzbookinganalysis.commonValidation.service.ValidateDgbWpKassa;

@SpringBootApplication
public class DzBookingAnalysisApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DzBookingAnalysisApplication.class, args);

        KafkaProducer kafkaProducer = context.getBean(KafkaProducer.class);
        ValidateDgbWpKassa validateService = new ValidateDgbWpKassa(kafkaProducer);
        validateService.validateExampleMessage();
    }
}