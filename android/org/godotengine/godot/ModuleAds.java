package org.godotengine.godot;

import android.app.Activity;
import android.util.Log;

import com.godot.game.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class ModuleAds {

    private final String TAG = "ModuleAds";

    private Activity activity;
    private InterstitialAd interstitialAd;
    private RewardedVideoAd rewardedVideoAd;

    private final String [] ADMOB_TEST_DEVICES = {
            "00DA088B59B1645A5A9595CD9A8AA382",// S2
            "E39C7CB1199974CA4DF51FE39A16372C",//S5
            "F7FBCE5D23D923370866FA470CF1C3CD",//S4 // 22nov2018
            "BAC87072B212158391B7C39A5383EBE0", //Zopo
            "10CB4524CF8896DC945E4B263EF18D10", //Lenovo
            "770E16244B81BCFFF87335A72F52B5A3", // LG G4
            "2A23D04BDC60E635336CA7ADD26C2ECD", //Lenovo mali // 22nov2018
            "5A2CF4A6B59489E1A49FF9BE0D5DAF18", // A3
            "D13D4F10C0924E55157362B48D1BFE02"  // MI 6X    // 22nov2018
    };

    public ModuleAds(Activity activity) {
        this.activity = activity;
        MobileAds.initialize(activity, activity.getString(R.string.admob_app_id));
        initializeInterstitial();
        initializeRewardVideo();
        loadAds();
    }

    private void initializeRewardVideo() {
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(activity);
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Log.d(TAG, "*** Rewarded video ad loaded.");
            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {
                    rewardedVideoAd.loadAd(activity.getString(R.string.admob_rewarded_video_ad_unit),
                            getAdRequest());
            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                Log.d(TAG, "*** Reward : " + rewardItem.getType() + " " + rewardItem.getAmount() + ".");
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int code) {

            }

            @Override
            public void onRewardedVideoCompleted() {

            }
        });
        Log.d(TAG, "*** Reward video is initialized.");
    }

    private void initializeInterstitial() {
        interstitialAd = new InterstitialAd(activity);
        interstitialAd.setAdUnitId(activity.getString(R.string.admob_interstitial_ad_unit));
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "*** Interstitial ad loaded.");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                interstitialAd.loadAd(getAdRequest());
            }

        });

        Log.i(TAG, "*** Admob Interstitial is initialized.");
    }

    private AdRequest getAdRequest() {
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        for (String deviceId: ADMOB_TEST_DEVICES) {
            builder.addTestDevice(deviceId);
        }
        return builder.build();
    }

    public void loadAds() {
        Log.i(TAG, "*** Loading Interstitial and Rewarded Video ad.");
        interstitialAd.loadAd(getAdRequest());
        rewardedVideoAd.loadAd(activity.getString(R.string.admob_rewarded_video_ad_unit),
                getAdRequest());

    }

    public void showInterstitial() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            interstitialAd.loadAd(getAdRequest());
        }
    }

    public void showRewardedVideo() {
        //TODO Need to create handler - timer which will check every time period is video loaded
        // UI must not show reward video button if video is not loaded - bad user experience
        if (rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.show();
        } else {
            rewardedVideoAd.loadAd(activity.getString(R.string.admob_rewarded_video_ad_unit),
                    getAdRequest());
        }
    }

    public void onPause() {
        rewardedVideoAd.pause(activity);
    }

    public void onResume() {
        rewardedVideoAd.resume(activity);
    }

    public void onDestroy() {
        rewardedVideoAd.destroy(activity);
    }
}
