package evgenii.goncharov.econome.wallet_impl.utils

import kotlin.random.Random

internal object IdWalletGenerator {

    fun generateId(): Long {
        val timestamp = System.currentTimeMillis()
        return timestamp * 1000 + Random.nextLong() % 1000
    }
}