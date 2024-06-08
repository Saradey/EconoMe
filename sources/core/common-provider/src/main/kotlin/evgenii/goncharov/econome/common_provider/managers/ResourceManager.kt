package evgenii.goncharov.econome.common_provider.managers

import androidx.annotation.StringRes

public interface ResourceManager {

    public fun getString(@StringRes idString: Int): String


}