package com.example.auctionappver2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;


import com.example.auctionappver2.view.fragment.FavouriteFragment;
import com.example.auctionappver2.view.fragment.DiscoverFragment;
import com.example.auctionappver2.view.fragment.LoginFragment;
import com.example.auctionappver2.view.fragment.SignupFragment;
import com.example.auctionappver2.databinding.ActivityMainBinding;
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
        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.bottom_search) {
                    replaceFragment(new DiscoverFragment());
                } else if(itemId == R.id.bottom_favourite) {
                    replaceFragment(new FavouriteFragment());
                } else if(itemId == R.id.bottom_bill) {
                    replaceFragment(new LoginFragment());
                } else if(itemId == R.id.bottom_person) {
                    replaceFragment(new SignupFragment());
                }
                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }
}