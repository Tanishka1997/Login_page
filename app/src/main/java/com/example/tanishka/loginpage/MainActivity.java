package com.example.tanishka.loginpage;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText user, p;
    Button login;
    Database mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new Database(this);
        user = (EditText) findViewById(R.id.enter_userid);
        p = (EditText) findViewById(R.id.password2);
        login = (Button) findViewById(R.id.enter);
        viewdata();
    }

    public void showmessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }




    public void viewdata() {

    //called when login is clicked

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getData(user.getText().toString(), p.getText().toString());

                if (res.getCount() == 0) {

                    showmessage("ERROR", "INVALID USER NAME OR PASSWORD");
                    user.setText("");
                    p.setText("");
                    return;

                }

                Intent i = new Intent(MainActivity.this,Details.class);
                i.putExtra("name",user.getText().toString());
                i.putExtra("pwd",p.getText().toString());
                user.setText("");
                p.setText("");
                startActivity(i);
            }
                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }


    public void register(View view) {
        Intent intent = new Intent(this, Register.class);

        startActivity(intent);
    }

    }


