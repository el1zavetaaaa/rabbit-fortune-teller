package yllbnts.rabbitmq.rabbitfortuneteller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yllbnts.rabbitmq.rabbitfortuneteller.messaging.FortuneAsker;

/**
 * @author yelyzavetalubenets
 **/
@RestController
@RequestMapping("/fortune-asker")
public class FortuneAskerController {

    @Autowired
    private FortuneAsker fortuneAsker;

    @PostMapping("/ask")
    public String askAQuestion(@RequestBody String question){
        fortuneAsker.askAQuestion(question);
        return "Question was send to Fortune Teller: " + question;
    }


}
