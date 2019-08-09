package com.example.c0753560_mad3125_midterm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0753560_mad3125_midterm.JavaClasses.DBUser;
import com.example.c0753560_mad3125_midterm.JavaClasses.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity
{


    Map<String, String> usersMapList = new HashMap<>();
    SharedPreferences mSharedpreferences;
    SharedPreferences.Editor mEditor;
    ArrayList<User> mUsersArrayList;

    @BindView(R.id.button)
    Button buttonLogin;
    @BindView(R.id.switchRememberme)
    Switch switchRememberMe;
    @BindView(R.id.edtemail)
    EditText edtEmail;
    @BindView(R.id.edtpassword)
    EditText edtpassword;
    private DBUser mDBUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mDBUser = new DBUser(this);
        mUsersArrayList = mDBUser.getAllUsers();
        if ( mUsersArrayList.isEmpty()) {
            loadUserIntoDB();

        } else {
            for (User u : mUsersArrayList) {
                Log.d("USER", u.toString());
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        convertListToMap();
        if (switchRememberMe.isChecked() == true) {
            getRememberMe();
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtpassword.getText().toString();
                if (edtEmail.getText().toString().isEmpty() || edtEmail.getText().toString().trim().length() == 0) {
                    edtEmail.setError("Enter vali email : ");
                    if (edtpassword.getText().toString().isEmpty() || edtpassword.getText().toString().trim().length() == 0) {
                        edtpassword.setError("Enter valid password: ");
                    }
                } else {
                    if (validateEmail(email)) {
                        if (usersMapList.containsKey(email)) {
                            if (usersMapList.containsValue(password)) {
                                Toast.makeText(LoginActivity.this, "Correct Details Entered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                if (switchRememberMe.isChecked() == true) {
                                    saveRememeberMe();
                                } else {
                                    saveRememeberMeEmpty();
                                }

                            } else {
                                //Password is incorrect
                                edtpassword.setError("Password is Incorrect");

                            }
                        } else {
                            //No User with this Email in DataBase
                            edtEmail.setError("Incorrect details");
                        }
                    } else {
                        edtEmail.setError("Not Valid Email Address");
                    }
                }
            }
        });


    }
    private void saveRememeberMe() {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        mEditor.putString("email", edtEmail.getText().toString());
        mEditor.putString("password", edtpassword.getText().toString());
        mEditor.commit();
    }
    private void saveRememeberMeEmpty() {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        mEditor.putString("email", "");
        mEditor.putString("password", "");
        mEditor.commit();
    }
    private void getRememberMe() {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        String email = mSharedpreferences.getString("email", "");
        String password = mSharedpreferences.getString("password", "");
        edtEmail.setText(email);
        edtpassword.setText(password);
    }
    public Boolean validateEmail(String email) {
        String regex = "^[a-z0-9A-Z\\.]*@[a-z0-9A-Z]*\\.[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    public void loadUserIntoDB() {
        User user1 = new User(1, "karangmail.com", "karan123");
        mDBUser.insert(user1);
        User user2 = new User(2, "naina@gmail.com", "naina123");
        mDBUser.insert(user2);
        User user3 = new User(3, "jazz@gmail.com.com", "jazz123");
        mDBUser.insert(user3);
        User user4 = new User(4, "kishore@gmail.com", "kishore123");
        mDBUser.insert(user4);
        User user5 = new User(5, "shivani@gmail.com", "shivani123");
        mDBUser.insert(user5);
    }
    private void convertListToMap() {
        for (User u : mUsersArrayList) {
            usersMapList.put(u.getEmail(), u.getPassword());
        }
    }
}
