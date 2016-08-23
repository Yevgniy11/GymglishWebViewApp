package com.herokuapp.gymglishwebviewapp.gymglishwebviewapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.fragments.ListFragment;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.fragments.LoginFragment;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.fragments.WebViewFragment;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.listners.OnSuccessfulLogin;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.listners.OnWebSiteChosen;

public class MainActivity extends AppCompatActivity implements OnSuccessfulLogin,OnWebSiteChosen {

    private ListFragment listFragment;
    private LoginFragment loginFrag;
    private WebViewFragment webViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loginFrag = new LoginFragment();//create the login fragment
        loginFrag.setContext(this);
        loginFrag.setOnLoginListener(this);//if the login is correct this listener will open the website list frag
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if(savedInstanceState==null)
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, loginFrag, "login").commit();//display the fragment
    }

    @Override
    public void OnSuccessfulLogin() {
        this.listFragment = new ListFragment();
        listFragment.setInflater(getLayoutInflater(),this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,listFragment,"webList").addToBackStack(null).commit();
    }

    @Override
    public void OnWebSiteChosen(String url) {
        this.webViewFragment = new WebViewFragment();
        this.webViewFragment.setUrl(url);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,this.webViewFragment,"webView").addToBackStack(null).commit();
    }

    public void OnScreenClick(View view) {
        Utills.hideKeyboard(this);
    }
}
