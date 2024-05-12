package evgenii.goncharov.econome.user_impl.use.cases

internal fun interface UserValidateNameUseCase {

    operator fun invoke(userName: String?) : Boolean
}