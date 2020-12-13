package vn.vnpay.oracle.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vnpay.oracle.dto.MessageDTO;
import vn.vnpay.oracle.util.GsonUtil;

@RestController
@RequestMapping("/messages")
public class RabbitMQController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public void sendMessage(@RequestBody MessageDTO messageDto) {
        rabbitTemplate.convertAndSend("exchange-one", "route-one", GsonUtil.toJson(messageDto));
    }

}
