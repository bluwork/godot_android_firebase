package org.godotengine.godot;

import android.app.Activity;

public class FirebaseBroker {
    private Activity activity;
    private ModuleAds moduleAds;
    private ModuleCloudMessaging moduleCloudMessaging;
    private ModuleRemoteConfig moduleRemoteConfig;
    private ModuleRealtimeDatabase moduleRealtimeDatabase;
    private ModuleAnalytics moduleAnalytics;

    public FirebaseBroker(final Activity activity) {
        this.activity = activity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAds = new ModuleAds(activity);
                moduleCloudMessaging = new ModuleCloudMessaging(activity);
                moduleRemoteConfig = new ModuleRemoteConfig(activity);
                moduleRealtimeDatabase = new ModuleRealtimeDatabase(activity);
                moduleAnalytics = new ModuleAnalytics(activity);
            }
        });

    }
    /*          Admob Ads           */
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

    /*          App Lifecycle Methods - Called from UI thread           */
    /*          No need of guarding with activity.runOnUIThread()       */

    public void onPause() {
        moduleAds.onPause();

    }

    public void onResume() {
        moduleAds.onResume();
    }

    public void onDestroy() {
        moduleAds.onDestroy();
    }

    /*          Analytics           */

    public void setCurrentScreen(final String screenName) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.setCurrentScreen(screenName);
            }
        });
    }

    public void logEarnVirtualCurrency(final String name, final int value) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logEarnVirtualCurrency(name, value);
            }
        });
    }

    public void logSpendVirtualCurrency(final String item, final String name, final int value) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logSpendVirtualCurrency(item, name, value);
            }
        });
    }

    public void logUnlockAchievement(final String achievementId) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logUnlockAchievement(achievementId);
            }
        });
    }

    public void logPostScore(final int score) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logPostScore(score);
            }
        });
    }

    public void logTutorialBegin() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logTutorialBegin();
            }
        });
    }

    public void logTutorialComplete() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logTutorialComplete();
            }
        });
    }

    public void logLevelUp(final String character, final int level) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logLevelUp(character, level);
            }
        });
    }

    public void logSelectContent(final String contentType, final String itemId) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logSelectContent(contentType, itemId);
            }
        });
    }

    public void logJoinGroup(final String groupId) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                moduleAnalytics.logJoinGroup(groupId);
            }
        });
    }
}