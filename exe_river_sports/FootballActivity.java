package com.exe_river_sports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class FootballActivity extends AppCompatActivity {


// ******************************************** START OF BUTTON VARIABLES ********************************************
    Button BtnHome, BtnBack, BtnBuy, BtnComplete;
    CheckBox CheckMember, CheckAdult, CheckChild, CheckPint, CheckPie, CheckTour, CheckMeetngreet;
    TextView BuyTotal;
// ******************************************** END OF BUTTON VARIABLES ********************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);


// ******************************************** R ID START ********************************************
        BtnHome = findViewById(R.id.btnhome);

        BtnBack = findViewById(R.id.btnback);

        BtnBuy = findViewById(R.id.btnbuy);

        BtnComplete = findViewById(R.id.BtnComplete);

        CheckMember=findViewById(R.id.CheckMember);

        CheckAdult=findViewById(R.id.CheckAdult);

        CheckChild=findViewById(R.id.CheckChild);

        CheckPint=findViewById(R.id.CheckPint);

        CheckPie=findViewById(R.id.CheckPie);

        CheckTour=findViewById(R.id.CheckTour);

        CheckMeetngreet=findViewById(R.id.CheckMeetngreet);

        BuyTotal=findViewById(R.id.buytotal);
// ******************************************** R ID END ********************************************



// ******************************************** LISTENERS START ********************************************
        BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Home page.

        });

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TicketActivity.class);
                startActivity(intent);
            } // This is the intent that moves the user to the Ticket page.

        });

        BtnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CompleteActivity.class);
                startActivity(intent);
                Toast.makeText(FootballActivity.this, "Purchase Successful!", Toast.LENGTH_SHORT).show();
            } // This is the intent that moves the user to the page specified, the toast means pop-up and that means the pop-up
              // will be displayed once the button is clicked.
        });

        BtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnComplete.setVisibility(View.VISIBLE);
                int TotalAmount=0;
                StringBuilder result=new StringBuilder();
                result.append("BASKET");
                if (CheckMember.isChecked()){
                    result.append("\n Member Discount");
                    TotalAmount += 30;
                }
                if (CheckAdult.isChecked()){
                    result.append("\n Adult Ticket");
                    TotalAmount += 40;
                }
                if (CheckChild.isChecked()){
                    result.append("\n Child Ticket");
                    TotalAmount += 25;
                }
                if (CheckPint.isChecked()){
                    result.append("\n Pint");
                    TotalAmount += 2;
                }
                if (CheckPie.isChecked()){
                    result.append("\n Pie");
                    TotalAmount += 1;
                }
                if (CheckTour.isChecked()){
                    result.append("\n Tour");
                    TotalAmount += 20;
                }
                if (CheckMeetngreet.isChecked()){
                    result.append("\n Meet & Greet");
                    TotalAmount += 40;
                }
                result.append("\n TOTAL: £"+TotalAmount);

                BuyTotal.setText(result.toString());
            }
        });
// ******************************************** LISTENERS END ********************************************

    }
}

// ********************************************************* COMMENTING THE CODE START *********************************************************
/*
    ***** I decided to put my large comments down here as I felt it made my coding look too cluttered. *****

Top of page above button variables:
                   - 'public class FootballActivity extends AppCompatActivity'
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

BtnBuy.setOnClickListener(new View.OnClickListener() :
                                          - public void onClick(View v) {                - This line is creating a public void with 'onClick' as the method, this
                                                                                           means it will change state when the user clicks on the container
                                            BtnComplete.setVisibility(View.VISIBLE);     - This line is saying that when the 'BtnBuy' button is clicked by the user
                                                                                           the visibility of the 'BtnComplete' button will become visible, this was
                                                                                           a work around so that users wouldn't see the checkout button and click it
                                                                                           before making a selection
                                            int TotalAmount=0;                           - This line is saying that the total amount starts at 0
                                            StringBuilder result=new StringBuilder();    - This will build and add the strings together making a new string each time
                                            result.append("BASKET");                     - This line is saying that the result will be put underneath the object within
                                                                                           the double quotes, in this case I put 'BASKET'.
                                            if (CheckMember.isChecked()){                - This line is saying saying if the box is checked
                                            result.append("\n Member Discount");         - This line defines the button to check and adds it to the result, which as
                                                                                           before starts with 'BASKET'
                                            TotalAmount += 30;                           - This line adds a total to the integer result.  The last part of this isn't in
                                                                                           this line, we will get there in a few miniutes.
                                            }
                                            result.append("\n TOTAL: £"+TotalAmount);    - This line adds everything together creates a new line (\n) and then includes
                                                                                           the string "TOTAL: £" then inserts Total amount.
                                            BuyTotal.setText(result.toString());         - So now what will be output is "Basket \n Member Discount \n TOTAL: £30" once
                                                                                           the button is clicked.
                                                                                           I have streamlined the code for commenting purposes as there are many elements
                                                                                           that can be added to this piece of code nad it would waste time to comment each
                                                                                           line as they would each say the same thing. However, if you look at the code it
                                                                                           is saying if the checkbox is selected then add it to the running total if it is
                                                                                           not then do nothing and don't add it
*/
// ********************************************************* COMMENTING THE CODE END *********************************************************



