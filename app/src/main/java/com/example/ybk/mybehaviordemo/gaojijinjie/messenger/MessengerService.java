package com.example.ybk.mybehaviordemo.gaojijinjie.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * 进程为：com.example.ybk.mybehaviordemo:service
 */
public class MessengerService extends Service {

    public MessengerService() {
    }

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Consts.CLIENT://接收来自Activity的消息
                    Log.i("-----", msg.getData().getString("msg"));

                    Messenger messenger = msg.replyTo;//获得Activity传递过来的信使
                    Message message = Message.obtain(null, Consts.SERVICE);
                    Bundle bundle = new Bundle();
                    bundle.putString("msg", "我收到了你的消息，消息是:(" + msg.getData().getString("msg") + ")");
                    message.setData(bundle);

                    try {
                        messenger.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    private final Messenger messenger = new Messenger(new MessengerHandler());

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("----", "onDestroy");
    }
}
