package com.chatapp;

public class Login {
        String name;
        int password;
        User user;
        Login(User user){
                this.user = user;
        }

        Login(CreateAccount ca){
                this.user = ca.user;
        }

        boolean authenticate(String userid, int password){
                if(this.user == null) return false;
                if(this.user.userid == null) return false;
                return this.user.userid.equals(userid) && this.user.password == password;
        }
        boolean authenticateByName(String name, int password){
                if(this.user == null) return false;
                if(this.user.name == null) return false;
                return this.user.name.equals(name) && this.user.password == password;
        }
}
