package com.example.auctionappver2.viewmodel;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.hepper.DataLocalManager;
import com.example.auctionappver2.model.CheckStatusResponse;
import com.example.auctionappver2.model.ContentAuctionSchedule;
import com.example.auctionappver2.model.GetAuctionScheduleResponse;
import com.example.auctionappver2.model.PostAddUserResponse;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuctionViewModel extends Observable {
    Context context;
    FragmentActivity activity;
    public MutableLiveData<String> toast;
    public MutableLiveData<Boolean> showLoadingDialog;

    public MutableLiveData<List<ContentAuctionSchedule>> listSchedule;

    public MutableLiveData<Boolean> isStart;


    public AuctionViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.toast = new MutableLiveData<>();
        this.showLoadingDialog = new MutableLiveData<>();
        this.listSchedule = new MutableLiveData<>();
        this.isStart = new MutableLiveData<>();
        getAuctionScheduleList();
    }

    public void getAuctionScheduleList() {
        CoreAppInterface.coreAppInterface.getAuctionSchedule(0, 100, "id").enqueue(new Callback<GetAuctionScheduleResponse>() {
            @Override
            public void onResponse(Call<GetAuctionScheduleResponse> call, Response<GetAuctionScheduleResponse> response) {
                if(response.code() == 200 && response.body().getContent().size() != 0) {
                    listSchedule.setValue(response.body().getContent());
                }
            }

            @Override
            public void onFailure(Call<GetAuctionScheduleResponse> call, Throwable t) {

            }
        });
    }

    public void addUserToAuctionRoom (int id) {
        String tokenJwt = "Bearer " + DataLocalManager.getTokenJwtLocal();
        CoreAppInterface.coreAppInterface.postAddUser(id, tokenJwt).enqueue(new Callback<PostAddUserResponse>() {
            @Override
            public void onResponse(Call<PostAddUserResponse> call, Response<PostAddUserResponse> response) {
                if (response.code() == 201) {
                    toast.setValue("Đã tham gia đấu giá");
                }
            }

            @Override
            public void onFailure(Call<PostAddUserResponse> call, Throwable t) {

            }
        });
    }


    public void getStatusSchedule(int id) {
        CoreAppInterface.coreAppInterface.getStatusSchedule(id).enqueue(new Callback<CheckStatusResponse>() {
            @Override
            public void onResponse(Call<CheckStatusResponse> call, Response<CheckStatusResponse> response) {
                if(response.isSuccessful()) {
                    if (response.body().getStatus().equals("STARTED")) {
                        isStart.setValue(true);
                    } else {
                        isStart.setValue(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckStatusResponse> call, Throwable t) {

            }
        });
    }
}
