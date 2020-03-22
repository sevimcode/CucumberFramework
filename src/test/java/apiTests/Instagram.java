package apiTests;

import utilities.Config;

import java.util.ArrayList;
import java.util.List;
//       - addUser
//        - addPost
//        - removeUser
//        - removePost
//        - updateUserInfo
//        - updatePostInfo
//
public class Instagram{
// API perpective the Instagram class is a API backend applications have multiple API

    List<InstagramUser> users;

    public Instagram() {

        users = new ArrayList<> ();

    }


    public void addUser( InstagramUser user ) {
        boolean found = false;
        for (InstagramUser u : users) {
            if (u.username.equalsIgnoreCase (user.username)) {
                System.out.println ("Username is already exist");
                found = true;
                break;
            }

        }
        if (!found) {
            System.out.println ("User added to the system");
            users.add (user); // adds user
        }

    }

    public void addPost( String username , Post instaPost ) {

        for (InstagramUser u : users) {
            if (u.username.equalsIgnoreCase (username)) {
                u.posts.add (instaPost);
                return;
            }

            System.out.println ("username not found");

        }
    }

    public void removeUser( String username ) {
        for (InstagramUser u : users) {
            if (u.username.equalsIgnoreCase (username)) {
                users.remove (username);
                System.out.println ("username" + username + "is removed");
                return;
            }
        }

        System.out.println ("username" + username + "not found");
    }

    public void updateUser( String username , String newName , int newAge ) {
        for (InstagramUser u : users) {
            if (u.username.equalsIgnoreCase (username)) {
                u.name = newName;
                u.age = newAge;
                System.out.println ("username" + username + "is updated");
                return;
            }
        }

        System.out.println ("username" + username + "not found");
    }


    public void seeAllUsers(String secretKey) {

        if (Config.getProperty ("apiKey").equals (secretKey)) {


            int count = 1;
            for (InstagramUser u : users) {
                System.out.println ();
                System.out.println ("User " + count);
                System.out.println ("Name :" + u.name);
                System.out.println ("Username :" + u.username);
                System.out.println ("Age :" + u.age);
                count++;

            }
        } else {
            System.out.println ("invalid API key. try again");


        }

    }

}