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
import android.widget.EditText;

public class fragment2 extends Fragment {
    Button next;
    EditText Fname,Lname,Pnumber;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2,container,false);
        next=view.findViewById(R.id.fragnext);
        Fname=view.findViewById(R.id.fname);
        Lname=view.findViewById(R.id.lname);
        Pnumber=view.findViewById(R.id.pnumber);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname=Fname.getText().toString().trim();
                String lname=Lname.getText().toString().trim();
                String pnumber=Pnumber.getText().toString().trim();

                if(fname.isEmpty()){

                    Fname.setError("Please enter valid name");
                }else
                if( lname.isEmpty()) {
                    Lname.setError("[Please enter valid last name");


                }else
                if(pnumber.isEmpty()){

                    Pnumber.setError("Please enter phone number");

                }else {

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    fragment3 fragment3 = new fragment3();
                    transaction.replace(R.id.fragment_container, fragment3);
                    transaction.commit();
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
