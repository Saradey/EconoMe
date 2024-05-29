package evgenii.goncharov.econome.core_database_impl.mappers

import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.core_database_impl.entities.WalletEntity
import javax.inject.Inject

internal class WalletMapper @Inject constructor() {

    fun walletDtoToWalletEntity(walletDto: WalletDto) : WalletEntity {
        return WalletEntity(
            id = walletDto.id,
            walletName = walletDto.walletName,
            walletCodeIso2 = walletDto.walletCodeIso2
        )
    }
}