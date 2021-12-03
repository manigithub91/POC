package com.perf.springbootkafkaapp.service;


import com.perf.springbootkafkaapp.common.AppConstants;
import com.perf.springbootkafkaapp.model.Item;
import com.perf.springbootkafkaapp.model.Student;
import com.perf.springbootkafkaapp.repo.ItemRepo;
import com.perf.springbootkafkaapp.repo.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
 
@Service
public class KafKaConsumerService 
{
    private final Logger logger = 
            LoggerFactory.getLogger(KafKaConsumerService.class);
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ItemRepo itemRepo;
 
    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID,containerFactory = "kafkaListener")
    public void consume(Item item)
    {

        logger.info(String.format("Message recieved -> %s", item));
        System.out.println(item);

        itemRepo.save(item);

    }

//    public void consume(String message)
//    {
//
//        logger.info(String.format("Message recieved -> %s", message));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Student student = null;
//
//        // Deserialization into the `Employee` class
//        try{
//             student = objectMapper.readValue(message, Student.class);
//        }catch (JsonProcessingException e){
//            logger.error(e.getMessage());
//        }
//
//        studentRepo.save(student);
//
//
//// Print information
//        //System.out.println(student);
//
//    }
}