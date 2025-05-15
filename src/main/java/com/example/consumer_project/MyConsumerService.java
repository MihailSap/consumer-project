package com.example.consumer_project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@Service
@RequiredArgsConstructor
public class MyConsumerService {

    private final List<MyMessage> myMessages = new ArrayList<>();

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${topic.name}")
    public void saveMessage(String message) throws JsonProcessingException {
        var myMessage = objectMapper.readValue(message, MyMessage.class);
        myMessages.add(myMessage);
        log.info("Сообщение получено и сохранено: {}", myMessage);
    }
}
