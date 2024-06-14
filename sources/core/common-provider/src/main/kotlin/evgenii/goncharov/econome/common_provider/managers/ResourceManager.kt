package evgenii.goncharov.econome.common_provider.managers

import androidx.annotation.RawRes
import androidx.annotation.StringRes
import java.io.InputStream

public interface ResourceManager {

    public fun getString(@StringRes idString: Int): String

    public fun getRawFile(@RawRes idRes: Int): InputStream
}