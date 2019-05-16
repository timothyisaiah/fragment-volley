package com.example.exam;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class fragment3 extends Fragment {

    Button button;
    Button button2;
    TextView textView;

    String server_url="http://www.google.com";



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3,container,false);

        button=view.findViewById(R.id.btn);
        textView=view.findViewById(R.id.txt);
        button2=view.findViewById(R.id.btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "this connects volley", Toast.LENGTH_SHORT).show();
               //creating a request Queue
                final RequestQueue requestQueue= Volley.newRequestQueue(getActivity().getApplicationContext());

                //specify request to string,add method post or get,the url and 2 responses with eror and without
                StringRequest stringRequest=new StringRequest(Request.Method.GET, server_url,

                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                //message from the server
                                textView.setText(response.substring(0,400));
                                requestQueue.stop();

                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //if something goes wrong
                                textView.setText("Something went wrong");
                                error.printStackTrace();
                                requestQueue.stop();

                            }
                        }

                );

                requestQueue.add(stringRequest);


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                fragment4 fragment4 = new fragment4();
                transaction.replace(R.id.fragment_container, fragment4);
                transaction.commit();
            }
        });



        return view;

    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}



