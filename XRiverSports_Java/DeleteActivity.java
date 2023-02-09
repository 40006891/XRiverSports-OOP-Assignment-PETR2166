package com.exe_river_sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

// ******************************************** START OF BUTTON VARIABLES ********************************************
    Button BtnDelete, BtnHome;
    EditText username, email, password;
    DBHelper DB;
// ******************************************** END OF BUTTON VARIABLES ********************************************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);


// ******************************************** R ID START ********************************************
        BtnHome = findViewById(R.id.btnhome);

        BtnDelete = findViewById(R.id.btndelete);

        username = (EditText) findViewById(R.id.username2);

        password = (EditText) findViewById(R.id.password2);

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

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(DeleteActivity.this, "Please populate all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Boolean checkdeletedata = DB.deleteData(user);
                        if (checkdeletedata == true) {

                            Toast.makeText(DeleteActivity.this, "Account Successfully Removed!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent); // This is the intent that moves the user to the Main page.
                        } else {
                            Toast.makeText(DeleteActivity.this, "Failed! Check Username and try again!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(DeleteActivity.this, "Failed! Check Username and password then try again!", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
// ******************************************** LISTENERS END ********************************************

    }
}

// ********************************************************* COMMENTING THE CODE START *********************************************************
/*
    ***** I decided to put my large comments down here as I felt it made my coding look too cluttered. *****

Top of page above button variables:
                   - 'public class DeleteActivity extends AppCompatActivity'
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

BtnDelete.setOnClickListener(new View.OnClickListener():
                                                    - The first line is the same as before on the Account Activity page.
                                                      On listener watches the button 'BtnDelete' for a state change. Once state changes the code runs.
                                                      String user = username.getText() .toString(); This line is saying the string user(defined above
                                                      as a variable) is equal to the username that comes from the text that has been input by user and converts it to a string.
                                                      if(user.equals("")||pass.equals("")) this is an 'if' statement and this line is saying that if the 'user' and
                                                      'pass' variables are empty, then run the next piece of code which is a Toast method.
                                                      Toast.makeText(DeleteActivity.this, "Please populate all fields", Toast.LENGTH_SHORT).show(); which just creates a pop-up
                                                      to advise the user to populate all fields. Then comes the 'Else' statement and this is if the variable elements
                                                      aren't empty. The code then moves on to the next piece of code
                                                      Boolean checkuserpass = DB.checkusernamepassword(user, pass); is going to check the database to check that the username and
                                                      password provided by the user are matched if so return true and continue, if return false then run the 'else' statement
                                                      If return true run Boolean checkdeletedata = DB.deleteData(user); this will delete and check that it has been successfully
                                                      deleted and again utilising a boolean to return true or false. If true is returned run 'if' statement (checkdeletedata == true)
                                                      This checks deletion then runs a 'Toast' method advising of success and then I have added an intent which navigates the user
                                                      back to the registration page.

*/
// ********************************************************* COMMENTING THE CODE END *********************************************************