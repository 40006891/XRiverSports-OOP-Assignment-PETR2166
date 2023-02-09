package com.exe_river_sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

// ******************************************** START OF BUTTON VARIABLES ********************************************
    EditText username, password;
    Button signup, btnlogin;
    DBHelper DB;
// ******************************************** END OF BUTTON VARIABLES ********************************************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


// ******************************************** R ID START ********************************************
        username = (EditText) findViewById(R.id.username1);

        password = (EditText) findViewById(R.id.password1);

        btnlogin = (Button) findViewById(R.id.btnsignin1);

        signup = (Button) findViewById(R.id.btnsignup);

        DB = new DBHelper(this);
// ******************************************** R ID END ********************************************



// ******************************************** LISTENERS START ********************************************
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText() .toString();
                String pass = password.getText() .toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Sign in successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Incorrect Username or password, please check and try again.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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

btnlogin.setOnClickListener(new View.OnClickListener():
                                                     - The listener is watching the button 'btnlogin' for a state change. Once state changes the code runs.
                                                       String user = username.getText() .toString(); This line is saying the string user(defined above
                                                       as a variable) is equal to the username that comes from the text that has been input by user and converts it to a string.
                                                       if(user.equals("")||pass.equals("")) this is an 'if' statement and this line is saying that if the 'user' and
                                                       'pass' variables are empty, then run the next piece of code which is a Toast method.
                                                       Toast.makeText(AccountActivity.this, "Please populate all fields", Toast.LENGTH_SHORT).show(); which just creates a pop-up
                                                       to advise the user to populate all fields. Then comes the 'Else' statement and this is if the variable elements
                                                       aren't empty. The code then moves on to the next piece of code.
                                                       Boolean checkuserpass = DB.checkusernamepassword(user, pass); This is the code that is run if the 'if' statement parameters above aren't met,
                                                       Boolean is a yes or no method using true and false. This is saying that if the username and password provided by the user matches
                                                       the username and password on the DB(database) then run the next line of code, but has another 'else' statement which will have
                                                       another 'toast' statement giving the user a pop-up advising to check the username and password they have provided.
                                                       if(checkuserpass==true){ this is saying that if the username and password provided match then run the next piece of code which is a 'toast'
                                                       method giving the user a pop-up saying login successful and thn runs an intent page which will navigate the user away from the login page
                                                       and onto the main landing page of the app.

*/
// ********************************************************* COMMENTING THE CODE END *********************************************************