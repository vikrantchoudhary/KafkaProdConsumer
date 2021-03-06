package com.vikrant.kafkademo.KafkaProdConsumer.controller;

import com.google.gson.JsonObject;
import com.vikrant.kafkademo.KafkaProdConsumer.model.SampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaPubConController {
    private KafkaTemplate<String, SampleModel> kafkaTemplate;

    @Autowired
    public KafkaPubConController (KafkaTemplate<String,SampleModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @PostMapping("/api/kafka/sample")
    public void producer(@RequestBody SampleModel sampleModel) {
        kafkaTemplate.send("mytopic", sampleModel);
    }


    @GetMapping("/api/test")
    public ResponseEntity<String> test () {
        return ResponseEntity.ok().body("testing");
    }

    @KafkaListener(topics = "mytopic")
    @GetMapping("/api/kafka/consumer")
    public ResponseEntity<String> consumer(SampleModel sampleModel) {
        System.out.println(sampleModel.toString());
        return ResponseEntity.ok().body(sampleModel.toString());
    }
}
