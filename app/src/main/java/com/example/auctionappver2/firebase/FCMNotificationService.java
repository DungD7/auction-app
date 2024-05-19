package com.example.auctionappver2.firebase;

import static com.example.auctionappver2.view.application.MyApplication.FCM_CHANNEL_ID;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.nfc.Tag;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.auctionappver2.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class FCMNotificationService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        // handle a notification payload.
        Log.d(TAG, "Message onMessageReceived : call");
        Log.d(TAG, "Message onMessageReceived from:" + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {

            String title = remoteMessage.getNotification().getTitle();
            String body = remoteMessage.getNotification().getBody();

            Log.d(TAG, body);
            Notification notification = new NotificationCompat.Builder(this, FCM_CHANNEL_ID)
                    .setSmallIcon(R.drawable.icon_bill)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setColor(Color.BLUE)
                    .build();

            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(1002, notification);
        }

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "onMessageReceived: Data" + remoteMessage.getData().toString());
            Map<String, String> map1 = remoteMessage.getData();

        }
    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
    }


}
