package com.example.auctionappver2.viewmodel;

import android.content.Context;

import android.os.CountDownTimer;

import android.text.SpannableString;
import android.widget.TextView;


import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.example.auctionappver2.R;

public class LoginInputOtpViewModel {
    public String mPhoneNumber = "", tinhId = "", mOtp = "";
    public long countDownResend;

    private static Context mContext;
    private static FragmentActivity mActivity;
    public static int countReSendOtp = 0, countWrongOtp = 0;
    private CountDownTimer mCountDown20s, mCountDown60s;
    private boolean mCountDown20sRunning, mCountDown60sRunning;
    public ObservableField<SpannableString> strNoteOtp = new ObservableField<>();
    public ObservableBoolean isEnableResend = new ObservableBoolean();
    public ObservableBoolean isHideResend = new ObservableBoolean();
    public ObservableField<String> strNoteResend = new ObservableField<>();
    public MutableLiveData<Boolean> goHome;
    public MutableLiveData<Boolean> showLoadingDialog;
    public MutableLiveData<String> toast;
    public MutableLiveData<Boolean> clearOtp;

    public MutableLiveData<Boolean> createPassword;
    public MutableLiveData<String> msgError;
    protected final int SMS_CONSENT_REQUEST = 2;  // Set to an unused request code

    public String getmOtp() {
        return mOtp;
    }

    public void setmOtp(String mOtp) {
        this.mOtp = mOtp;
    }

    public LoginInputOtpViewModel(Context context, FragmentActivity activity, String phoneNumber, String tinhId) {
        this.mPhoneNumber = phoneNumber;
        this.tinhId = tinhId;
        this.mContext = context;
        this.mActivity = activity;
        showLoadingDialog = new MutableLiveData<>();
        clearOtp = new MutableLiveData<>();
        goHome = new MutableLiveData<>();
        toast = new MutableLiveData<>();
        msgError = new MutableLiveData<>();
        createPassword = new MutableLiveData<>();
        resetCount();
        isHideResend.set(false);
    }

    public void resetCount() {
        countWrongOtp = 0;
        countReSendOtp = 0;
    }

    public void stopCountDown() {
        if (mCountDown20sRunning) {
            mCountDown20s.cancel();
        }

        if (mCountDown60sRunning) {
            mCountDown60s.cancel();
        }
    }

