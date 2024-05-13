package com.example.auctionappver2.api;

import com.example.auctionappver2.model.AddFavoriteProductResponse;
import com.example.auctionappver2.model.Category;
import com.example.auctionappver2.model.GetProductByCategoryResponse;
import com.example.auctionappver2.model.LoginRequest;
import com.example.auctionappver2.model.LoginResponse;
import com.example.auctionappver2.model.PostActiveAccountResponse;
import com.example.auctionappver2.model.PostRegisterAccountRequest;
import com.example.auctionappver2.model.PostRegisterAccountResponse;
import com.example.auctionappver2.model.SearchProductResponse;
import com.example.auctionappver2.model.SendNewOtpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CoreAppInterface {
    @POST(APIConst.POST_REGISTER_ACCOUNT)
    Observable<PostRegisterAccountResponse> postRegisterAccount(@Body PostRegisterAccountRequest request);

    @POST(APIConst.POST_REGISTER_ACCOUNT)
    Call<PostRegisterAccountResponse> postRegisterAccount1(@Body PostRegisterAccountRequest request);

    @POST(APIConst.POST_ACTIVE_ACCOUNT)
    Call<PostActiveAccountResponse> postActiveAccount(@Query("email") String email,
                                                      @Query("key") String key);

    @POST(APIConst.POST_RESEND_OTP)
    Call<SendNewOtpResponse> postResendOtp(@Query("email") String email);

    @POST(APIConst.POST_LOGIN)
    Call<LoginResponse> postLogin(@Body LoginRequest request);

    @GET(APIConst.GET_SEARCH_PRODUCT)
    Call<SearchProductResponse> getSearchProduct(@Query("search") String search,
                                                 @Query("page") int page,
                                                 @Query("size") int size,
                                                 @Query("sort") String sort);

    @POST(APIConst.POST_FORGOT_PASSWORD)
    Call<String> postForgotPassword(@Query("email") String email);

    @GET(APIConst.GET_ALL_CATEGORY)
    Call<List<Category>> getAllCategory();

    @GET(APIConst.GET_PRODUCT_BY_CATEGORY)
    Call<GetProductByCategoryResponse> getProductByCategory(@Query("categoryId") int categoryId);

    @POST(APIConst.ADD_FAVORITE_PRODUCT)
    Call<AddFavoriteProductResponse> postAddFavoriteProduct(@Query("idFavorite") int idFavorite, @Header("tokenJwt") String tokenJwt);


    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    CoreAppInterface coreAppInterface = new Retrofit.Builder()
            .baseUrl(APIConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CoreAppInterface.class);
}
