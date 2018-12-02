package org.godotengine.godot;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.godot.game.BuildConfig;
import com.godot.game.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

class ModuleRemoteConfig {

    private final String TAG = "RemoteConfig";

    private Activity activity;
    private FirebaseRemoteConfig firebaseRemoteConfig;
    private BackMessage backMessageListener;

    public ModuleRemoteConfig(Activity activity, BackMessage backMessageListener) {
        this.activity = activity;
        this.backMessageListener = backMessageListener;
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings settings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        firebaseRemoteConfig.setConfigSettings(settings);
        firebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);
        firebaseRemoteConfig.fetch().addOnCompleteListener(activity, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d(TAG, "Fetch successful.");
                firebaseRemoteConfig.activateFetched();
            }
        });
    }

    public String getRemoteValue(String key) {
        return firebaseRemoteConfig.getValue(key).asString();
    }

}
