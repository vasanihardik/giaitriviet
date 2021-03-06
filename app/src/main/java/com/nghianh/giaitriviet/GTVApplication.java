/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nghianh.giaitriviet;

import android.app.Application;

import com.google.firebase.crash.FirebaseCrash;
import com.nghianh.giaitriviet.util.Log;

/**
 * Placeholder application to facilitate overriding Application methods for debugging and testing.
 */
public class GTVApplication extends Application {

    //protected String userAgent;

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                FirebaseCrash.report(ex);
                Log.e("GTVApplication", ex.getMessage());
                ex.printStackTrace();
            }
        });
    }
}
