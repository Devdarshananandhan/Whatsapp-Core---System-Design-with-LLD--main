package com.chatapp;
public class User {
    String userid;
    String name;
    int password;
    int phoneno;
    Profile profile;
    String about;
    int Statusvisibity;
    User(){
        this.about = "";
        this.Statusvisibity = 1;
    }
    User(String userid, String name, int password, int phoneno){
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.phoneno = phoneno;
        this.about = "";
        this.Statusvisibity = 1;
    }
    void setProfile(Profile profile){
        this.profile = profile;
    }

    Profile getProfile(){
        return this.profile;
    }

    void setAbout(String about){
        this.about = about;
    }

    String getAbout(){
        return this.about;
    }

    void setCrentials(String userid,String name,int password,int phoneno){
        this.name = name;
        this.password = password;
        this.phoneno = phoneno;
        this.userid = this.name + "_" + this.phoneno;
    }

    public void showDetails(){
        System.out.println("User ID: " + this.userid);
        System.out.println("Name: " + this.name);
        System.out.println("Phone Number: " + this.phoneno);
        if(this.profile != null){
            System.out.println("Profile Name: " + this.profile.name);
            System.out.println("Profile Image: " + this.profile.image);
        } else {
            System.out.println("No profile information available.");
        }
        System.out.println("About: " + this.about);
        System.out.println("Status Visibility: " + (this.Statusvisibity == 1 ? "Public" : "Private"));
    }

}