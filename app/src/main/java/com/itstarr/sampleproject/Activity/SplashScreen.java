package com.itstarr.sampleproject.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewSwitcher;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.itstarr.sampleproject.MainActivity;
import com.itstarr.sampleproject.R;

import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String PREFRENCES_NAME = "myprefrences";
    Bitmap bitmap;
    private static final int REQUEST_WRITE_PERMISSION = 786;

    ViewSwitcher viewSwitcher;
    FirebaseAnalytics firebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

//

        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {

                SharedPreferences settings = getSharedPreferences(PREFRENCES_NAME, Context.MODE_PRIVATE);
                if (settings.contains("token") ) {


                    startMain();

                }
                else{


                    startMain();


                }

            }
        }, 5*1000); // wait f
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
//        SharedPreferences settings = getSharedPreferences(PREFRENCES_NAME, Context.MODE_PRIVATE);
//        if (settings.contains("token") ) {
//
//            if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
//                buildAlertMessageNoGps();
//
//            }
//            else {
//               // startMain();
//            }
//        }
//        else{
//            if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
//                buildAlertMessageNoGps();
//
//            }
//            else {
//               // FirstTime();
//
//            }
//        }
//
//    }




    private void startMain(){

        Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
        SplashScreen.this.startActivity(mainIntent);
        SplashScreen.this.finish();
        overridePendingTransition(R.anim.right_in, R.anim.left_out);

    }

  /*  private void FirstTime(){


        Intent mainIntent = new Intent(SplashScreen.this, LoginActivity.class);
        SplashScreen.this.startActivity(mainIntent);
        SplashScreen.this.finish();
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }*/



}