    public void processLoginMsisdnOtp(String phoneNumber, String password) {
        mPhoneNumber = phoneNumber;
//        if (mPhoneNumber.isEmpty() || password.isEmpty()) {
//            toast.postValue(mContext.getString(R.string.login_required_field1));
//        } else {
//            mPhoneNumber = CommonUtils.addCountryCode(mPhoneNumber);
//            String deviceModel = android.os.Build.MODEL;
//            FirebaseMessaging.getInstance().getToken()
//                    .addOnCompleteListener(new OnCompleteListener<String>() {
//                        @Override
//                        public void onComplete(@NonNull Task<String> task) {
////                            if (!task.isSuccessful()) {
////                                Log.w(TAG, "Fetching FCM registration token failed", task.getException());
////                                return;
////                            }
//
//                            // Get new FCM registration token
//                            String fcmKey = task.getResult() == null ? "" : task.getResult();
//                            AppVNPT.sendFcmToken(fcmKey);
//                            PostLoginMsisdn postLoginMsisdn = new PostLoginMsisdn(mPhoneNumber, password, "otp", deviceModel, fcmKey);
//                            postLoginMsisdn.setMode("otp");
////                            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
////                                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//                            showLoadingDialog.postValue(true);
//                            CoreAppHelper.postToLoginByMsisdn(postLoginMsisdn, new CoreAppHelper.OnCoreAppListener() {
//                                @Override
//                                public void onSuccess(Serializable result) {
//                                    AppVNPT.logoutResetSession();
//                                    showLoadingDialog.postValue(false);
//                                    LoginMsisdnV2 loginMsisdn = (LoginMsisdnV2) result;
//                                    toast.postValue(loginMsisdn.getMessage());
//                                    AppVNPT.isLogin = true;
//                                    AppVNPT.API_SESSION_ID = loginMsisdn.getSession();
//                                    AppVNPT.API_MSISDN = mPhoneNumber;
//                                    AppVNPT.API_MSISDN_LOGIN = mPhoneNumber;
//                                    AppVNPT.LOGIN_TYPE_MOBILE = true;
//                                    SharePref.write(Constants.LOGIN_TYPE, Constants.TYPE_OTP);
//                                    SharePref.write(Constants.LOGIN_MSISDN, mPhoneNumber);
//                                    SharePref.write(Constants.IS_LOGINED, true);
//                                    SharePref.write(Constants.PHONE_NUMBER_LOGIN, mPhoneNumber);
//                                    //uiv2 save last account login
//                                    SharePref.write(Constants.LAST_ACCOUNT_LOGIN_OTP, CommonUtils.removeCountryCode(mPhoneNumber));
//                                    SharePref.write(Constants.LOGIN_TYPE_MOBILE, true);
//                                    SharePref.write(Constants.MOBILE_TYPE_OFFNET + CommonUtils.removeCountryCode(mPhoneNumber), loginMsisdn.getOffNet());
//                                    SharePref.writeInt(Constants.MOBILE_OFFNET_BRCD_MANAGER + CommonUtils.removeCountryCode(mPhoneNumber), loginMsisdn.getBrcdManager());
////                                    if (loginMsisdn.getIsNew() != null && loginMsisdn.getIsNew().equals("1")) {
////                                        //luong moi core y/c bo di (Lamnd)
////                                        showCreatePasswordDialog(mPhoneNumber);
////                                    } else {
//                                    onMoveToDashBoard(loginMsisdn.getSession());
////                                    }
//
//                                }
//
//                                @Override
//                                public void onFail(Serializable result) {
//                                    try {
//                                        LoginMsisdnV2 loginMsisdn = (LoginMsisdnV2) result;
//                                        showLoadingDialog.postValue(false);
////                                        toast.postValue(mContext.getString(R.string.tv_system_busy));
//                                        if (loginMsisdn.getErrorCode().equalsIgnoreCase("wrong_otp")) {
//                                            countWrongOtp++;
//                                            if (countWrongOtp < 3) {
//                                                int count = 5 - countWrongOtp;
//                                                msgError.postValue(String.format(mContext.getString(R.string.uiv2_alert_otp_error), count + ""));
//                                            } else if (countWrongOtp == 3) {
////                                                //show bottom sheet ho tro
////                                                showBottomSheetSupport();
//                                                int count = 5 - countWrongOtp;
//                                                msgError.postValue(String.format(mContext.getString(R.string.uiv2_alert_otp_error), count + ""));
//                                            } else if (countWrongOtp == 4) {
//                                                int count = 5 - countWrongOtp;
//                                                msgError.postValue(String.format(mContext.getString(R.string.uiv2_alert_otp_error), count + ""));
//                                            } else if (countWrongOtp >= 5) {
//                                                msgError.postValue(mContext.getString(R.string.uiv2_alert_otp_error_full));
//                                                isHideResend.set(true);
//                                                //show bottom sheet ho tro
//                                                new CountDownTimer(2000, 1000) {
//                                                    public void onTick(long millisUntilFinished) {
//
//                                                    }
//
//                                                    public void onFinish() {
//                                                        showBottomSheetSupport();
//                                                    }
//                                                }.start();
//                                            }
//                                        } else {
//                                            msgError.postValue(loginMsisdn.getMessage());
//                                        }
//
//                                    } catch (Exception e) {
//
//                                    }
//                                }
//
//                                @Override
//                                public void onExpire(String message) {
//                                    try {
//                                        showLoadingDialog.postValue(false);
//                                        if (!TextUtils.isEmpty(message)) {
//                                            toast.postValue(message);
//                                        }
//                                    } catch (Exception e) {
//
//                                    }
//                                }
//                            });
//
//                        }
//                    });
//        }
    }

