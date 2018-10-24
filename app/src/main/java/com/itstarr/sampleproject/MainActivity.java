package com.itstarr.sampleproject;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itstarr.sampleproject.Fragment.NavbarSignedInFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        NavbarSignedInFragment.NavbarSignedInCallbacks {

@BindView(R.id.main_layout)
RelativeLayout mainLayout;
public DrawerLayout drawer;
        NavbarSignedInFragment fragment = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        ButterKnife.bind(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.text_view_toolbar);
        //title.setText("WeeCare");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
@Override
public void onDrawerSlide(View drawerView, float slideOffset) {
        super.onDrawerSlide(drawerView, slideOffset);
        mainLayout.setTranslationX(slideOffset * drawerView.getWidth());
        drawer.bringChildToFront(drawerView);
        drawer.requestLayout();
        }


        };
        // userDetail();
        toggle.setDrawerIndicatorEnabled(false);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.mipmap.menu1, this.getTheme());

        toggle.setHomeAsUpIndicator(drawable);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        if (drawer.isDrawerVisible(GravityCompat.START)) {
        drawer.closeDrawer(GravityCompat.START);
        } else {
        drawer.openDrawer(GravityCompat.START);
        }
        }
        });

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        ButterKnife.bind(this);
        setUpDrawer();
        }


@Override
protected void onResume() {
        super.onResume();

        // register connection status listener




        }




public void setUpDrawer() {

        fragment = new NavbarSignedInFragment();
        showDrawerFragment(fragment);

        }

@Override
public void onItemSelected() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        }
public void showDrawerFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment,fragment).commit();
        }


@Override
public void onBackPressed() {
        //super.onBackPressed();
        //finish();

        }

        }
