package com.cookandroid.a6_6;

import static com.cookandroid.a6_6.R.drawable.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener
{
    ActionBar.Tab tabdog, tabcat, tabrabbit, tabhorse;
    MyTabFragment mytfim[] = new MyTabFragment[4];
    ImageView im1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setTitle("연습문제6-7");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(ic_launcher);

        ActionBar abar = getSupportActionBar();
        abar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabdog = abar.newTab();
        tabdog.setIcon(icon_dog);
        tabdog.setTabListener(this);
        abar.addTab(tabdog);

        tabcat = abar.newTab();
        tabcat.setIcon(icon_cat);
        tabcat.setTabListener(this);
        abar.addTab(tabcat);

        tabrabbit = abar.newTab();
        tabrabbit.setIcon(icon_rabbit);
        tabrabbit.setTabListener(this);
        abar.addTab(tabrabbit);

        tabhorse = abar.newTab();
        tabhorse.setIcon(icon_horse);
        tabhorse.setTabListener(this);
        abar.addTab(tabhorse);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment mytfimp1 = null;

        if(mytfim[tab.getPosition()] == null){
            mytfimp1 = new MyTabFragment();
            Bundle dt = new Bundle();
            dt.putInt("tv", tab.getPosition());
            mytfimp1.setArguments(dt);
            mytfim[tab.getPosition()] = mytfimp1;
        }
        else
            mytfimp1 = mytfim[tab.getPosition()];

        ft.replace(android.R.id.content, mytfimp1);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
    //
    public static class MyTabFragment extends androidx.fragment.app.Fragment{
        int tv;
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tv = data.getInt("tv");
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            /*LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout bl1 = new LinearLayout(super.getActivity());
            bl1.setOrientation(LinearLayout.VERTICAL);
            bl1.setLayoutParams(p1);*/

            View mv = inflater.inflate(R.layout.activity_main,null);
            ImageView im1 = new ImageView(super.getActivity());
            LinearLayout.LayoutParams imp1 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            im1.setLayoutParams(imp1);
            im1.setPadding(300,300,300,300);
            mv = im1;

            if(tv == 0) im1.setImageResource(dog);
            if(tv == 1) im1.setImageResource(cat);
            if(tv == 2) im1.setImageResource(rabbit);
            if(tv == 3) im1.setImageResource(horse);

            return mv;
        }
    }
}