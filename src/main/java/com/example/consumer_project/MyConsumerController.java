package com.example.consumer_project;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MyConsumerController {

    private final MyConsumerService myConsumerService;

    @GetMapping("/show")
    public ResponseEntity<?> getAllMessages(){
        var myMessages = myConsumerService.getMyMessages();
        return ResponseEntity.ok(Map.of("messages", myMessages));
    }
}
