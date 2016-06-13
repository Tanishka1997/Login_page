package com.example.tanishka.loginpage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Details extends Activity {
    TextView t;
    StringBuilder buffer;
    Database mydb;                                          //objects created
     public String pwd,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) //gets crated automatically
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mydb=new Database(this);                            //constructor

        Bundle bun = getIntent().getExtras();              //used for passing the name and password
        name=bun.getString("name");
        pwd=bun.getString("pwd");
       t=(TextView) findViewById(R.id.t1);
        showd();
    }
    public void showd()                                     //meant for showing the data
                                                            /*
                                                            re is a cursor object
                                                            movetoFirst moves the cursor to the first and only position because we have selected only one row here...unique username and password

                                                             */
    {

                Cursor re = mydb.getData(name,pwd);


               buffer = new StringBuilder();

                     if (re.moveToFirst()) {
                    buffer.append("Admission no: " + re.getString(0) + "\n");
                    buffer.append("Name: " + re.getString(1) + "\n");
                    buffer.append("Address: " + re.getString(2) + "\n");
                    buffer.append( "Phone: "+re.getString(3)+"\n");
                    buffer.append("Blood group: " + re.getString(4) + "\n\n");
                   t.setText(""+buffer.toString());
                }



    }


}
