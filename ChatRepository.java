package com.chatapp;
import java.util.List;
public interface ChatRepository {
    void saveMessage(Message message);
    List<Message> getConversation(String userA, String userB);
}
