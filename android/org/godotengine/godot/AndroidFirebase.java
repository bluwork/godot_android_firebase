package org.godotengine.godot;

import android.app.Activity;

public class AndroidFirebase extends Godot.SingletonBase {

    private Activity activity;
    private int instanceId;
    private FirebaseBroker broker;

    public AndroidFirebase(Activity pActivity) {
        registerClass("AndroidFirebase", new String[] {
                "init",
                "showAdmobInterstitial",
                "showAdmobRewardedVideo"
        });

        activity = pActivity;
        broker = new FirebaseBroker(activity);
    }

    static public Godot.SingletonBase initialize(Activity pActivity) {
        return new AndroidFirebase(pActivity);
    }

    public void init(final int pInstanceId) {
        instanceId = pInstanceId;
    }

    public void showAdmobInterstitial() {
        broker.showAdmobInterstitial();
    }

    public void showAdmobRewardedVideo() {
        broker.showAdmobRewardedVideo();
    }

    @Override
    protected void onMainPause() {
        broker.onPause();
        super.onMainPause();
    }

    @Override
    protected void onMainResume() {
        broker.onResume();
        super.onMainResume();
    }

    @Override
    protected void onMainDestroy() {
        super.onMainDestroy();
        broker.onDestroy();
    }
}