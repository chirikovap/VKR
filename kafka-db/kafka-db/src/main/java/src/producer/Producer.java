package src.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sendToPostgres")
public class Producer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    private static Logger loggerProducer = LoggerFactory.getLogger(Producer.class);

    @PostMapping
    public void sendToPostgres(@RequestBody Object msg){
        kafkaTemplate.send("sendToPostgres", msg);
        loggerProducer.info("Сообщение успешно отправлено в Kafka! Тело сообщения: " + msg);
    }
}