    private void onMoveToDashBoard(String session) {
//        SharePref.write(Constants.LOGIN_SESSION, session);
//        if (AppVNPT.isLogin && AppVNPT.API_SESSION_ID != "") {
//            goHome.postValue(true);
            //check update thong tin thue bao
//            BaseRequest model = new BaseRequest(AppVNPT.API_MSISDN, AppVNPT.API_SESSION_ID);
//            apiService.getUpdateInfoPopup(model).enqueue(new Callback<UpdateInfoResponse>() {
//                @Override
//                public void onResponse(Call<UpdateInfoResponse> call, Response<UpdateInfoResponse> response) {
//                    try {
//                        if (response.isSuccessful()) {
//                            if (response.body() != null) {
//                                if (!TextUtils.isEmpty(response.body().getErrorCode()) && response.body().getErrorCode().equalsIgnoreCase("0")) {
//                                    //show popup
//                                    Intent intent = new Intent(LoginOtpActivity.this, ShowUpdateMemberInfoActivity.class);
//                                    intent.putExtra(WalletReviewFragment.MOBILE_INFO, response.body().getMobileInfo());
//                                    intent.putExtra("policy_message", response.body().getMessage());
//                                    startActivity(intent);
//                                    overridePendingTransition(0, 0);
//                                    finish();
//                                } else {
//                                    goHomeCountDown();
//                                }
//                            } else {
//                                goHomeCountDown();
//                            }
//                        } else {
//                            goHomeCountDown();
//                        }
//                    } catch (Exception e) {
//                        goHomeCountDown();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<UpdateInfoResponse> call, Throwable t) {
//                    try {
//                        goHomeCountDown();
//                    } catch (Exception e) {
//
//                    }
//                }
//            });
    }

    private void showCreatePasswordDialog(String msisdn) {
        createPassword.postValue(true);
//        CreatePasswordDialog dialog = new CreatePasswordDialog(mContext, true);
//        dialog.setListener((password, otp) -> {
//            registerOffnet(msisdn, password, otp);
//        });
//        dialog.setResendOtpListener(new CreatePasswordDialog.IClickResendOtp() {
//            @Override
//            public void onClick() {
//                sendOTP(msisdn, "authen_register,payment_wallet_register", tinhId);
//            }
//        });
//        dialog.show();
    }

