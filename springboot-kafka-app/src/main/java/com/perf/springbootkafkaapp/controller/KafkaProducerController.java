package com.perf.springbootkafkaapp.controller;

import com.perf.springbootkafkaapp.common.AppConstants;
import com.perf.springbootkafkaapp.model.Item;
import com.perf.springbootkafkaapp.repo.ItemRepo;
import com.perf.springbootkafkaapp.service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController 
{
    private final KafKaProducerService producerService;
 
    @Autowired
    public KafkaProducerController(KafKaProducerService producerService) 
    {
        this.producerService = producerService;
    }

    @Autowired
    ItemRepo itemRepo;

//    @PostMapping(value = "/publish")
//    public void sendMessageToKafkaTopic(@RequestParam("message") String message)
//    {
//        this.producerService.sendMessage(message);
//    }

    @Autowired
    KafkaTemplate<String, Item> KafkaJsontemplate;
    String TOPIC_NAME = "items-topic";

    @PostMapping(value = "/postItem",consumes = {"application/json"},produces = {"application/json"})
    public String postJsonMessage(@RequestBody Item item){
        itemRepo.save(item);
        KafkaJsontemplate.send(AppConstants.TOPIC_NAME,item);
        return "Message published successfully";
    }

    @PostMapping(value = "/postItemById",produces = {"application/json"})
    public String postJsonMessageBYId(@RequestParam long id){
        Item item = itemRepo.findById(id);
        KafkaJsontemplate.send(AppConstants.TOPIC_NAME,item);
        return "Message published successfully";
    }

}