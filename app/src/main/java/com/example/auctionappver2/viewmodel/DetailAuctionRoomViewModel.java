package com.example.auctionappver2.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.hepper.DataLocalManager;
import com.example.auctionappver2.model.CurrentPriceResponse;
import com.example.auctionappver2.model.PostAddUserResponse;
import com.example.auctionappver2.model.PostAuctionResponse;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailAuctionRoomViewModel extends Observable {
    Context context;
    FragmentActivity activity;

    public MutableLiveData<String> toast;
    public MutableLiveData<Boolean> showLoadingDialog;

    public MutableLiveData<Double> currentPrice;

    public DetailAuctionRoomViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.toast = new MutableLiveData<>();
        this.showLoadingDialog = new MutableLiveData<>();
        this.currentPrice = new MutableLiveData<>();
    }

    public void currentPrice(int id) {
        String tokenJwt = "Bearer " + DataLocalManager.getTokenJwtLocal();
        CoreAppInterface.coreAppInterface.postCurrentPrice(id, tokenJwt).enqueue(new Callback<CurrentPriceResponse>() {
            @Override
            public void onResponse(Call<CurrentPriceResponse> call, Response<CurrentPriceResponse> response) {
                if (response.code() == 201) {
                    currentPrice.setValue(response.body().getCurrentPrice());
                }
            }

            @Override
            public void onFailure(Call<CurrentPriceResponse> call, Throwable t) {

            }
        });
    }

    public void onClickAuction(int id, double price) {
        String tokenJwt = "Bearer " + DataLocalManager.getTokenJwtLocal();
        CoreAppInterface.coreAppInterface.postAuction(id, price, tokenJwt).enqueue(new Callback<PostAuctionResponse>() {
            @Override
            public void onResponse(Call<PostAuctionResponse> call, Response<PostAuctionResponse> response) {
                if (response.code() == 201) {
                    toast.setValue("Đấu giá thành công");
                    currentPrice(id);
                } else if (response.code() == 226) {
                    toast.setValue(response.body().getDefaultMessage());
                    currentPrice(id);
                }
            }

            @Override
            public void onFailure(Call<PostAuctionResponse> call, Throwable t) {

            }
        });
    }

    public void reSetPrice(int id) {
        Timer timer = new Timer();

        // Định nghĩa nhiệm vụ cần thực hiện
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                currentPrice(id);
            }
        };

        // Lên lịch nhiệm vụ, bắt đầu sau 0 giây và lặp lại mỗi 5 giây
        timer.scheduleAtFixedRate(task, 0, 3000);

    }

}
