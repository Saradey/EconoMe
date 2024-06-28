package evgenii.goncharov.econome.spending_impl.use.cases

internal fun interface InputSpendingValidatorUseCase {

    fun invoke(spending: String): Boolean
}