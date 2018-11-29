package com.cxz.wanandroid.utils;

import android.util.Log;
import android.widget.Toast;

import com.cxz.wanandroid.app.App;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * author : 马世豪 29350
 * time   : 2018/11/18
 * version: 1.0
 */
public class LogServiceUtil {


    private static final String TAG = "MSH";
    private static int PORT = 2017;

    private static final String ip = "192.168.5.224";

    private LogServiceUtil() {
    }

    private static volatile WebSocketClient INSTANCE = null;

    public static WebSocketClient getINSTANCE() {
        if (INSTANCE == null) {
            init();
        }
        return INSTANCE;
    }

    static URI getURI() {
        URI uri = null;
        try {
            uri = new URI("ws://" + ip + ":" + PORT);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
        return uri;
    }

    static void init() {
        if (getURI() == null) {
            return;
        }

        INSTANCE = new WebSocketClient(getURI(), new Draft_10()) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Toast.makeText(App.instance, "连接成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMessage(String message) {
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.e(TAG, "连接关闭");
            }

            @Override
            public void onError(Exception ex) {
                Log.e(TAG, "链接错误" + ex.toString());
            }
        };
    }

    public static void connect() {
        close();
        getINSTANCE().connect();
    }

    public static void close() {
        if (getINSTANCE() != null) {
            getINSTANCE().close();
            INSTANCE = null;
        }
    }

    public static void send(String msg) {
        try {
            getINSTANCE().send(msg);
        } catch (Exception e) {
            Log.e("MSH", e.toString());
        }
    }
}