    //    protected final BroadcastReceiver smsVerificationReceiver1 = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
//                Bundle extras = intent.getExtras();
//                Status smsRetrieverStatus = (Status) extras.get(SmsRetriever.EXTRA_STATUS);
//
//                switch (smsRetrieverStatus.getStatusCode()) {
//                    case CommonStatusCodes.SUCCESS:
//                        // Get consent intent
//                        Intent consentIntent = extras.getParcelable(SmsRetriever.EXTRA_CONSENT_INTENT);
//                        try {
//                            // Start activity to show consent dialog to user, activity must be started in
//                            // 5 minutes, otherwise you'll receive another TIMEOUT intent
//                            mActivity.startActivityForResult(consentIntent, SMS_CONSENT_REQUEST);
//                        } catch (ActivityNotFoundException e) {
//                            // Handle the exception ...
//                        }
//                        break;
//                    case CommonStatusCodes.TIMEOUT:
//                        // Time out occurred, handle the error.
//                        break;
//                }
//            }
//        }
//    };
    public void sendOTP(String msisdn, String otpService, String tinhId) {
//        IntentFilter intentFilter1 = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
//        mActivity.registerReceiver(smsVerificationReceiver1, intentFilter1);
//        Task<Void> task = SmsRetriever.getClient(mContext).startSmsUserConsent(null /* or null */);
//        //showLoadingWithout();
//        mActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
//                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        try {
//            SendOTPModel body = new SendOTPModel(msisdn, otpService);
//            body.setTinhId(tinhId);
//
//            SendOTPPostModel model = new SendOTPPostModel();
//            model.setMsisdn(msisdn);
//            model.setOtpService(otpService);
//            showLoadingDialog.postValue(true);
//            CoreAppHelper.sendOtp(model, new CoreAppHelper.OnCoreAppListener() {
//                @Override
//                public void onSuccess(Serializable result) {
//                    showLoadingDialog.postValue(false);
//                    SendOTPResponse sendOTPResponse = (SendOTPResponse) result;
//                    toast.postValue(sendOTPResponse.getMessage());
////                    Toast.makeText(mActivity, sendOTPResponse.getMessage(), Toast.LENGTH_SHORT).show();
//                    countDownResend();
//                }
//
//                @Override
//                public void onFail(Serializable result) {
//                    try {
//                        SendOTPResponse sendOTPResponse = (SendOTPResponse) result;
//                        showLoadingDialog.postValue(false);
//                        toast.postValue(sendOTPResponse.getMessage());
//                    } catch (Exception e) {
//
//                    }
//                }
//
//                @Override
//                public void onExpire(String message) {
//                    showLoadingDialog.postValue(false);
//                    if (!TextUtils.isEmpty(message)) {
//                        toast.postValue(message);
//                    }
//                }
//            });
        } catch (Exception e) {
            toast.postValue("");
        }
    }

    public void countDownResend() {
        mCountDown60s = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                mCountDown60sRunning = true;
                countDownResend = millisUntilFinished;
                strNoteResend.set(mContext.getString(R.string.uiv2_resend_otp) + " (" + millisUntilFinished / 1000 + ")");
                isEnableResend.set(false);
//                textView.setClickable(false);
//                textView.setTextColor(mContext.getColor(R.color.neural_600));
            }

            public void onFinish() {
                mCountDown60sRunning = false;
                strNoteResend.set(mContext.getString(R.string.uiv2_resend_otp));
                isEnableResend.set(true);
                if (countWrongOtp == 3) {
                }
//                textView.setClickable(true);
//                textView.setTextColor(mContext.getColor(R.color.primary_500));

            }
        };
        mCountDown60s.start();
    }

    public void countDownSupport() {
        mCountDown20s = new CountDownTimer(20000, 1000) {
            public void onTick(long millisUntilFinished) {
                mCountDown20sRunning = true;
            }

            public void onFinish() {
                if (countWrongOtp == 0) {
                }
                mCountDown20sRunning = false;
            }
        };
        mCountDown20s.start();
    }


    @BindingAdapter({"set_enable_resend"})
    public static void setEnableResend(TextView textView, ObservableBoolean isEnableResend) {
        if (isEnableResend.get()) {
            textView.setClickable(true);
            textView.setTextColor(mContext.getColor(R.color.primary_500));
        } else {
            textView.setClickable(false);
            textView.setTextColor(mContext.getColor(R.color.neural_600));
        }
    }

    public void onClickContinue() {
//        LoginBottomSheetHelper.showSelectSupport(mContext, new LoginBottomSheetHelper.OnSelect() {
//            @Override
//            public void onSelect() {
//
//            }
//        });
        processLoginMsisdnOtp(mPhoneNumber, mOtp);
    }

    public void onClickReSendOtp() {
        if (countReSendOtp >= 4) {
            toast.postValue(mContext.getString(R.string.uiv2_alert_otp_warning));
//            new CountDownTimer(2000, 1000) {
//                public void onTick(long millisUntilFinished) {
//
//                }
//
//                public void onFinish() {
//                    showBottomSheetSupport();
//                }
//            }.start();
        } else {
            countReSendOtp++;
            clearOtp.postValue(true);
            sendOTP(mPhoneNumber, "authen_msisdn", tinhId);
        }
        new CountDownTimer(20000, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
            }
        }.start();
    }

    public ObservableField<SpannableString> getOtpNote(TextView textView) {
        String note = mContext.getString(R.string.uiv2_tv_otp_note);
        SpannableString dv = new SpannableString(note);
//        dv.setSpan(new StyleSpan(Typeface.BOLD), note.indexOf(Utils.converPhoneToFormat(mPhoneNumber)), note.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        dv.setSpan(new ForegroundColorSpan(mContext.getColor(R.color.neural_900)), note.indexOf(Utils.converPhoneToFormat(mPhoneNumber)), note.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        strNoteOtp.set(dv);
        return strNoteOtp;
    }

    public void release() {
//        mContext = null;
    }
}
