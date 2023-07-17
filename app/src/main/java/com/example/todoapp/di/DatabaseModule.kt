package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.R
import com.example.todoapp.datasource.local_persistence.ToDoDao
import com.example.todoapp.datasource.local_persistence.ToDoDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    @AppScope
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        context.getString(R.string.database_name)
    ).fallbackToDestructiveMigration().build()

    @Provides
    @AppScope
    fun provideTaskDao(database: ToDoDatabase): ToDoDao = database.dao()
}