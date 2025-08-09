package de.mop.dzgateoutreport.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.mop.dzgateoutreport.service.sendWmRequestMissingIsin.SendRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    private final SendRequest sendRequest;

    public KafkaConsumer(SendRequest sendRequest) {
        this.sendRequest = sendRequest;
    }

    @KafkaListener(topics = "report", groupId = "analysis")
    public void listen(String message) throws JsonProcessingException {
        sendRequest.sendRequest(message);
    }
}