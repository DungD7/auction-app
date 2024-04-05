package com.example.auctionappver2.viewmodel;

import android.content.Context;
import android.text.SpannableString;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;


import com.example.auctionappver2.R;
import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.model.PostActiveAccountResponse;
import com.example.auctionappver2.model.PostRegisterAccountResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActiveAccountViewModel {
    private String mOtp = "";
    private Context mContext;
    private String mEmail = "";
    private FragmentActivity mActivity;
    public ObservableField<SpannableString> strNoteOtp = new ObservableField<>();
    public void setmOtp(String mOtp) {
        this.mOtp = mOtp;
    }

    public OtpActiveAccountViewModel(Context context, FragmentActivity activity, String email) {
        this.mContext = context;
        this.mActivity = activity;
        this.mEmail = email;
    }

    public void onClickContinue() {
        activeAccount(mEmail, mOtp);
    }

    public void activeAccount(String email, String otp) {
        CoreAppInterface.coreAppInterface.postActiveAccount(email, otp).enqueue(new Callback<PostActiveAccountResponse>() {
            @Override
            public void onResponse(Call<PostActiveAccountResponse> call, Response<PostActiveAccountResponse> response) {

            }

            @Override
            public void onFailure(Call<PostActiveAccountResponse> call, Throwable t) {

            }
        });
    }

    public ObservableField<SpannableString> getOtpNote(TextView textView) {
        String note = mContext.getString(R.string.uiv2_tv_otp_note);
        SpannableString dv = new SpannableString(note);
//        dv.setSpan(new StyleSpan(Typeface.BOLD), note.indexOf(Utils.converPhoneToFormat(mPhoneNumber)), note.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        dv.setSpan(new ForegroundColorSpan(mContext.getColor(R.color.neural_900)), note.indexOf(Utils.converPhoneToFormat(mPhoneNumber)), note.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        strNoteOtp.set(dv);
        return strNoteOtp;
    }


}
