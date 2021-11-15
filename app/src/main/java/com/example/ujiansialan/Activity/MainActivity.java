package com.example.ujiansialan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ujiansialan.Adapter.AdapterStuffM;
import com.example.ujiansialan.Base.Constant;
import com.example.ujiansialan.HTTP.UtilsJson;
import com.example.ujiansialan.Modal.f_stuff;
import com.example.ujiansialan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<f_stuff> stuffs;
    AdapterStuffM adapterStuffM;
    GridLayoutManager glm;
    RecyclerView rc;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        rc = findViewById(R.id.r_main);

        getStuff();

        stuffs = new ArrayList<>();
        glm = new GridLayoutManager(getApplicationContext(), 1);
        rc.setLayoutManager(glm);
    }

    private void getStuff() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Constant.STUFF, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("response");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String id = object.getString("ID");
                        String image = object.getString("stuff_image");
                        String title = object.getString("stuff_name");
                        String price = object.getString("stuff_price");
                        f_stuff fStuff = new f_stuff(image, title, price, id);
                        stuffs.add(fStuff);
                        adapterStuffM = new AdapterStuffM(stuffs, getApplicationContext());
                        rc.setAdapter(adapterStuffM);
                        rc.getAdapter().getItemCount();
                        Log.d("anj", rc.getAdapter().getItemCount() + "");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}