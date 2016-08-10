package com.herokuapp.gymglishwebviewapp.gymglishwebviewapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.fragments.ListFragment;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.fragments.LoginFragment;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.listners.OnSuccessfulLogin;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.listners.OnWebSiteChosen;

public class MainActivity extends AppCompatActivity implements OnSuccessfulLogin,OnWebSiteChosen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment loginFrag = new LoginFragment();//create the login fragment
        loginFrag.setContext(this);
        loginFrag.setOnLoginListener(this);//if the login is correct this listener will open the website list frag
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, loginFrag, null).commit();//display the fragment
    }

    @Override
    public void OnSuccessfulLogin() {
        ListFragment fragment = new ListFragment();
        fragment.setInflater(getLayoutInflater(),this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack("login").commit();
    }

    @Override
    public void OnWebSiteChosen(String url) {
        Uri uri = Uri.parse("http://" + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void OnScreenClick(View view) {
        Utills.hideKeyboard(this);
    }
}
