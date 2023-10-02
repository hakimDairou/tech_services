package com.example.tech_services;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {

//    FloatingActionButton fab;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    private AppBarConfiguration appBarConfiguration;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
//        Toolbar toolbar =  findViewById(R.id.toolbar);


//        setSupportActionBar(toolbar);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar , R.string.open_nav, R.string.close_nav);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
        if (savedInstanceState == null){
           getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();

        }


// ---------------
       replaceFragment(new HomeFragment());

       bottomNavigationView.setBackground(null);
       bottomNavigationView.setOnItemSelectedListener(item -> {


           if (item.getItemId() == R.id.bottom_home){
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
           }
           else if (item.getItemId() == R.id.bottom_source){

               //1
               startActivity(new Intent(getApplicationContext(), ProjetActivity.class));
               overridePendingTransition(R.anim.slide_in, R.anim.slide_out);


//               startActivity(new Intent(Dashboard.this, ProjetActivity.class));

//               getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new LibraryFragment()).commit();
           }
           else if (item.getItemId() == R.id.bottom_notification){
               startActivity(new Intent(getApplicationContext(), ListeProjet.class));
               overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
           }
           else if (item.getItemId() == R.id.bottom_profile){

               startActivity(new Intent(getApplicationContext(), ParametreActivity.class));
               overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
           }
//
////           switch (item.getItemId()) {
////               case  R.id.bottom_home:
////                   replaceFragment(new HomeFragment());
////                   break;
////               case R.id.bottom_source:
////                   replaceFragment(new ShortsFragment());
////                   break;
////               case R.id.bottom_notification:
////                   replaceFragment(new SubscriptionFragment());
////                   break;
////               case R.id.bottom_profile:
////                   replaceFragment(new LibraryFragment());
////                   break;
////           }
////
           return true;
       });




//       navigationView.setNavigationItemSelectedListener(item -> {
//
//           if (item.getItemId() == R.id.nav_chat){
//               startActivity(new Intent(getApplicationContext(), ContactActivity.class));
//               overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//           }
//
//
//           return true;
//       });





   }

//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//
//        switch (item.getItemId()) {
//            case R.id.nav_home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
//                break;
//            case R.id.nav_settings:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new LibraryFragment()).commit();
//                break;
//
//            case R.id.nav_about:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SubscriptionFragment()).commit();
//                break;
//            case R.id.nav_logout:
//                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }


//    -------------

    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        videoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(Dashboard.this,"Upload a Video is clicked",Toast.LENGTH_SHORT).show();

            }
        });

        shortsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(Dashboard.this,"Create a short is Clicked",Toast.LENGTH_SHORT).show();

            }
        });

        liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(Dashboard.this,"Go live is Clicked",Toast.LENGTH_SHORT).show();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }




    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}