package com.example.auctionappver2.api;

import com.example.auctionappver2.model.PostRegisterAccountRequest;
import com.example.auctionappver2.model.PostRegisterAccountResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CoreAppInterface {
    @POST(APIConst.POST_REGISTER_ACCOUNT)
    Observable<PostRegisterAccountResponse> postRegisterAccount(@Body PostRegisterAccountRequest request);
}
