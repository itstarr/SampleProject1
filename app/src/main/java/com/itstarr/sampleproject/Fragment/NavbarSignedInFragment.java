package com.itstarr.sampleproject.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.itstarr.sampleproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by shivam on 21/8/16.
 */
public class NavbarSignedInFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    private boolean internetConnection = false;
    private NavbarSignedInCallbacks callback;
    private TextView locationString;
    private boolean flag;
    View headerView;
//    @BindView(R.id.sign_up_button)

    SharedPreferences sharedPreferences;
    private static final String PREFRENCES_NAME = "myprefrences";
String DeviceId , AccNum;
    Fragment fragment = null;
    Class fragmentClass = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.navbar_signed_in,container,false);
        ButterKnife.bind(this,view);

        return view;


    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        headerView = navigationView.getHeaderView(0);



        Fragment newFragment = new HomeFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        callback = (NavbarSignedInCallbacks)getActivity();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {

            Fragment newFragment = new HomeFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, newFragment);
            transaction.addToBackStack(null);
            transaction.detach(newFragment);
            transaction.attach(newFragment);
            transaction.commit();

            //  fragmentClass=CheckFragment.class;
            // Handle the camera action
        }


        replaceFragment();

        callback.onItemSelected();
        return true;

    }

    private void replaceFragment() {
        if (flag == true) {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_layout, fragment).addToBackStack(null).commit();
        }
    }







    public interface NavbarSignedInCallbacks {
        void onItemSelected();
    }







}
