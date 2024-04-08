package com.example.auctionappver2.api;

import com.example.auctionappver2.model.LoginRequest;
import com.example.auctionappver2.model.LoginResponse;
import com.example.auctionappver2.model.PostActiveAccountResponse;
import com.example.auctionappver2.model.PostRegisterAccountRequest;
import com.example.auctionappver2.model.PostRegisterAccountResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CoreAppInterface {
    @POST(APIConst.POST_REGISTER_ACCOUNT)
    Observable<PostRegisterAccountResponse> postRegisterAccount(@Body PostRegisterAccountRequest request);

    @POST(APIConst.POST_REGISTER_ACCOUNT)
    Call<PostRegisterAccountResponse> postRegisterAccount1(@Body PostRegisterAccountRequest request);

    @POST(APIConst.POST_ACTIVE_ACCOUNT)
    Call<PostActiveAccountResponse> postActiveAccount(@Query("email") String email,
                                                      @Query("key")String key);
    @POST(APIConst.POST_RESEND_OTP)
    Call<Response> postResendOtp(@Query("email") String email);

    @POST(APIConst.POST_LOGIN)
    Call<LoginResponse> postLogin(@Body LoginRequest request);
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    CoreAppInterface coreAppInterface = new Retrofit.Builder()
            .baseUrl(APIConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CoreAppInterface.class);
}
