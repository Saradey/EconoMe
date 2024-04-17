package evgenii.goncharov.econome.di_core.contracts

public interface LaunchersApi {

    public fun provideLaunchers(): Map<Class<*>, BaseLauncher>
}