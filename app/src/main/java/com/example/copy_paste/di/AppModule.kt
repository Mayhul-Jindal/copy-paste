package com.example.copy_paste.di

import android.app.Application
import com.example.copy_paste.data.CopiedDao
import com.example.copy_paste.data.CopiedDatabase
import com.example.copy_paste.data.CopiedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideDatabase(app: Application): CopiedDatabase{
        return CopiedDatabase.getInstance(app)
    }

    @Singleton
    @Provides
    fun provideDao(database: CopiedDatabase): CopiedDao{
        return database.CopiedDao()
    }

    @Singleton
    @Provides
    fun provideRepo(dao: CopiedDao): CopiedRepository{
        return CopiedRepository(dao)
    }
}