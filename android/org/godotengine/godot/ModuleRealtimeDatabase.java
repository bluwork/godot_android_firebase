package org.godotengine.godot;

import android.app.Activity;

class ModuleRealtimeDatabase {

    private Activity activity;
    private BackMessage backMessageListener;

    public ModuleRealtimeDatabase(Activity activity, BackMessage backMessageListener) {
        this.activity = activity;
        this.backMessageListener = backMessageListener;
    }
}
