package de.mop.dzbookinganalysis.commonValidation.service;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import de.mop.dzbookinganalysis.kafka.KafkaProducer;
        import lombok.SneakyThrows;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.HashMap;
        import java.util.Map;

        /**
         * This logic was already provided before the dev task and is therefore only a placeholder and will not be evaluated in the quality analysis.
         */
        @Slf4j
        @Service
        public class ValidateDgbWpKassa {
            private final KafkaProducer kafkaProducer;

            @Autowired
            public ValidateDgbWpKassa(KafkaProducer kafkaProducer) {
                this.kafkaProducer = kafkaProducer;
            }


            @SneakyThrows
            public void validateExampleMessage() {

                log.info("Start validating trade.");
                Map<String, String> jsonMap = new HashMap<>();
                jsonMap.put("isin", "DE000A111ZF1");
                jsonMap.put("problems", "Instrument nicht vorhanden");

                ObjectMapper objectMapper = new ObjectMapper();
                String jsonMessage = objectMapper.writeValueAsString(jsonMap);

                kafkaProducer.sendMessage("messages", jsonMessage);
            }
        }