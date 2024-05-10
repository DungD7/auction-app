package com.example.auctionappver2.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.model.Category;
import com.example.auctionappver2.model.GetProductByCategoryResponse;
import com.example.auctionappver2.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoverViewModel extends BaseObservable {
    Context context;
    FragmentActivity activity;

    public MutableLiveData<String> toast;
    public MutableLiveData<Boolean> showLoadingDialog;
    List<Category> categories = new ArrayList<>();


    public DiscoverViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.toast = new MutableLiveData<>();
        this.showLoadingDialog = new MutableLiveData<>();
        getAllCategory();
        getProductByCategory(1);
        getProductByCategory(2);
        getProductByCategory(3);
    }

    public void getAllCategory() {
        CoreAppInterface.coreAppInterface.getAllCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if(response.isSuccessful()) {
                    if(response.code() == 200 && response.body() != null) {
                        categories = response.body();
                        Log.d("123321", String.valueOf(categories.size()));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }

    public void getProductByCategory(int categoryId) {
        CoreAppInterface.coreAppInterface.getProductByCategory(categoryId).enqueue(new Callback<GetProductByCategoryResponse>() {
            @Override
            public void onResponse(Call<GetProductByCategoryResponse> call, Response<GetProductByCategoryResponse> response) {
                if(response.isSuccessful()) {
                    if(response.code() == 200 && response.body() != null) {
                        Log.d("123321", String.valueOf(response.body().getContent()));
                    }
                }
            }

            @Override
            public void onFailure(Call<GetProductByCategoryResponse> call, Throwable t) {

            }
        });
    }
}
