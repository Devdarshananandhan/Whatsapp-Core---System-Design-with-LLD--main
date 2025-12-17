package com.chatapp;
public class ReceiveMsg {
    public enum MessageType { TEXT, IMAGE, VIDEO, AUDIO, LOCATION, CONTACT }
    String messageId;       
    String senderUserId;    
    String receiverUserId;  
    MessageType type;       
    long timestamp;         
    public ReceiveMsg(String messageId, String senderUserId, String receiverUserId, MessageType type, long timestamp) {
        if (messageId == null || senderUserId == null || receiverUserId == null || type == null) {
            System.out.println("messageId, senderUserId, receiverUserId and type must be non-null");
            return;
        }
        this.messageId = messageId;
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.type = type;
        this.timestamp = timestamp;
    }
    public String getMessageId() { return messageId; }
    public String getSenderUserId() { return senderUserId; }
    public String getReceiverUserId() { return receiverUserId; }
    public MessageType getType() { return type; }
    public long getTimestamp() { return timestamp; }
    @Override
    public String toString() {
        return "[" + timestamp + "] " + senderUserId + " -> " + receiverUserId + " (" + type + "): " + messageId;
    }
}
