package com.example.auctionappver2.viewmodel;

import android.content.Context;
import android.database.Observable;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.hepper.DataLocalManager;
import com.example.auctionappver2.model.AddFavoriteProductResponse;
import com.example.auctionappver2.model.Product;
import com.example.auctionappver2.model.ResultFavoriteProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemsFavouriteViewModel extends Observable {
    Context context;
    FragmentActivity activity;

    public MutableLiveData<String> toast;
    public MutableLiveData<Boolean> showLoadingDialog;

    public MutableLiveData<List<ResultFavoriteProduct>> products;

    public ItemsFavouriteViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.toast = new MutableLiveData<>();
        this.showLoadingDialog = new MutableLiveData<>();
        this.products = new MutableLiveData<>();
        getFavoriteProducts();
    }

    public void getFavoriteProducts() {
        String tokenJwt = "Bearer " + DataLocalManager.getTokenJwtLocal();
        CoreAppInterface.coreAppInterface.getFavoriteProduct(tokenJwt).enqueue(new Callback<List<ResultFavoriteProduct>>() {
            @Override
            public void onResponse(Call<List<ResultFavoriteProduct>> call, Response<List<ResultFavoriteProduct>> response) {
                if(response.isSuccessful() &&  response.body().size() != 0) {
                    products.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ResultFavoriteProduct>> call, Throwable t) {

            }
        });
    }

    public void deleteFavoriteProduct(int idFavorite) {
        String tokenJwt = "Bearer " + DataLocalManager.getTokenJwtLocal();
        CoreAppInterface.coreAppInterface.deleteFavoriteProduct(idFavorite, tokenJwt).enqueue(new Callback<AddFavoriteProductResponse>() {
            @Override
            public void onResponse(Call<AddFavoriteProductResponse> call, Response<AddFavoriteProductResponse> response) {
                if (response.code() == 200) {
                    toast.setValue("Đã xóa tác phẩm khỏi danh sách");
                } else if (response.code() == 226){
                    toast.setValue(response.body().getDefaultMessage());
                }
            }

            @Override
            public void onFailure(Call<AddFavoriteProductResponse> call, Throwable t) {

            }
        });
    }

}
