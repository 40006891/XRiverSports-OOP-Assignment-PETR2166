package com.exe_river_sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CompleteActivity extends AppCompatActivity {

// ******************************************** START OF BUTTON VARIABLES ********************************************
    Button Button; // We have declared the variable btn about.
// ******************************************** END OF BUTTON VARIABLES ********************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);


//******************************************** R ID START ********************************************
        Button = findViewById(R.id.btnhome);
//******************************************** R ID END ********************************************


// ******************************************** LISTENERS START ********************************************
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the about page.

        });
//******************************************** LISTENERS END ********************************************

    }

}

// ********************************************************* COMMENTING THE CODE START *********************************************************
/*
***** I decided to put my large comments down here as I felt it made my coding look too cluttered. *****

Top of page above button variables:
                   - 'public class AboutActivity extends AppCompatActivity'
                      is doing exactly what it says, and is extending the AppCompatActivity. AppCompatActivity is the base class used to allow
                      newer features on older android devices. Essentially making it backward compatible.

Button Variables:  - These are just the variables created to link between elements on this page.


onCreate           - is a method, this is the same method used across every activity page and it stores data into a bundle

R ID:              -This is saying 'BtnHome' is equal to 'btnhome' and will link to the Xml version of this activity via that variable/ID using
                    the findViewByID method.

Listener:         - This is the listener and observes the button defined at the beginning of the line 'BtnHome' and waits to see if its state
                    changes, if the button is clicked for example then the state has changed and the following code will run. This listener for example
                    is going to navigate the user to a new page. The sentence 'Intent intent = new Intent(getApplicationContext(), HomeActivity.class);'
                    is saying that intent is changing from intent to new intent and getting the application context then starting activity and taking the
                    user to the next page, in this case HomeActivity page.
*/
// ********************************************************* COMMENTING THE CODE END *********************************************************
