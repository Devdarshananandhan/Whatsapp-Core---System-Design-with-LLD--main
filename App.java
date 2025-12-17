package com.chatapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
        public static void main(String[] args) {
                CreateAccount ca = new CreateAccount("alice_123321", "Alice", 1234, 987654321);
                ca.createUser();

                CreateAccount cb = new CreateAccount("bob_456654", "Bob", 4321, 123456789);
                cb.createUser();
                List<CreateAccount> accounts = new ArrayList<CreateAccount>();
                accounts.add(ca);
                accounts.add(cb);
                String uri = System.getenv("MONGODB_URI");
                String dbName = System.getenv("MONGODB_DB");
                if (uri == null) {
                        System.out.println("Warning: MONGODB_URI not set — AtlasChatRepository will try default local connection.");
                }
                AtlasChatRepository repo = new AtlasChatRepository(uri, dbName);
                ChatService chatService = new ChatService(repo);
                Scanner in = new Scanner(System.in);
                System.out.print("Login Name: ");
                String loginName = in.nextLine().trim();
                System.out.print("Password: ");
                int loginPass = 0;
                try { loginPass = Integer.parseInt(in.nextLine().trim()); } catch (Exception e) { }
                CreateAccount logged = null;
                for (CreateAccount ac : accounts) {
                        if (ac.user != null && ac.user.name.equals(loginName) && ac.user.password == loginPass) { logged = ac; break; }
                }
                if (logged == null) {
                        CreateAccount nc = new CreateAccount(loginName.toLowerCase() + "_001", loginName, loginPass, 0);
                        nc.createUser();
                        accounts.add(nc);
                        logged = nc;
                        System.out.println("Created and logged in: " + loginName);
                }
                System.out.println("Logged in as: " + logged.user.name);
                System.out.println("Persons present:");
                for (CreateAccount ac : accounts) {
                System.out.println("- " + ac.user.name);
                }
                System.out.print("Send message to (name): ");
                String toName = in.nextLine().trim();
                CreateAccount toAcc = null;
                for (CreateAccount ac : accounts) if (ac.user != null && ac.user.name.equals(toName)) { toAcc = ac; break; }
                if (toAcc == null) {
                        System.out.println("Recipient not found.");
                        in.close();
                        repo.close();
                        return;
                }
                System.out.print("Enter message: ");
                String content = in.nextLine();
                String mid = "m" + System.currentTimeMillis();
                long ts = System.currentTimeMillis();
                Message m = new Message(mid, logged.user.userid, toAcc.user.userid, content, ts);
                try {
                        chatService.sendMessage(m);
                        System.out.println("Message sent to " + toAcc.user.name + ".");
                } catch (Exception ex) {
                        System.out.println("Failed to send message to Atlas: " + ex.getMessage());
                System.out.println("(Message not persisted)");
                }
                System.out.println("\nNow login as recipient to read messages.");
                System.out.print("Login Name: ");
                String rName = in.nextLine().trim();
                System.out.print("Password: ");
                int rPass = 0;
                try { rPass = Integer.parseInt(in.nextLine().trim()); } catch (Exception e) { }
                CreateAccount rLogged = null;
                for (CreateAccount ac : accounts) {
                        if (ac.user != null && ac.user.name.equals(rName) && ac.user.password == rPass) { rLogged = ac; break; }
                }
                if (rLogged == null) {
                        System.out.println("Recipient login failed.");
                        in.close();
                        repo.close();
                        return;
                }
                System.out.println("Logged in as: " + rLogged.user.name);
                try {
                        List<Message> convo = chatService.getConversation(logged.user.userid, rLogged.user.userid);
                        System.out.println("Conversation between " + logged.user.name + " and " + rLogged.user.name + ":");
                        for (Message msg : convo) System.out.println(msg);
                } catch (Exception ex) {
                        System.out.println("Failed to read conversation from Atlas: " + ex.getMessage());
                }
                in.close();
                repo.close();
        }
}
