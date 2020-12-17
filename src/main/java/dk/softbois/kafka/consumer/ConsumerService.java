package dk.softbois.kafka.consumer;

import dk.softbois.kafka.metrics.SearchMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLOutput;

@Service
public class ConsumerService
{
      // get logger for my class
      private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
      
      @KafkaListener(topics = "SI_exam.searchHistory", groupId = "my-group")
      public void consume(@Payload String message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) throws IOException
      {
            System.out.println("Message consumed: " + message);
            System.out.println("Has key: " + key);

            SearchMetrics.AnalyzeData(key, message);


      }




}
      
