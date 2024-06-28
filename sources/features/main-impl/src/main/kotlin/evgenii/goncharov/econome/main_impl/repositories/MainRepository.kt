package evgenii.goncharov.econome.main_impl.repositories

internal interface MainRepository {

    suspend fun getUserNameById(currentUserId: String): String

    suspend fun getWalletNameById(currentWalletId: Long): String
}