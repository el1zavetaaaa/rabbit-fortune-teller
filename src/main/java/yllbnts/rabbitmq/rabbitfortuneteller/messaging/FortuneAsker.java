package yllbnts.rabbitmq.rabbitfortuneteller.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yelyzavetalubenets
 **/
@Component
@RequiredArgsConstructor
public class FortuneAsker {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.binding.key}")
    private String bindingKey;

    public void askAQuestion(final String question){
        rabbitTemplate.convertAndSend(exchangeName, bindingKey, question);
    }
}
