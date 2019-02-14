package com.example.peticiones;

import android.app.Person;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1_recibir).setOnClickListener(this);

        texto = findViewById(R.id.lb1_nombre);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1_recibir:
                final JsonObjectRequest tex;
                tex = new JsonObjectRequest(Request.Method.GET, "http://nuevo.rnrsiilge-org.mx/principal",
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson g = new Gson();
                        Persona persona;
                        persona = g.fromJson(response.toString(),Persona.class);
                        Log.d("valor",response.toString());
                        texto.setText(persona.getNombre());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("Error",error.getMessage());
                    }
                });
                Volleys.getInstance(this).getmRequestQueue().add(tex);
                break;
        }

    }
}
