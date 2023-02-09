package com.exe_river_sports;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


//This is the methods on working the database everything from creation to update and delete.
public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db"; //This line is creating a static string and giving DBNAME (database name) equal Login.db


// ******************************************************** DB HELPER **************************************************************
    public DBHelper( Context context) {
        super(context, "Login.db", null, 1);
    }
// ******************************************************** DB HELPER **************************************************************



// ******************************************************** CREATE METHOD **************************************************************
    @Override
    public void onCreate(SQLiteDatabase MyDB) {

       MyDB.execSQL("create Table users (username TEXT primary key, email TEXT, password TEXT)");
       // Comments for the above code are at the bottom of page

    }
// ******************************************************** CREATE METHOD **************************************************************



// ******************************************************** UPGRADE METHOD **************************************************************
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        MyDB.execSQL("drop Table if exists users");
    }
                                        // Comments for the above code are at the bottom of page
// ******************************************************** UPGRADE METHOD **************************************************************



// ******************************************************** INSERT METHOD **************************************************************
    public boolean insertData(String username, String user_email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", user_email);
        contentValues.put("password", password);
        long result = MyDB.insert( "users", null, contentValues);
        if (result ==-1) return false;
        else
            return true;
    }                                        // Comments for the above code are at the bottom of page
// ******************************************************** INSERT METHOD **************************************************************



// ******************************************************** UPDATE METHOD **************************************************************
    public boolean updateData(String username, String newpassword) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", newpassword);
        long result = MyDB.update("users", contentValues, "username=?", new String[]{username});
        if (result ==-1) {
            return false;
        } else {
            return true;
        }
    }                                        // Comments for the above code are at the bottom of page
// ******************************************************** UPDATE METHOD **************************************************************



// ******************************************************** DELETE METHOD **************************************************************
    public boolean deleteData(String username2) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ?", new String[]{username2});
        if (cursor.getCount() > 0) {
            long result = MyDB.delete("users", "username=?", new String[]{username2});
            if (result == -1) {
                return false;
            } else {
                return true;
            }

        }
        return false;
    }                                        // Comments for the above code are at the bottom of page
// ******************************************************** DELETE METHOD **************************************************************



// ******************************************************** CHECK USERNAME METHOD **************************************************************
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }                                            // Comments for the above code are at the bottom of page
// ******************************************************** CHECK USERNAME METHOD **************************************************************



// ******************************************************** CHECK USERNAME PASSWORD METHOD **************************************************************
    public boolean checkusernamepassword (String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and  password = ?", new String[] {username, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }}
                                                // Comments for the above code are at the bottom of page
// ******************************************************** CHECK USERNAME PASSWORD METHOD **************************************************************



// ********************************************************* COMMENTING THE CODE START *********************************************************
/*
 ***** I decided to put my large comments down here as I felt it made my coding look too cluttered. *****


MyDB.execSQL("create Table users (username TEXT primary key, email TEXT, password TEXT)");
                                                                    - The line above is saying that My database will execute the SQLite and when the 'onCreate'
                                                                      method is called then create a new database called 'users', making the 'username' the primary
                                                                      key and then adding 2 additional columns called 'email' and 'password'


MyDB.execSQL("drop Table if exists users");                         - This means that the code will drop the table if already exists, the line is saying that when a new account
                                                                      is created there can only be one instance of the database but database is set to auto increment so another
                                                                      user can register and another row will be created inside the database. The line advising to drop table is
                                                                      'users' exist means that when a user creates an account and there is already a database called 'users' then
                                                                      to drop the 'onCreate' code of creating a new database because there can only be one.

INSERT METHOD:
   public boolean insertData(String username, String user_email, String password) { - This line is saying it intends to insert 'username', 'user_email' and 'password'
       SQLiteDatabase MyDB = this.getWritableDatabase();                            - This line is saying to get the database (MyDB) which is editable or writable as the term
                                                                                      states allowing for new values to be input into said DB.
            ContentValues contentValues = new ContentValues();                      - This line is similar to the 'intent' method and says that ContentValues contentvalues are
                                                                                      going to change to new content values of ()
            contentValues.put("username", username);                                - This line is a content value and is telling the database to insert the users input saved under
                                                                                      the 'username' variable into the corresponding column called 'username' within the database
            contentValues.put("email", user_email);                                 - This line is a content value and is telling the database to insert the users input saved under
                                                                                      the 'user_email' variable into the corresponding column called 'email' within the database
            contentValues.put("password", password);                                - This line is a content value and is telling the database to insert the users input saved under
                                                                                      the 'password' variable into the corresponding column called 'password' within the database
            long result = MyDB.insert( "users", null, contentValues);               - This line is saying insert variables into table 'users' in an empty row (this prevents overwriting)
                if (result ==-1) return false;                                      - A boolean (true/false) method has been used to check and make sure this has been input. if the result
                                                                                      shows less than one row with the details that have just been input into the database it should return
                                                                                      false (which in this case will result in a failed insertion)
                    else return true;                                               - An 'else' statement is used and is essentially saying that if result is true then move on and return
                                                                                      true (which will mean a successful insertion)


UPDATE METHOD:          - The 'updateData' method is essentially the same as the 'insertData' method. The only difference is there is less code because this method is updating an existing
                          entity with a single variable being the password.

DELETE METHOD:          - The 'deleteData' method is again similar to the 'insertData' and 'updateData', with the difference being this is removing the user. To remove the user from the
                          database we only actually need the username of the user and we remove that, without the username (which is the primary key defined during the creation process)
                          when that is removed the whole row is removed for that user from the database. Again a boolean is used to return true or false to confirm completion or failure

CHECK USERNAME METHOD:  - This is a 'checkusername' method and grabs all info for a specific user. So the line MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
                          is going to run a query and select all from table 'users' where the username matched the variable (element provided by the user), an 'if' statement has been used so
                          that if the database finds more than 0 matches with the username (as in it finds a match) then it will return true which means yes. If there is no username matched
                          then return false (meaning no).

CHECK USERNAME PASSWORD METHOD:
                        - The 'checkusernamepassword' method is the same as the 'checkusername' method, but checks the password too.

*/
// ********************************************************* COMMENTING THE CODE END *********************************************************