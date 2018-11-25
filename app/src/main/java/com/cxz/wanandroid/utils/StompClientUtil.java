package com.cxz.wanandroid.utils;

import android.util.Log;

import org.java_websocket.WebSocket;

import rx.Subscriber;
import rx.functions.Action1;
import ua.naiksoftware.stomp.LifecycleEvent;
import ua.naiksoftware.stomp.Stomp;

/**
 * TODO
 * author : 马世豪 29350
 * time   : 2018/04/12
 * version: 1.0
 */
public class StompClientUtil {


    private static final String TAG = "MSH";
    private static ua.naiksoftware.stomp.client.StompClient StompClient;

    private static boolean connect = false;

    public static boolean isConnect() {
        return connect;
    }


    public static ua.naiksoftware.stomp.client.StompClient getStompClient() {
        return StompClient;

    }

    public static void init() {
        StompClient = Stomp.over(WebSocket.class, "ws://192.168.3.5:8080/hello/websocket");
        StompClient.connect();
        StompClient.lifecycle().subscribe(new Action1<LifecycleEvent>() {
            @Override
            public void call(LifecycleEvent lifecycleEvent) {
                switch (lifecycleEvent.getType()) {
                    case OPENED:
                        Log.e(TAG, "Stomp connection opened  连接已开启");
                        connect = true;
                        break;
                    case ERROR:
                        Log.e(TAG, "Stomp Error  连接出错", lifecycleEvent.getException());
                        connect = false;
                        getStompClient().disconnect();
                        break;
                    case CLOSED:
                        Log.e(TAG, "Stomp connection closed  连接关闭");
                        connect = false;
                        getStompClient().disconnect();
                        break;
                }
            }
        });
    }


    public static void send(String text) {

        getStompClient().send("/app/welcome", text)
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MSH", e.toString());
                    }

                    @Override
                    public void onNext(Void aVoid) {

                    }
                });
    }


}
