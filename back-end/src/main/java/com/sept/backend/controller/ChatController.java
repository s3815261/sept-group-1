package com.sept.backend.controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatController {
    @OnMessage
    public String onMessage(Session session, String message) {
        System.out.println(message);
        return message;
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Opened: " + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Closed: " + session.getId());
    }
}
