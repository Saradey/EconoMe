package evgenii.goncharov.econome.user_impl.repositories

internal interface UserCreatorRepository {

    suspend fun saveNewUser(userId: String, userInputName: String)
}