package com.example.programmer.androidcustomization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.programmer.androidcustomization.adapter.RecyclerAdapter;
import com.example.programmer.androidcustomization.model.Contact;
import com.example.programmer.androidcustomization.singleton.MySingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private String url = "http://localhost/firstApi.php";
    public RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("eeeee");

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        getInformation();
    }

    private void getInformation (){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {

                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();


                        List<Contact> list  = Arrays.asList(gson.fromJson(response, Contact[].class));
                        adapter = new RecyclerAdapter(list);
                        recyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        MySingleton.getmInstance(this).addToRequestQueue(stringRequest);


    }
}
