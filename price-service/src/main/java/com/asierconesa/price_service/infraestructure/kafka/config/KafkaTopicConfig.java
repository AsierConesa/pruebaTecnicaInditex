package com.asierconesa.price_service.infraestructure.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Configuración de los topics de Kafka para la aplicación.
 * Esta clase no está pensada para ser extendida.
 */
@Configuration
public class KafkaTopicConfig {

    /**
     * Define el topic de Kafka para eventos de creación de precios.
     * @return un bean de tipo NewTopic configurado
     */
    @Bean
    public NewTopic priceCreatedTopic() {
        return TopicBuilder.name("price-created-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
