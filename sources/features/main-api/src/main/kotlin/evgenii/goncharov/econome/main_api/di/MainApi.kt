package evgenii.goncharov.econome.main_api.di

import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.main_api.dependencies.MainDataRefresher

public interface MainApi : ReleasableApi {

    public fun provideMainDataRefresher() : MainDataRefresher
}