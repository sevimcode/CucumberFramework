package apiTests;

public class InstagramTesting{


    public static void main( String[] args ) {

// API perceptive the instagram testing class is a client( ui ) that request to add user
        Instagram instagram = new Instagram ();

        //sign up page
        //users must provide name, username, age etc.
        InstagramUser user1 = new InstagramUser ("sevim" , 30 , "sevim.surucu");

        // we added new user
        instagram.addUser (user1); // user1 is our REQUEST DATA CLIENT WANTS THIS USER1 TO BE ADDED TO THE SYSTEM

        instagram.seeAllUsers ("123"); // prints all users

        InstagramUser user2 = new InstagramUser ("james bond" , 30 , "bond777");

        instagram.addUser (user2);
        instagram.seeAllUsers ("123"); // we don't want everyone to see our users from api hit
        
        // that s why we added the secretkey
    }
}