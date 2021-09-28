package com.rsi.kafka.consumer;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import com.rsi.kafka.dto.UserDto;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class ReceiverConfig {


	@Value("${spring.kafka.consumer.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	@Value("${spring.kafka.consumer.auto-offset-reset}")
	private String offsetId;
	
	@Bean
	public Map<String, Object> consumerConfigs() {
		
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,"4000");
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.rsi.kafka.dto");
		
		//props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
		//props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,"101");
		//props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetId);
		return props;
	}

    //@Bean
	public ConsumerFactory<String, UserDto> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
				new JsonDeserializer<>(UserDto.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UserDto> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, UserDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public Consumer receiver() {
		return new Consumer();
	}
}
