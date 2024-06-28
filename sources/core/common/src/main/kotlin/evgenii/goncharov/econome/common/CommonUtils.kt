package evgenii.goncharov.econome.common

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

public fun readRawCurrency(stream: InputStream): String {
    val reader = BufferedReader(InputStreamReader(stream))
    return reader.use { it.readText() }
}