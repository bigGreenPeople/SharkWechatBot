package com.mh.test;

import android.annotation.SuppressLint;
import android.app.Activity;
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


        Log.i(TAG, "main: DemoMain 微信测试");

    }
}
