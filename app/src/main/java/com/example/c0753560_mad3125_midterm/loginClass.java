package com.example.c0753560_mad3125_midterm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0753560_mad3125_midterm.JavaClasses.DbUser;
import com.example.c0753560_mad3125_midterm.JavaClasses.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loginClass extends AppCompatActivity
{


    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtPassword)
    TextView txtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.swtchRemember)
    Switch switchRememberMe;


    Map<String,String > usersMapList = new HashMap<>();
    SharedPreferences mSharedpreferences;
    SharedPreferences.Editor mEditor;
    ArrayList<User> mUsersArrayList;
    private DbUser mDBUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        mDBUser = new DbUser(this);
        mUsersArrayList = mDBUser.getAllUsers();
        if (mUsersArrayList.isEmpty())
        {
            loadUserIntoDB();
            Log.d("USER ----->>>>","Users have been Loaded");

        }
        else
        {
            Log.d("Total Users -->>>>>>",String.valueOf(mUsersArrayList.size()));
            for(User u : mUsersArrayList)
            {
                Log.d("USER", u.toString());
            }
        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        ButterKnife.bind(this);
        convertListToMap();
        //usersMapList.put("admin@admin.com","admin"); // key , value
        //usersMapList.put("test@test.com","test");
        if(switchRememberMe.isChecked() == true)
        {
            getRememberMe();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                if(txtEmail.getText().toString().isEmpty() || txtEmail.getText().toString().trim().length() == 0)
                {
                    txtEmail.setError("Enter Email : ");
                    if(txtPassword.getText().toString().isEmpty() || txtPassword.getText().toString().trim().length() == 0)
                    {
                        txtPassword.setError("Enter Password : ");
                    }
                }
                else
                {
                    if(validateEmail(email))
                    {
                        if (usersMapList.containsKey(email))
                        {
                            //Valid email of user
                            if (usersMapList.containsValue(password))
                            {
                                //password matches so User confirmed
                                Toast.makeText(loginClass.this, "Correct Details Entered", Toast.LENGTH_SHORT).show();
                                if(switchRememberMe.isChecked() == true)
                                {
                                    saveRememeberMe();
                                }
                                else
                                {
                                    saveRememeberMeEmpty();
                                }
                                String action;
                                Intent intent=new Intent(loginClass.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                //Password is incorrect
                                txtPassword.setError("Password is Incorrect");

                            }
                        }
                        else
                        {
                            //No User with this Email in DataBase
                            txtEmail.setError("No User with this Email in DataBase");
                        }
                    }
                    else
                    {
                        txtEmail.setError("Not Valid Email Address");
                    }
                }
            }
        });


    }

    private void saveRememeberMe()
    {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        mEditor.putString("email", txtEmail.getText().toString());
        mEditor.putString("password",txtPassword.getText().toString());
        mEditor.commit();
    }
    private void saveRememeberMeEmpty()
    {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        mEditor.putString("email", "");
        mEditor.putString("password","");
        mEditor.commit();
    }
    private void getRememberMe()
    {
        mSharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        mEditor = mSharedpreferences.edit();
        String email = mSharedpreferences.getString("email", "");
        String password = mSharedpreferences.getString("password","");
        txtEmail.setText(email);
        txtPassword.setText(password);
    }

    public Boolean validateEmail(String email) {

        String regex = "^[a-z0-9A-Z\\.]*@[a-z0-9A-Z]*\\.[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void loadUserIntoDB()
    {
        User user1 = new User(1,"admin@admin.com","admin");
        mDBUser.insert(user1);
        User user2 = new User(2,"test@test.com","test");
        mDBUser.insert(user2);
        User user3 = new User(3,"tar@tar.com","tar");
        mDBUser.insert(user3);
        User user4 = new User(4,"abc@abc.com","abc");
        mDBUser.insert(user4);
        User user5 = new User(5,"xyz@xyz.com","xyz");
        mDBUser.insert(user5);
    }

    private void convertListToMap()
    {
        for(User u : mUsersArrayList)
        {
            usersMapList.put(u.getUserEmail(),u.getUserPassword());
        }
    }
}