package com.chatroom.chatroom.controllers;

import com.chatroom.chatroom.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message getContent(@RequestBody Message message) {

        try {
            Thread.sleep(1000);   /// 2 sec wait before sending message
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return message;
    }
}
