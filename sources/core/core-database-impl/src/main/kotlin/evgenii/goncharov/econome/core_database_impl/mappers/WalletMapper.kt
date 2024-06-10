package evgenii.goncharov.econome.core_database_impl.mappers

import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.core_database_impl.entities.WalletEntity
import javax.inject.Inject

internal class WalletMapper @Inject constructor() {

    fun walletDtoToWalletEntity(walletDto: WalletDto) : WalletEntity {
        return WalletEntity(
            id = walletDto.id,
            walletName = walletDto.walletName,
            code = walletDto.code
        )
    }

    fun walletEntityToWalletDto(entity : WalletEntity) : WalletDto {
        return WalletDto(
            id = entity.id,
            walletName = entity.walletName,
            code = entity.code
        )
    }
}