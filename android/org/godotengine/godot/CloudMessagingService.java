package org.godotengine.godot;

import android.app.Service;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CloudMessagingService extends FirebaseMessagingService {

    private final String TAG = "CloudMessagingService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO Return this message to user interface in game
        Log.d(TAG, "Message from: " + remoteMessage.getFrom());
        // TODO How to get script instance id to this service
        backMessage("firebase_message", "from" , remoteMessage.getFrom());

        if (remoteMessage.getData().size()> 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            backMessage("firebase_message", "data_payload", remoteMessage.getData().toString());
        }

        if(remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            backMessage("firebase_message", "body", remoteMessage.getNotification().getBody());
        }
    }

    private void backMessage(String tag, String who, String what) {
        int instanceId = getSharedPreferences("firebase", Service.MODE_PRIVATE).getInt("firebase_inst_id", 0);
        GodotLib.calldeferred(instanceId, "from_android", new Object[] {tag, who, what});
    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
    }
}
