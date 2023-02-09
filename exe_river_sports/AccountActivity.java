package com.exe_river_sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

// ******************************************** START OF BUTTON VARIABLES ********************************************
        EditText username, newpassword, renewpassword;
        Button BtnHome, BtnAbout, BtnLogout, BtnSubmit, BtnDeleteacc;
        DBHelper DB;
// ******************************************** END OF BUTTON VARIABLES ********************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

// ******************************************** R ID START ********************************************
        username = (EditText) findViewById(R.id.username);

        newpassword = (EditText) findViewById(R.id.newpassword);

        renewpassword = (EditText) findViewById(R.id.renewpassword);

        BtnHome = findViewById(R.id.btnhome);

        BtnAbout = findViewById(R.id.btnabout);

        BtnLogout = findViewById(R.id.btnlogout);

        BtnSubmit = findViewById(R.id.btnsubmit);

        BtnDeleteacc = findViewById(R.id.btndeleteacc);

        DB = new DBHelper(this);
// ******************************************** R ID END ********************************************


// ******************************************** LISTENERS START ********************************************
        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Home page.

        });

        BtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the About page.

        });

        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Login page.

        });

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText() .toString();
                String newpass = newpassword.getText() .toString();
                String renewpass = renewpassword.getText() .toString();

                if(user.equals("")||newpass.equals(""))
                    Toast.makeText(AccountActivity.this, "Please populate all fields", Toast.LENGTH_SHORT).show();
                else{
                    if(newpass.equals(renewpass)){
                        Boolean checkusername = DB.checkusername(user);
                        if (checkusername==true){
                        Boolean checkupdatedata = DB.updateData(user, newpass);
                        if(checkupdatedata==true){

                                Toast.makeText(AccountActivity.this, "Password Change Successful! Please login with your new password", Toast.LENGTH_SHORT) .show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            }else {
                                Toast.makeText(AccountActivity.this, "Failed! Check Username and try again!", Toast.LENGTH_SHORT).show();
                            }
                        } else{
                            Toast.makeText(AccountActivity.this, "Failed! Check Username and try again!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(AccountActivity.this, "Passwords don't match, please check and try again!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        BtnDeleteacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DeleteActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Delete page.

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

BtnSubmit.setOnClickListener(new View.OnClickListener():
                                                     - This code is more complex so I will try and explain it as it runs. The first line is the same as before,
                                                       watching the button 'BtnSubmit' for a state change. Once state changes the code runs.
                                                       String user = username.getText() .toString(); This line is saying the string user(defined above
                                                       as a variable) is equal to the username that comes from the text that has been input by user and converts it to a string.
                                                       if(user.equals("")||newpass.equals("")) this is an 'if' statement and this line is saying that if the 'user' and
                                                       'newpass' variables are empty, then run the next piece of code which is a Toast method.
                                                       Toast.makeText(AccountActivity.this, "Please populate all fields", Toast.LENGTH_SHORT).show(); which just creates a pop-up
                                                       to advise the user to populate all fields. Then comes the 'Else' statement and this is if the variable elements
                                                       aren't empty. The code then moves on to the next piece of code. I include another 'if' statement in the else statement.
                                                       if(newpass.equals(renewpass)){ this line is saying if the 'newpass' and 'renewpass' variables match then run the
                                                       next piece of code, otherwise run a 'Toast' statement which will create a pop-up advising the user that the passwords
                                                       entered don't match.
                                                       Boolean checkusername = DB.checkusername(user); This is the code that is run if the 'if' statement parameters above are met,
                                                       Boolean is a yes or no method using true and false. This is saying that if the username provided by the user matches
                                                       the username on the DB(database) then run the next line of code, but has another 'else' statement which will have
                                                       another 'toast' statement giving the user a pop-up advising to check the username they have provided.
                                                       Boolean checkupdatedata = DB.updateData(user, newpass); This line is another boolean (true or false) method and is
                                                       essentially saying to update the username with newpass variable. This is why I have the statement above that checks
                                                       that both passwords are correct and checks the username is correct. As an extra future feature I would put a current password checker in too.
                                                       if(checkupdatedata==true){ This is another boolean to check if the update has been successful if it returns true then
                                                       the next line of code will be run, if it isn't then another 'else' statement will be used with a 'toast' method advising
                                                       the the user.
                                                       Right in the centre of the code once every parameter has been met and the user has successfully changed their password
                                                       a 'toast' method will come in to play to advise the user of its success. I included an extra feature and put an intent in
                                                       Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                                       startActivity(intent); This will navigate the user to the Login page so that they can login again but with their new password.
*/
// ********************************************************* COMMENTING THE CODE END *********************************************************