package com.chatapp;
public class SendMsg {
    public enum MessageType { TEXT, IMAGE, VIDEO, AUDIO, LOCATION, CONTACT }
    private final String messageId;       
    private final String senderUserId;   
    private final String receiverUserId;  
    private final MessageType type;      
    private final long timestamp;         
    public SendMsg(String messageId, String senderUserId, String receiverUserId, MessageType type, long timestamp) {
        if (messageId == null || senderUserId == null || receiverUserId == null || type == null) {
            throw new IllegalArgumentException("messageId, senderUserId, receiverUserId and type must be non-null");
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