package com.mh.test;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ContentValues;
import android.text.Editable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.finders.ConstructorFinder;
import com.github.kyuubiran.ezxhelper.finders.MethodFinder;
import com.github.kyuubiran.ezxhelper.interfaces.IMethodHookCallback;
import com.google.gson.Gson;
import com.shark.SuperModule;
import com.shark.ViewModule;
import com.shark.context.ContextUtils;
import com.shark.input.InputManager;
import com.shark.signal.IRecvListener;
import com.shark.socket.JWebSocketClient;
import com.shark.socket.WebSocketMessage;
import com.shark.tools.ScreenShot;
import com.shark.utils.LogUtils;
import com.shark.utils.ThreadUtils;
import com.shark.view.ViewInfo;
import com.shark.view.ViewManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class DemoMain extends ViewModule {

    @Override
    public void main(ClassLoader classLoader, String processName, String packageName) {
//        trackActivityOnResume(classLoader);
//        trackFragment(classLoader);


        // 屏蔽掉热更新
        findAndHookConstructor(
                "com.tencent.tinker.loader.app.TinkerApplication", //
                mClassLoader,
                int.class,
                String.class,
                String.class,
                boolean.class,
                boolean.class,
                boolean.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        param.args[2] = "com.tencent.mm.app.MMApplicationLike"; // com.tencent.mm.app.MMApplicationLike
                        logBefore(param);
                    }
                }
        );

        Log.i(TAG, "main: DemoMain 微信测试2");

        XposedHelpers.findAndHookMethod(Instrumentation.class, "callApplicationOnCreate", Application.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                hookMessage(classLoader);

            }
        });

    }

    public void hookMessage(ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod("com.tencent.mm.storage.s9", classLoader, "U9", long.class, "com.tencent.mm.storage.q9", boolean.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                logBefore(param);
                Object message = param.args[1];
                long msgSvrId = XposedHelpers.getLongField(message, "field_msgSvrId");
                Log.i(TAG, "msgSvrId: "+msgSvrId);
                long msgId = XposedHelpers.getLongField(message, "field_msgId");
                Log.i(TAG, "msgId: "+msgId);

            }

        });
    }

    public void hookDb(ClassLoader classLoader) {

        XposedHelpers.findAndHookMethod("com.tencent.wcdb.compat.SQLiteDatabase", classLoader, "insertWithOnConflict", "java.lang.String", "java.lang.String", "android.content.ContentValues", int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
//                logBefore(param);

            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });

        /**
         * 消息相关
         */
        XposedHelpers.findAndHookMethod("com.tencent.wcdb.database.SQLiteDatabase", classLoader, "insertWithOnConflict", "java.lang.String", "java.lang.String", "android.content.ContentValues", int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                ContentValues contentValues = (ContentValues) param.args[2];
                String tableName = (String) param.args[0];

                if (tableName == null || !"message".equals(tableName)) return;
                logBefore(param);

                for (String key : contentValues.keySet()) {
                    Log.i(TAG, "x Xposed: Key: " + key + " | Value: " + contentValues.get(key));

                }
            }

        });


        XposedHelpers.findAndHookMethod("com.tencent.wcdb.database.SQLiteDatabase", classLoader, "updateWithOnConflict", "java.lang.String", "android.content.ContentValues", "java.lang.String", "java.lang.String[]", int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                ContentValues contentValues = (ContentValues) param.args[1];
                String tableName = (String) param.args[0];

                if (tableName == null || !"message".equals(tableName)) return;
                logBefore(param);

                for (String key : contentValues.keySet()) {
                    Log.i(TAG, "x Xposed: Key: " + key + " | Value: " + contentValues.get(key));

                }

                logStackTraceByException();
            }
        });

    }
}
