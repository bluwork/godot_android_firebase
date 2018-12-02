package org.godotengine.godot;

import android.app.Activity;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

class ModuleCloudMessaging {
    private Activity activity;
    private BackMessage backMessageListener;
    public ModuleCloudMessaging(Activity activity, BackMessage backMessageListener) {
        this.activity = activity;
        this.backMessageListener = backMessageListener;
    }


}
