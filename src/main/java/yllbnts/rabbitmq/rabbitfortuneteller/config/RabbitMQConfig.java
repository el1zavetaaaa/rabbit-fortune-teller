package yllbnts.rabbitmq.rabbitfortuneteller.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yelyzavetalubenets
 **/
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.binding.key}")
    private String bindingKey;

    @Bean
    public Queue queue(){
        return new Queue(queueName, true);
    }

    @Bean
    public DirectExchange exchange() {
        return ExchangeBuilder.directExchange(exchangeName).build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with(bindingKey);
    }
}
