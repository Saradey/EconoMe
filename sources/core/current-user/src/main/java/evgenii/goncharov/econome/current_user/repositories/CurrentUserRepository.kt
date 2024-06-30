package evgenii.goncharov.econome.current_user.repositories

public interface CurrentUserRepository {

    public fun setUserId(userId: String)

    public val currentUserIde: String
}