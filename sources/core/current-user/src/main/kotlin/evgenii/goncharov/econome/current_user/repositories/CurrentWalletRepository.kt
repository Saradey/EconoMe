package evgenii.goncharov.econome.current_user.repositories

public interface CurrentWalletRepository {

    public fun setCurrentWalletId(walletId: Long)

    public val currentWalletId: Long
}