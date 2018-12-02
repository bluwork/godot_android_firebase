package org.godotengine.godot;

import android.app.Activity;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class ModuleAnalytics {

    private Activity activity;
    private FirebaseAnalytics analytics;
    private BackMessage backMessageListener;

    public ModuleAnalytics(Activity activity, BackMessage backMessageListener) {
        this.activity = activity;
        this.backMessageListener = backMessageListener;
        analytics = FirebaseAnalytics.getInstance(activity);

    }

    public void setCurrentScreen(String screenName) {
        analytics.setCurrentScreen(activity, screenName, null);
    }

    public void logEarnVirtualCurrency(String name, int value) {
        Bundle vcBundle = new Bundle();
        vcBundle.putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, name );
        vcBundle.putInt(FirebaseAnalytics.Param.VALUE, value);
        analytics.logEvent(FirebaseAnalytics.Event.EARN_VIRTUAL_CURRENCY, vcBundle);
    }

    public void logUnlockAchievement(String achievementId) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ACHIEVEMENT_ID, achievementId);
        analytics.logEvent(FirebaseAnalytics.Event.UNLOCK_ACHIEVEMENT, bundle);
    }

    public void logPostScore(int score) {
        Bundle b = new Bundle();
        b.putLong(FirebaseAnalytics.Param.SCORE, score);
        analytics.logEvent(FirebaseAnalytics.Event.POST_SCORE, b);
    }

    public void logSpendVirtualCurrency(String item, String name, int value) {
        Bundle b = new Bundle();
        b.putString(FirebaseAnalytics.Param.ITEM_NAME, item);
        b.putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, name);
        b.putInt(FirebaseAnalytics.Param.VALUE, value);
        analytics.logEvent(FirebaseAnalytics.Event.SPEND_VIRTUAL_CURRENCY, b);
    }

    public void logTutorialBegin() {
        analytics.logEvent(FirebaseAnalytics.Event.TUTORIAL_BEGIN, null);
    }

    public void logTutorialComplete() {
        analytics.logEvent(FirebaseAnalytics.Event.TUTORIAL_COMPLETE, null);

    }

    public void logLevelUp(String character, int level) {
        Bundle b = new Bundle();
        b.putString(FirebaseAnalytics.Param.CHARACTER, character);
        b.putInt(FirebaseAnalytics.Param.LEVEL, level);
        analytics.logEvent(FirebaseAnalytics.Event.LEVEL_UP, b);
    }

    public void logSelectContent(String contentType, String itemId) {
        Bundle b = new Bundle();
        b.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType);
        b.putString(FirebaseAnalytics.Param.ITEM_ID, itemId);
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, b);
    }

    public void logJoinGroup(String groupId) {
        Bundle b = new Bundle();
        b.putString(FirebaseAnalytics.Param.GROUP_ID, groupId);
        analytics.logEvent(FirebaseAnalytics.Event.JOIN_GROUP, b);
    }

}
