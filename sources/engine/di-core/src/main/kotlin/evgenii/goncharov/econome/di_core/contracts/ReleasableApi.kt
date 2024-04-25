package evgenii.goncharov.econome.di_core.contracts

import androidx.lifecycle.ViewModelProvider

public interface ReleasableApi {

    public fun provideViewModelFactory(): ViewModelProvider.Factory
}