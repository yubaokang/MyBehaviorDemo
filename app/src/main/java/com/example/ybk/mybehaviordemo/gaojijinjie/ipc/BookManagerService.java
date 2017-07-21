package com.example.ybk.mybehaviordemo.gaojijinjie.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 进程：com.example.ybk.mybehaviordemo:bookManagerService
 */
public class BookManagerService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        books.add(new Book("哈哈1", 12.34));
        books.add(new Book("哈哈2", 13.45));
    }

    private CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();

    private Binder binder = new IBookManager.Stub() {

        @Override
        public List<Book> getBookList() throws RemoteException {
            return books;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            books.add(book);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
