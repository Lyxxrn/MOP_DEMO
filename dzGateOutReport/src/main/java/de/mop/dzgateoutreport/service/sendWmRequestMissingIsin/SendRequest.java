package de.mop.dzgateoutreport.service.sendWmRequestMissingIsin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class SendRequest {

    public void sendMail(String recipient, String subject, String body) {
        // Placeholder for email sending logic
        log.info("Sending email to: {}, Subject: {}, Body: {}", recipient, subject, body);
    }

    public void sendRequest(String jsonMessage) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(jsonMessage, Map.class);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String date = dateFormat.format(new Date());
        String subject = map.get("isin") + " VD " + date;

        sendMail("test@example.com", subject, "");

    }
}
