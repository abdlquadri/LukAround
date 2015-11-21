package com.example.andela.lukaround.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andela.lukaround.MapsActivity;
import com.example.andela.lukaround.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialise();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        try {
            String username = mUsername.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
//            UserAuthentication userAuthentication = new UserAuthentication(LoginActivity.this, username, password);
            switch (v.getId()){
                case R.id.loginButton:
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.registerUser:
                    Intent register = new Intent(this, RegisterActivity.class);
                    startActivity(register);
                    break;
                case R.id.FacebookLoginButton:
//                    userAuthentication.FacebookLogin();
                    break;
            }

        } catch(Exception e){
            e.printStackTrace();
        }
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
    private void initialise() {
        mUsername = (EditText) findViewById(R.id.usernameLoginTextBox);
        mPassword = (EditText) findViewById(R.id.passwordLoginTextBox);

        TextView registerUser = (TextView) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        Button facebookLoginButton = (Button) findViewById(R.id.FacebookLoginButton);
        facebookLoginButton.setOnClickListener(this);
    }



}
