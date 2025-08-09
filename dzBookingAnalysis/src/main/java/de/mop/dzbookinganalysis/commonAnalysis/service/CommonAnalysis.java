package de.mop.dzbookinganalysis.commonAnalysis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.mop.dzbookinganalysis.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class CommonAnalysis {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public CommonAnalysis(KafkaProducer kafkaProducer) { this.kafkaProducer = kafkaProducer;}

    public void processMessage(String jsonMessage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> map = objectMapper.readValue(jsonMessage, Map.class);

            // check if the message contains specific problem described in dev task
            if (map.get("problems").contains("Instrument nicht vorhanden")) {
                kafkaProducer.sendMessage("report", jsonMessage);
            } else {
                log.info("Message processed without specific problems: {}", map);
            }
        } catch (Exception e) {
            log.error("Error processing message", e);
        }
    }
}