package com.example.auctionappver2.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.hepper.DataLocalManager;
import com.example.auctionappver2.model.AddFavoriteProductResponse;
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
    public MutableLiveData<List<Product>> list1;
    public MutableLiveData<List<Product>> list2;
    public MutableLiveData<List<Product>> list3;
    public MutableLiveData<List<Product>> list4;

    public DiscoverViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.toast = new MutableLiveData<>();
        this.showLoadingDialog = new MutableLiveData<>();
        this.list1 = new MutableLiveData<>();
        this.list2 = new MutableLiveData<>();
        this.list3 = new MutableLiveData<>();
        this.list4 = new MutableLiveData<>();
        getAllCategory();
        getProductByCategory(1);
        getProductByCategory(2);
        getProductByCategory(3);
        getProductByCategory(6);
    }

    public void getAllCategory() {
        CoreAppInterface.coreAppInterface.getAllCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200 && response.body() != null) {
                        categories = response.body();
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
                if (response.isSuccessful()) {
                    if (response.code() == 201 && response.body() != null) {
                        if (categoryId == 1) {
                            list1.setValue(response.body().getContent());
                        } else if (categoryId == 2) {
                            list2.setValue(response.body().getContent());
                        } else if (categoryId == 3) {
                            list3.setValue(response.body().getContent());
                        } else if (categoryId == 6) {
                            list4.setValue(response.body().getContent());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetProductByCategoryResponse> call, Throwable t) {

            }
        });
    }

    public void addFavoriteProduct(int productId) {
        String tokenJwt = "Bearer " + DataLocalManager.getTokenJwtLocal();
        CoreAppInterface.coreAppInterface.postAddFavoriteProduct(productId, tokenJwt).enqueue(new Callback<AddFavoriteProductResponse>() {
            @Override
            public void onResponse(Call<AddFavoriteProductResponse> call, Response<AddFavoriteProductResponse> response) {
                if(response.code() == 201) {
                    toast.setValue("Đã thêm vào danh sách yêu thích");
                }
            }

            @Override
            public void onFailure(Call<AddFavoriteProductResponse> call, Throwable t) {

            }
        });
    }

    public void deleteFavoriteProduct(int idFavorite){
        String tokenJwt = DataLocalManager.getTokenJwtLocal();
    }
}
