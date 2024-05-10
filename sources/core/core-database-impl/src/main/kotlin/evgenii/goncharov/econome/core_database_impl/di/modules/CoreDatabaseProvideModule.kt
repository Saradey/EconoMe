package evgenii.goncharov.econome.core_database_impl.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import evgenii.goncharov.econome.core_database_impl.common.DATA_BASE_NAME
import evgenii.goncharov.econome.core_database_impl.data.base.AppDatabase
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal object CoreDatabaseProvideModule {

    @CoreScope
    @Provides
    fun provideAppDatabase(appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, DATA_BASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}