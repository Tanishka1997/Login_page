package com.example.tanishka.loginpage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

 Database mdb;
     EditText name,address,phone,admission,blood_group,password;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       mdb=new Database(this);
        name=(EditText) findViewById(R.id.name);
        address=(EditText) findViewById(R.id.address);
        phone=(EditText) findViewById(R.id.phone);
        admission=(EditText) findViewById(R.id.admission);
        blood_group=(EditText) findViewById(R.id.blood_group);
        password=(EditText) findViewById(R.id.password);
        submit=(Button) findViewById(R.id.apply);
        add();
            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);}

        public void add() {
            submit.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean a = mdb.insertData(name.getText().toString(),address.getText().toString(), phone.getText().toString(), admission.getText().toString(), blood_group.getText().toString(), password.getText().toString());
                            name.setText("");
                            address.setText("");
                            phone.setText("");
                            admission.setText("");
                            blood_group.setText("");
                            password.setText("");
                            if (a)
                                Toast.makeText(Register.this, "Data inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Register.this, "Data not inserted", Toast.LENGTH_LONG).show();
                        }


                    });
        }
    }


