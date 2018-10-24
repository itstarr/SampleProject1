package com.itstarr.sampleproject.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itstarr.sampleproject.Adapter.ViewPagerAdapter1;
import com.itstarr.sampleproject.R;

import butterknife.ButterKnife;

public class HomeFragment extends android.support.v4.app.Fragment  {
    public static HomeFragment newInstance() {
        HomeFragment fragment1 = new HomeFragment();
        return fragment1;
    }


    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;


    ResturtantFragments resturtantFragments;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;

    String[] tabTitle = {"FRAGMENT1", "FRAGMENT2", "FRAGMENT3", "FRAGMENT4"};
    int[] unreadCount = {5, 0, 0, 0};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.home_layout, container, false);
        ButterKnife.bind(this, rootView);
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.text_view_toolbar);
        title.setText("Sample App");

        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(4);
        setupViewPager(viewPager);
        viewPager.setPageMargin(0);
        //Initializing the tablayout
        tabLayout = (TabLayout) rootView.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        try {
            setupTabIcons();
        } catch (Exception e) {
            e.printStackTrace();
        }


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position, false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });






        setHasOptionsMenu(true);
        return rootView;
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter1 adapter = new ViewPagerAdapter1(getChildFragmentManager());
        resturtantFragments = new ResturtantFragments();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        adapter.addFragment(resturtantFragments, "FRAGMENT1");
        adapter.addFragment(fragment2, "FRAGMENT2");
        adapter.addFragment(fragment3, "FRAGMENT3");
        adapter.addFragment(fragment4, "FRAGMENT4");
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons() {

        for (int i = 0; i < tabTitle.length; i++) {
            /*TabLayout.Tab tabitem = tabLayout.newTab();
            tabitem.setCustomView(prepareTabView(i));
            tabLayout.addTab(tabitem);*/


        }


    }
}
