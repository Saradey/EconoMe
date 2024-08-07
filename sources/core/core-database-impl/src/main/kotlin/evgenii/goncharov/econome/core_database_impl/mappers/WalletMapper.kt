package evgenii.goncharov.econome.core_database_impl.mappers

import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.core_database_impl.entities.WalletEntity
import javax.inject.Inject

internal class WalletMapper @Inject constructor() {

    fun walletDtoToWalletEntity(walletDto: WalletDto) : WalletEntity {
        return WalletEntity(
            walletId = walletDto.walletId,
            walletName = walletDto.walletName,
            code = walletDto.currencyCode,
            sequenceNumber = walletDto.sequenceNumber,
            userId = walletDto.userId
        )
    }

    fun walletEntityToWalletDto(entity : WalletEntity) : WalletDto {
        return WalletDto(
            walletId = entity.walletId,
            walletName = entity.walletName,
            currencyCode = entity.code,
            sequenceNumber = entity.sequenceNumber,
            userId = entity.userId
        )
    }
}