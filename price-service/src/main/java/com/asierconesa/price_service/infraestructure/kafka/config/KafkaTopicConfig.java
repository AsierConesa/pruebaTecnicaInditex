package com.asierconesa.price_service.infraestructure.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic priceCreatedTopic() {
        return TopicBuilder.name("price-created-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}