package com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.R;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.Utills;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.listners.OnSuccessfulLogin;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private Activity activity;
    private Button btnLogin;
    private String login;
    private String pass;
    private OnSuccessfulLogin loginListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    public void setContext(Activity activity)
    {
       this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        //check the login credentials
        View rel  = ((RelativeLayout)view.getParent());
        login = ((EditText)rel.findViewById(R.id.etLogin)).getText().toString();
        pass = ((EditText)rel.findViewById(R.id.etPass)).getText().toString();

        if(!Utills.checkNullOrEmpty(login,pass)) {
            if (login.equals("gymglish") && pass.equals("gymglish")) {
                loginListener.OnSuccessfulLogin();
            } else
                Toast.makeText(activity, "The pass ot the login are incorrect, try again please.", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(activity, "The pass ot the login are empty, try again please.", Toast.LENGTH_LONG).show();
    }

    public void setOnLoginListener(OnSuccessfulLogin listener)
    {
        this.loginListener = listener;
    }
}
