package com.bingo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Method;

import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformViewsController;

public class StandFlutterActivity extends FlutterActivity {

    private FlutterEngine flutterEngine;

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    @Override
    public boolean shouldDestroyEngineWithHost() {
        return true;
    }

    @Nullable
    @Override
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        if (flutterEngine == null) {
            flutterEngine = new FlutterEngine(context, new StandFlutterLoader(), null, new PlatformViewsController(), null, false, true);
            registerGeneratedPlugins(flutterEngine);
        }
        return flutterEngine;
    }

    @NonNull
    @Override
    public String getAppBundlePath() {
        return "flutter_assets2";
    }

    public static void registerGeneratedPlugins(@NonNull FlutterEngine flutterEngine) {
        final String TAG = "GeneratedPluginsRegister2";
        try {
            Class<?> generatedPluginRegistrant =
                    Class.forName("io.flutter.plugins.GeneratedPluginRegistrant2");
            Method registrationMethod =
                    generatedPluginRegistrant.getDeclaredMethod("registerWith", FlutterEngine.class);
            registrationMethod.invoke(null, flutterEngine);
        } catch (Exception e) {
            Log.e(TAG,
                    "Tried to automatically register plugins with FlutterEngine ("
                            + flutterEngine
                            + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.e(TAG, "Received exception while registering", e);
        }
    }
}
