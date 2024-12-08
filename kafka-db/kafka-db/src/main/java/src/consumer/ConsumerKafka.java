package src.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import src.models.SourcesTable;
import src.services.SourcesTableServiceImpl;

@EnableKafka
@Component
public class ConsumerKafka {

    @Autowired
    SourcesTableServiceImpl sourcesTableServiceImpl;

    private static Logger loggerConsumer = LoggerFactory.getLogger(ConsumerKafka.class);
    @KafkaListener(topics="sendToPostgres", groupId = "${spring.kafka.consumer.consumer1.group-id}")
    public void sendToPostgresListener(String msg){
        loggerConsumer.info("Consumer успешно вычитал сообщение из Kafka!");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SourcesTable sourcesTable = objectMapper.readValue(msg, SourcesTable.class);
            loggerConsumer.info("Сообщение успешно распарсено: " + sourcesTable.toString());

            sourcesTableServiceImpl.create(sourcesTable);

            loggerConsumer.info("Сообщение отправлено в БД");
        } catch (JsonMappingException e) {
            loggerConsumer.error("Ошибка сопоставления данных");
        } catch (JsonProcessingException e) {
            loggerConsumer.error("Ошибка json обработки");
        }
    }
}
