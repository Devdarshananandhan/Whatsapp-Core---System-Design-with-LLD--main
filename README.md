# Simple CLI Chat Application

A lightweight, command-line based chat system written in Java. This project focuses on demonstrating clean architecture, service–repository separation, and pluggable persistence while keeping the feature set intentionally minimal.

---

## ✨ Overview

This application provides a **basic one-to-one chat experience** through a CLI interface. Users can create accounts, log in, send messages, and view past conversations. The system is designed to be easy to extend and suitable for learning backend design concepts.

---

## 🎯 Objectives

* Create and authenticate users via CLI
* Send direct (1:1) messages between users
* Retrieve and display conversation history
* Support multiple storage options (cloud DB or in-memory)
* Handle database failures gracefully without crashing

---

## 🧩 Architecture (High-Level)

**Core Flow:**

```
CLI Input → Authentication → Chat Service → Repository → Database → CLI Output
```

**Main Components:**

* CLI-based user interface
* Authentication module (login / create user)
* Chat service layer (business logic)
* Repository abstraction (persistence layer)
* Database adapter (MongoDB Atlas or in-memory)

Configuration values such as database URI and database name are read from environment variables. If not provided, the app falls back to a local or in-memory setup.

---

## 🛠 Low-Level Design

### Data Models

**User**

* `userId : String`
* `name : String`
* `password : int`

**Message**

* `messageId : String`
* `senderId : String`
* `receiverId : String`
* `content : String`
* `timestamp : long`

### Service Layer

The service layer exposes simple APIs:

* `sendMessage(Message message)`
* `getConversation(String userA, String userB)`

This layer handles validation, error management, and delegates persistence work to the repository.

### Repository Layer

Repository acts as a contract for storage:

* `saveMessage(Message message)`
* `getConversation(String userA, String userB)`

Implementations:

* MongoDB Atlas adapter (production-ready)
* In-memory adapter (development/testing)

---

## ✅ Typical Usage Flow

1. Start the application
2. Create a new user or log in
3. View available users
4. Select a recipient
5. Send messages
6. Log in as the recipient
7. View the conversation history

---

## ⚠ Error Handling

* All database and network exceptions are caught at the service boundary
* Errors are shown as user-friendly CLI messages
* Application continues running without unexpected termination

---

## 🔧 Configuration

Environment variables:

* `DB_URI` – Database connection string
* `DB_NAME` – Database name

If not set, the application defaults to a local or in-memory configuration.

---

## 💻 Requirements

* Java 8 or higher
* Command-line environment
* Optional: MongoDB Atlas account

---

## 🚀 Future Enhancements (Optional)

* Password hashing
* Group chats
* Message status (sent/read)
* Pagination for large conversations
* Migration to GUI or REST API

---

## 📄 License

This project is intended for educational and learning purposes. You are free to modify and extend it as needed.

---

*Designed to be simple, extensible, and easy to understand for backend and Java learners.*
