package src.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class ConsumerDebezium {
    private static Logger loggerConsumer = LoggerFactory.getLogger(ConsumerDebezium.class);
    @KafkaListener(topics = {
            "dbserver1.source1.craft_market_wide",
            "dbserver1.source2.craft_market_masters_products",
            "dbserver1.source2.craft_market_orders_customers",
            "dbserver1.source3.craft_market_craftsmans",
            "dbserver1.source3.craft_market_customers",
            "dbserver1.source3.craft_market_orders"
    }, groupId = "${spring.kafka.consumer.consumer2.group-id}")
    public void readDibeziumListener(String msg){
        loggerConsumer.info("Consumer успешно вычитал сообщение, переданное debezium!");
        loggerConsumer.info(msg);
    }
}
