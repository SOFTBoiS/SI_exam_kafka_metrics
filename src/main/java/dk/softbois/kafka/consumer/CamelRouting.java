package dk.softbois.kafka.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
class CamelSimple extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:SI_exam.searchHistory?brokers=localhost:9092")
                .log("Message received from Kafka : ${body}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}")
                .to("file:src/main/resources/orders");
    }
}