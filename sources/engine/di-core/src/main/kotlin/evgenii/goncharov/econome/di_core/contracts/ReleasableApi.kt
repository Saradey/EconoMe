package evgenii.goncharov.econome.di_core.contracts

import androidx.lifecycle.ViewModelProvider
import evgenii.goncharov.econome.di_core.di.qualifiers.CommonViewModelFactory

public interface ReleasableApi {

    @CommonViewModelFactory
    public fun provideViewModelFactory(): ViewModelProvider.Factory
}