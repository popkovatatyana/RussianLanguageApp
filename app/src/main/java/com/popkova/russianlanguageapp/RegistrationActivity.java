package com.popkova.russianlanguageapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationActivity extends AppCompatActivity {
    Button bRegister;
    EditText edLogin, edPassword, edAge, edName, edSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edLogin = (EditText) findViewById(R.id.EMAIL_REGISTER);
        edAge = (EditText) findViewById(R.id.AGE_REGISTER);
        edName = (EditText) findViewById(R.id.NAME_REGISTER);
        edPassword = (EditText) findViewById(R.id.PASSWORD_REGISTER);
        edSurname = (EditText) findViewById(R.id.SURNAME);
        bRegister = (Button) findViewById(R.id.REGISTER_BUTTON);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = edName.getText().toString();
                final String username = edLogin.getText().toString();
                final int age = Integer.parseInt(edAge.getText().toString());
                final String password = edPassword.getText().toString();
                final String surname = edSurname.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                                RegistrationActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("R" +
                                                "etry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, surname, username, password, age, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegistrationActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}

