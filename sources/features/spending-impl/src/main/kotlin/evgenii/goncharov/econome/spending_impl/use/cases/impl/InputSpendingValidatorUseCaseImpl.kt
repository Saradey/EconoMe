package evgenii.goncharov.econome.spending_impl.use.cases.impl

import evgenii.goncharov.econome.spending_impl.use.cases.InputSpendingValidatorUseCase
import javax.inject.Inject

internal class InputSpendingValidatorUseCaseImpl @Inject constructor() :
    InputSpendingValidatorUseCase {

    private val regex = Regex(NUMBER_PATTERN)

    override fun invoke(spending: String): Boolean {
        return regex.matches(spending)
    }

    private companion object {

        const val NUMBER_PATTERN = "^-?[0-9]+\$"
    }
}