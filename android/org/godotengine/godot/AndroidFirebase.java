package org.godotengine.godot;

import android.app.Activity;

public class AndroidFirebase extends Godot.SingletonBase {

    private Activity activity;
    private int instanceId;
    private FirebaseBroker broker;

    public AndroidFirebase(Activity pActivity) {
        registerClass("AndroidFirebase", new String[] {
                "init",
                /* Admob Ads */
                "showAdmobInterstitial",
                "showAdmobRewardedVideo",
                /* Analytics */
                "setCurrentScreen",
                "logEarnVirtualCurrency",
                "logSpendVirtualCurrency",
                "logUnlockAchievement",
                "logPostScore",
                "logTutorialBegin",
                "logTutorialComplete",
                "logLevelUp",
                "logSelectContent",
                "logJoinGroup"
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

    public void setCurrentScreen(String screenName) {
        broker.setCurrentScreen(screenName);
    }
    public void logEarnVirtualCurrency(String name, int value) {
        broker.logEarnVirtualCurrency(name, value);
    }
    public void logSpendVirtualCurrency(String item, String name, int value) {
        broker.logSpendVirtualCurrency(item, name, value);
    }
    public void logUnlockAchievement(String achievementId) {
        broker.logUnlockAchievement(achievementId);
    }
    public void logPostScore(int score) {
        broker.logPostScore(score);
    }
    public void logTutorialBegin() {
        broker.logTutorialBegin();
    }
    public void logTutorialComplete() {
        broker.logTutorialComplete();
    }
    public void logLevelUp(String character, int level) {
        broker.logLevelUp(character, level);
    }
    public void logSelectContent(String contentType, String itemId) {
        broker.logSelectContent(contentType, itemId);
    }
    public void logJoinGroup(String groupId) {
        broker.logJoinGroup(groupId);
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