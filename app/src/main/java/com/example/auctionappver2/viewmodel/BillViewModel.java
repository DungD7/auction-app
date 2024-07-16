package com.example.auctionappver2.viewmodel;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.hepper.DataLocalManager;
import com.example.auctionappver2.model.BillResponse;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillViewModel extends Observable {
    Context context;
    FragmentActivity activity;
    public MutableLiveData<List<BillResponse>> billResponses;

    public BillViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.billResponses = new MutableLiveData<>();
        getListBill();

    }

    public void getListBill() {
        String tokenJwt = "Bearer " + DataLocalManager.getTokenJwtLocal();
        CoreAppInterface.coreAppInterface.getBillAuction(tokenJwt).enqueue(new Callback<List<BillResponse>>() {
            @Override
            public void onResponse(Call<List<BillResponse>> call, Response<List<BillResponse>> response) {
                if(response.code() == 201 && response.body().size() != 0) {
                    billResponses.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<BillResponse>> call, Throwable t) {

            }
        });
    }
}
