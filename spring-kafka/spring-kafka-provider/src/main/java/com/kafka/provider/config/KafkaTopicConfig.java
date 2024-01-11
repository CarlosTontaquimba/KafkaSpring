package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic generateTopic(){

        Map<String, String> configurations = new HashMap<>();
        /**
         * EL delete elimina el mensaje después de un cierto tiempo
         * El compact mantiene el mensaje mas actual
         */
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        /**
        * Tiempo que se van a retener los mensajes dentro del topic y se especifica en milisegundos
        */
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //Es un día o si no por defecto viene -1 que no se borra nunca
        /**
         * Tamaño máximo que pueden tener los segmentos dentro del topic
         * Se debe poner en Bytes
         */
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");// Es un 1GB
        /**
         * Tamaño máximo que pueden el mensaje
         * Se debe poner en Bytes por defecto biene en 1MB
         */
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1024");

        return TopicBuilder.name("topicDesdeSpring")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
