package com.exe_river_sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

// ******************************************** START OF BUTTON VARIABLES ********************************************
    EditText username, email, password, repassword; // This is creating the variable 'Username' 'password' and 'repassword' (repassword means retype password).
    Button signup, signin;
    DBHelper DB;
// ******************************************** END OF BUTTON VARIABLES ********************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// ******************************************** R ID START ********************************************
        username = (EditText) findViewById(R.id.username);

        email = (EditText) findViewById(R.id.email);

        password = (EditText) findViewById(R.id.password);

        repassword = (EditText) findViewById(R.id.repassword);

        signup = (Button) findViewById(R.id.btnsignup);

        signin = (Button) findViewById(R.id.btnsignin);

        DB = new DBHelper(this);
// ******************************************** R ID END ********************************************


// ******************************************** LISTENERS START ********************************************
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText() .toString();
                String user_email = email.getText() .toString();
                String pass = password.getText() .toString();
                String repass = repassword.getText() .toString();


                if(user.equals("")||user_email.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this, "Please populate all fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, user_email, pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_SHORT) .show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(MainActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User account already exists! Please sign in.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Password incorrect, please check and try again!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
// ******************************************** LISTENERS END ********************************************

    }
}

// ********************************************************* COMMENTING THE CODE START *********************************************************
/*
    ***** I decided to put my large comments down here as I felt it made my coding look too cluttered. *****

Top of page above button variables:
                   - 'public class AccountActivity extends AppCompatActivity'
                      is doing exactly what it says, and is extending the AppCompatActivity. AppCompatActivity is the base class used to allow
                      newer features on older android devices. Essentially making it backward compatible.

Button Variables:  - These are just the variables created to link between elements on this page.


onCreate:          - Is a method, this is the same method used across every activity page and it stores data into a bundle

R ID:              - This is saying 'BtnHome' is equal to 'btnhome' and will link to the Xml version of this activity via that variable/ID using
                     the findViewByID method.

Listener:          - This is the listener and observes the button defined at the beginning of the line 'BtnHome' and waits to see if its state
                     changes, if the button is clicked for example then the state has changed and the following code will run. This listener for example
                     is going to navigate the user to a new page. The sentence 'Intent intent = new Intent(getApplicationContext(), HomeActivity.class);'
                     is saying that intent is changing from intent to new intent and getting the application context then starting activity and taking the
                     user to the next page, in this case HomeActivity page.

signup.setOnClickListener(new View.OnClickListener() :
                                                     - The first line is watching the button 'signup' for a state change. Once state changes the code runs.
                                                       String user = username.getText() .toString(); This line is saying the string user(defined above
                                                       as a variable) is equal to the username that comes from the text that has been input by user and converts it to a string
                                                       and this is done for the following 3 more lines.
                                                       if(user.equals("")||user_email.equals("")||pass.equals("")||repass.equals("")) this is an 'if' statement and this line is
                                                       saying that if the 'user', 'email', 'pass', and 'repass' variables are empty, then run the next piece of code which is a Toast method.
                                                       Toast.makeText(MainActivity.this, "Please populate all fields", Toast.LENGTH_SHORT).show(); which just creates a pop-up
                                                       to advise the user to populate all fields. Then comes the 'Else' statement and this is if the variable elements
                                                       aren't empty. The code then moves on to the next piece of code. I include another 'if' statement in the else statement.
                                                       if(pass.equals(repass)){ this line is saying if the 'pass' and 'repass' variables match then run the next piece of code,
                                                       otherwise run a 'Toast' statement which will create a pop-up advising the user that the username and password entered don't match.
                                                       Boolean checkuser = DB.checkusername(user); if(checkuser==false){ This is the code that is run if the 'if' statement parameters
                                                       above are met, Boolean is a yes or no method using true and false. This is saying that if the username provided by the user doesn't match
                                                       with a username on the DB(database) then run the next line of code, but has another 'else' statement which will have
                                                       another 'toast' statement giving the user a pop-up advising to check the username they have provided as there is an account already, perhaps
                                                       they want to sign in.
                                                       If return false then the next line of code will run which is the 'insertData' method. Boolean insert = DB.insertData(user, user_email, pass);
                                                       if(insert==true){ this is saying to insert the user name, email and password into the database and then if that has been successful return
                                                       true, if true then run a 'toast' statement to give user a registration success pop-up and then run and intent which will navigate the user
                                                       away from the current page, logging them in and putting them on the landing/home page.
                                                       Otherwise run the 'else' method and run 'toast' statement to pop-up registration failed message to the user and then lets the user attempt it again.
                                                       I have included an additional intent in this phase so that the page is refreshed when registration fails.

*/
// ********************************************************* COMMENTING THE CODE END *********************************************************