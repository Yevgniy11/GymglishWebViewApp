package com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.R;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.listners.OnWebSiteChosen;

import java.util.ArrayList;
import java.util.List;

/**
 * by yevgniy shvartsman on 10/08/2016.
 */
public class WebSiteAdapter extends BaseAdapter implements View.OnClickListener {
    private List<String> websites;
    private LayoutInflater inflater;
    private TextView tvWebsite;
    private OnWebSiteChosen siteChosen;
    private String[] webList= {"www.GymGlish.com","www.DelavigneCorp.com","www.WorkSweetWork.com",
            "www.Frantastique.com","www.Anglais-Conjugaison.com","www.TheWordOfTheMonth.com",
            "www.RichMorning.com","www.Vatefaireconjuguer.com"};

    public WebSiteAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        buildList();
    }

    @Override
    public int getCount() {
        return websites.size();
    }

    @Override
    public Object getItem(int i) {
        return websites.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View websiteView = inflater.inflate(R.layout.website_item,viewGroup,false);
        String website  = websites.get(position);
        tvWebsite = (TextView) websiteView.findViewById(R.id.tvWebsite);
        tvWebsite.setText(website);
        websiteView.setOnClickListener(this);//set the onClick listener for the websites
        return websiteView;
    }

    public void setOnWebsiteChosen(OnWebSiteChosen websiteChosen)
    {
        this.siteChosen = websiteChosen;
    }

    @Override
    public void onClick(View view) {
        String website = ((TextView) view.findViewById(R.id.tvWebsite)).getText().toString();
        siteChosen.OnWebSiteChosen(website);
    }

    private void buildList()//build the website list from the const string list
    {
        websites = new ArrayList<>();
        for (String str :
                webList) {
            websites.add(str);
        }
    }
}
