package com.gzeinnumer.fragmentoptionmenu;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        User.class
}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(1);
}
