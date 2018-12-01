package org.godotengine.godot;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CloudMessagingService extends FirebaseMessagingService {
    private final String TAG = "CloudMessagingService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO Return this message to user interface in game
        Log.d(TAG, "Message from: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size()> 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if(remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
    }
}
