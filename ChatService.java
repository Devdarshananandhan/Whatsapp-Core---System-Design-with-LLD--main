package com.chatapp;

import java.util.List;


public class ChatService {
    private final ChatRepository repo;

    public ChatService(ChatRepository repo) {
        this.repo = repo;
    }

    
    public void sendMessage(Message message) {
        repo.saveMessage(message);
    }


    public List<Message> getConversation(String userA, String userB) {
        return repo.getConversation(userA, userB);
    }
}
