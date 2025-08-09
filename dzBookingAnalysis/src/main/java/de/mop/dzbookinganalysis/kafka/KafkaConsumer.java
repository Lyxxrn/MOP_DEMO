package de.mop.dzbookinganalysis.kafka;

import de.mop.dzbookinganalysis.commonAnalysis.service.CommonAnalysis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    private final CommonAnalysis commonAnalysis;

    public KafkaConsumer(CommonAnalysis commonAnalysis) {
        this.commonAnalysis = commonAnalysis;
    }

    @KafkaListener(topics = "messages", groupId = "analysis")
    public void listen(String message) {
        log.info("Received message: {}", message);
        commonAnalysis.processMessage(message);
    }
}