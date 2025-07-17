package yllbnts.rabbitmq.rabbitfortuneteller.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yelyzavetalubenets
 **/
@Component
@RequiredArgsConstructor
public class FortuneReciever {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void handleMessage(String message){
        System.out.println(">>> Question: " + message);
        // TODO: add spring ai to send questions to chat gpt and get answers from there
        final String mockAnswer = Math.random() < 0.5 ? "Yes" : "No";
        System.out.println(">> Answer: " + mockAnswer);
    }
}
