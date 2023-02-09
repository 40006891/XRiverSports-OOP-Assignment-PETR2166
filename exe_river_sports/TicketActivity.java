package com.exe_river_sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TicketActivity extends AppCompatActivity {


// ******************************************** START OF BUTTON VARIABLES ********************************************
    Button BtnHome, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8;
// ******************************************** END OF BUTTON VARIABLES ********************************************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);


// ******************************************** R ID START ********************************************
        BtnHome = findViewById(R.id.btnhome);

        Btn1 = findViewById(R.id.btnfootball);

        Btn2 = findViewById(R.id.btntennis);

        Btn3 = findViewById(R.id.btnnetball);

        Btn4 = findViewById(R.id.btndarts);

        Btn5 = findViewById(R.id.btnhockey);

        Btn6 = findViewById(R.id.btnrowing);

        Btn7 = findViewById(R.id.btncycling);

        Btn8 = findViewById(R.id.btnrugby);
// ******************************************** R ID END ********************************************


// ******************************************** LISTENERS START ********************************************
        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Home page.

        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FootballActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Football page.

        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TennisActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Tennis page.

        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NetballActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Netball page.

        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DartsActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Darts page.

        });

        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Hockey2Activity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Hockey page.

        });

        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rowing2Activity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Rowing page.

        });

        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cycling2Activity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Cycling page.

        });

        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rugby2Activity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Rugby page.

        });
// ******************************************** LISTENERS END ********************************************

    }
}

// ********************************************************* COMMENTING THE CODE START *********************************************************
/*
    ***** I decided to put my large comments down here as I felt it made my coding look too cluttered. *****

Top of page above button variables:
                   - 'public class TicketActivity extends AppCompatActivity'
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

*/
// ********************************************************* COMMENTING THE CODE END *********************************************************