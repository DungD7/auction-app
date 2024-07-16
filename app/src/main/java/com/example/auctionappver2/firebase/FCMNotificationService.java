package com.example.auctionappver2.firebase;

import static com.example.auctionappver2.view.application.MyApplication.FCM_CHANNEL_ID;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Build;
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
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), FCM_CHANNEL_ID);
            builder.setSmallIcon(R.drawable.icon_bill)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            Intent intent = new Intent(getApplicationContext(), this.getClass());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("data","Some value");


            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_MUTABLE);
            builder.setContentIntent(pendingIntent);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = manager.getNotificationChannel(FCM_CHANNEL_ID);
                if (channel == null) {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    channel = new NotificationChannel(FCM_CHANNEL_ID, "some des", importance);
                    channel.setLightColor(Color.GREEN);
                    channel.enableVibration(true);
                    manager.createNotificationChannel(channel);
                }
//                channel.setDescription("Channel Description");
//                NotificationManager notificationManager = getSystemService(NotificationManager.class);
//                notificationManager.createNotificationChannel(channel);
            }
            manager.notify(0, builder.build());
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
