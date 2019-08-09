package com.example.c0753560_mad3125_midterm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0753560_mad3125_midterm.JavaClasses.DbUser;
import com.example.c0753560_mad3125_midterm.JavaClasses.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class loginClass extends AppCompatActivity
{


    @BindView(R.id.txtEmail)
    TextView edtEmail;
    @BindView(R.id.txtPassword)
    TextView edtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;


    Map<String,String > usersMapList = new HashMap<>();
    SharedPreferences mSharedpreferences;
    SharedPreferences.Editor mEditor;
    ArrayList<User> mUsersArrayList;
    private DbUser mDBUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        mDBUser = new DBUser(this);
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
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if(edtEmail.getText().toString().isEmpty() || edtEmail.getText().toString().trim().length() == 0)
                {
                    edtEmail.setError("Enter Email : ");
                    if(edtPassword.getText().toString().isEmpty() || edtPassword.getText().toString().trim().length() == 0)
                    {
                        edtPassword.setError("Enter Password : ");
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
                                Toast.makeText(LoginActivity.this, "Correct Details Entered", Toast.LENGTH_SHORT).show();
                                if(switchRememberMe.isChecked() == true)
                                {
                                    saveRememeberMe();
                                }
                                else
                                {
                                    saveRememeberMeEmpty();
                                }
                                String action;
                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                //Password is incorrect
                                edtPassword.setError("Password is Incorrect");

                            }
                        }
                        else
                        {
                            //No User with this Email in DataBase
                            edtEmail.setError("No User with this Email in DataBase");
                        }
                    }
                    else
                    {
                        edtEmail.setError("Not Valid Email Address");
                    }
                }
            }
        });


    }
}