//package src.configuration;
//
//import com.sun.jdi.event.Event;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class KafkaConfig {
//
//    @Bean
//    public ConsumerFactory<String, Event> consumerFactoryEventDeb() {
//
//        JsonDeserializer<Event> deserializer = new JsonDeserializer<>(Event.class);
//        deserializer.addTrustedPackages("com.example.event");
//        deserializer.setRemoveTypeHeaders(false);
//
//        Map<String, Object> consumerProps = new HashMap<>();
//        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
//        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "group2");
//        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
//
//        return new DefaultKafkaConsumerFactory<>(consumerProps);
//    }
//
//    @Bean
//    public ConsumerFactory<String, Event> consumerFactoryEvent() {
//
//        JsonDeserializer<Event> deserializer = new JsonDeserializer<>(Event.class);
//        deserializer.addTrustedPackages("com.example.event");
//        deserializer.setRemoveTypeHeaders(false);
//
//        Map<String, Object> consumerProps = new HashMap<>();
//        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
//        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
//
//        return new DefaultKafkaConsumerFactory<>(consumerProps);
//    }
//
//    @Bean(name="kafkaListenerContainerFactoryEventDeb")
//    public ConcurrentKafkaListenerContainerFactory<String, Event> kafkaListenerContainerFactoryEventDeb() {
//        ConcurrentKafkaListenerContainerFactory<String, Event> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactoryEventDeb());
//        return factory;
//    }
//
//    @Bean(name="kafkaListenerContainerFactoryEvent")
//    public ConcurrentKafkaListenerContainerFactory<String, Event> kafkaListenerContainerFactoryEvent() {
//        ConcurrentKafkaListenerContainerFactory<String, Event> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactoryEvent());
//        return factory;
//    }
//}
