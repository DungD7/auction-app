package com.example.auctionappver2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.auctionappver2.view.fragment.auction.AuctionFragment;
import com.example.auctionappver2.view.fragment.bill.BillFragment;
import com.example.auctionappver2.view.fragment.favourite.FavouriteFragment;
import com.example.auctionappver2.view.fragment.discover.DiscoverFragment;
import com.example.auctionappver2.view.fragment.LoginFragment;
import com.example.auctionappver2.view.fragment.SignupFragment;
import com.example.auctionappver2.databinding.ActivityMainBinding;
import com.example.auctionappver2.view.fragment.personal.PersonalFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        replaceFragment(new DiscoverFragment());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setBackground(null);
        binding.fab.setOnClickListener(view -> {
            replaceFragment(new AuctionFragment());
        });

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.bottom_discover) {
                    replaceFragment(new DiscoverFragment());
                } else if(itemId == R.id.bottom_favourite) {
                    replaceFragment(new FavouriteFragment());
                } else if(itemId == R.id.bottom_bill) {
                    replaceFragment(new BillFragment());
                } else if(itemId == R.id.bottom_person) {
                    replaceFragment(new PersonalFragment());
                }
                return false;
            }
        });
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }
}