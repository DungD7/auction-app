package com.example.auctionappver2.viewmodel;

import android.content.Context;
import android.database.Observable;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.model.Product;

import java.util.List;

public class ItemsFavouriteViewModel extends Observable {
    Context context;
    FragmentActivity activity;

    public MutableLiveData<String> toast;
    public MutableLiveData<Boolean> showLoadingDialog;

    public MutableLiveData<List<Product>> products;

    public ItemsFavouriteViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.toast = new MutableLiveData<>();
        this.showLoadingDialog = new MutableLiveData<>();
        this.products = new MutableLiveData<>();
    }


}
