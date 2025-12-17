package com.chatapp;
public class Message {
    public String messageId;
    public String senderUserId;
    public String receiverUserId;
    public String content;
    public long timestamp;
    public Message(String messageId, String senderUserId, String receiverUserId, String content, long timestamp) {
        this.messageId = messageId;
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.content = content;
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "[" + timestamp + "] " + senderUserId + " -> " + receiverUserId + ": " + content + " {" + messageId + "}";
    }
}
