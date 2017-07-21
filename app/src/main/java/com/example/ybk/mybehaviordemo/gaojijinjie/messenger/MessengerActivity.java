package com.example.ybk.mybehaviordemo.gaojijinjie.messenger;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ybk.mybehaviordemo.R;

/**
 * 默认进程 com.example.ybk.mybehaviordemo
 */
public class MessengerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        Intent intent = new Intent(this, MessengerService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
//        startService(intent);
    }

    private Messenger clientMessenger = new Messenger(new ClientHandler());

    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Messenger messenger = new Messenger(service);
            Message msg = Message.obtain(null, Consts.CLIENT);
            Bundle data = new Bundle();
            data.putString("msg", "你好，我来自Activity");
            msg.setData(data);
            msg.replyTo = clientMessenger;//将Activity中的信使传递给Service
            try {
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    private static class ClientHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Consts.SERVICE://接收来自Service的消息
                    Log.i("----ClientHandler  ", msg.getData().getString("msg"));
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }
}
