package com.example.auctionappver2.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.model.Product;
import com.example.auctionappver2.model.SearchProductResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchUtilitiesViewModel extends BaseObservable {
    private Context mContext;
    private FragmentActivity mActivity;
    public MutableLiveData<List<Product>> products;
    public MutableLiveData<Boolean> showLoadingDialog;
    public MutableLiveData<String> toast;

    public SearchUtilitiesViewModel(Context mContext, FragmentActivity mActivity) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.showLoadingDialog = new MutableLiveData<>();
        this.toast = new MutableLiveData<>();
        this.products = new MutableLiveData<>();
    }

    public void searchItem(String text) {
        CoreAppInterface.coreAppInterface.getSearchProduct(text, 0, 100, "id").enqueue(new Callback<SearchProductResponse>() {
            @Override
            public void onResponse(Call<SearchProductResponse> call, Response<SearchProductResponse> response) {
                if (response.isSuccessful() && response.body().getContent().size() > 0) {
                    products.setValue(response.body().getContent());
                }
            }

            @Override
            public void onFailure(Call<SearchProductResponse> call, Throwable t) {

            }
        });
    }
}
