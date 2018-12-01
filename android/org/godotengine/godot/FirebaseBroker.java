package org.godotengine.godot;

import android.app.Activity;

public class FirebaseBroker {
    private Activity activity;
    private ModuleAds moduleAds;
    private ModuleCloudMessaging moduleCloudMessaging;
    private ModuleRemoteConfig moduleRemoteConfig;
    private ModuleRealtimeDatabase moduleRealtimeDatabase;

    public FirebaseBroker(final Activity activity) {
        this.activity = activity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAds = new ModuleAds(activity);
                moduleCloudMessaging = new ModuleCloudMessaging(activity);
                moduleRemoteConfig = new ModuleRemoteConfig(activity);
                moduleRealtimeDatabase = new ModuleRealtimeDatabase(activity);
            }
        });

    }

    public void showAdmobInterstitial() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAds.showInterstitial();
            }
        });
    }

    public void showAdmobRewardedVideo() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAds.showRewardedVideo();
            }
        });
    }

    public void onPause() {
        moduleAds.onPause();

    }

    public void onResume() {
        moduleAds.onResume();
    }

    public void onDestroy() {
        moduleAds.onDestroy();
    }
}