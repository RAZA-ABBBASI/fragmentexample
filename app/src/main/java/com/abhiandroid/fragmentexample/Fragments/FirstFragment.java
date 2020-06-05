package com.abhiandroid.fragmentexample.Fragments;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.abhiandroid.fragmentexample.R;


public class FirstFragment extends Fragment {


    View view;
    Button firstButton,goToSecondButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first, container, false);
        // get the reference of Button
        firstButton = (Button) view.findViewById(R.id.firstButton);
        goToSecondButton = (Button) view.findViewById(R.id.gotToSecondButton);
        // perform setOnClickListener on first Button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                Toast.makeText(getActivity(), "First Fragment", Toast.LENGTH_LONG).show();
            }
        });

        goToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create fragment object

                Fragment secondFragment=new SecondFragment();
                // create a FragmentManager
                FragmentManager fm=getActivity().getSupportFragmentManager();
                // create a FragmentTransaction to begin the transaction and replace the Fragment
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                // replace the FrameLayout with new Fragment
                fragmentTransaction.replace(R.id.frameLayout, secondFragment);
                fragmentTransaction.commit(); // save the changes
            }
        });
        return view;
    }
}
