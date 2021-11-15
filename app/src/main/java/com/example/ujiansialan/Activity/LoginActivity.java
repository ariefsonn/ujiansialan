package com.example.ujiansialan.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.ujiansialan.Base.Constant;
import com.example.ujiansialan.R;
import com.example.ujiansialan.session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    TextView Register;
    EditText i_user, i_pass, register;
    String user, pass;
    Button masuk;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    SessionManager sessionManager;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        masuk = findViewById(R.id.b_login);
        i_user = findViewById(R.id.l_user);
        i_pass = findViewById(R.id.l_password);
        register = findViewById(R.id.kontol);

        sessionManager = new SessionManager(LoginActivity.this);

        if (sessionManager.isLogged()) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
            String emaiku = preferences.getString("email", "");
            Log.d("emailloginsession", emaiku);
            startActivity(intent);
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                Context context;
                preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                editor = preferences.edit();
                editor.apply();
                startActivity(intent);
            }
        });

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = i_user.getText().toString();
                pass = i_pass.getText().toString();
                getTauAhGelap(user, pass);
            }
        });

    }

    private void getTauAhGelap(final String s, final String p) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
