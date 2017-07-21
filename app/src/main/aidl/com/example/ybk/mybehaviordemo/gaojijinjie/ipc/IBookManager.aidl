// IBookManager.aidl
package com.example.ybk.mybehaviordemo.gaojijinjie.ipc;

// Declare any non-default types here with import statements
import com.example.ybk.mybehaviordemo.gaojijinjie.ipc.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
