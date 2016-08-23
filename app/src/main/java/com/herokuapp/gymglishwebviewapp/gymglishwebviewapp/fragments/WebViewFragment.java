package com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.R;


public class WebViewFragment extends Fragment {

    private WebView webView;
    private String url;
    ProgressDialog progressDialog ;

    public WebViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web_view, container, false);
        webView = (WebView)view.findViewById(R.id.wvWebSite);
        progressDialog = ProgressDialog.show(view.getContext(), "Please Wait", "Page Loading", true);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(android.webkit.WebView view, String url) {
                progressDialog.dismiss();
            }
        });
    }

    public void setUrl(String url) {
        this.url = "http://" + url;
    }
}
