package com.itstarr.sampleproject.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import com.itstarr.sampleproject.R;

import butterknife.ButterKnife;

public class ResturtantFragments extends android.support.v4.app.Fragment  {

   // String[] ResturtantSectioned = {"Get Out Lunch or Dinner", "Get Food Delivered","Cafes","Popular Brands"};


   // String[] PopularBrands = {"KFC", "Pizza","Wok Singh","Urbanbird Cafe","Milkshake and Co.","Tikka Times"};

    //@BindView(R.id.resturtant_recycler_view)
    //RecyclerView ResturtantRecyclerView;

    WebView web;
    ProgressBar progressBar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.resturtant_layout, container, false);

        ButterKnife.bind(this, rootView);
//getList();


        web = (WebView) rootView.findViewById(R.id.webView);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar1);


        WebView web = (WebView) rootView.findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);

        final String url = "https://www.google.co.in/";


        web.loadUrl(url);


        return rootView;
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            progressBar.setVisibility(View.GONE);
        }
    }

    // To handle "Back" key press event for WebView to go back to previous screen.
    View.OnKeyListener keyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN ){
                if( web.canGoBack() ){
                    web.goBack();
                    return true;
                }
            }

            return false;
        }
    };

  /*  public void getList() {

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        ResturtantRecyclerView.setLayoutManager(mLayoutManager);
        ResturtantRecyclerView.setAdapter(new ResturtantSectionedAdapter(getContext(), ResturtantSectioned,getActivity()));

    }*/
}
