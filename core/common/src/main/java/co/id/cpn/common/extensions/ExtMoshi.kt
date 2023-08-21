package co.id.cpn.common.extensions

import com.squareup.moshi.Moshi
import java.net.URLEncoder
import java.util.Date
import co.id.cpn.common.network.jsonadapter.DateJsonAdapter
import timber.log.Timber

object MoshiUtil {
    fun getMoshi(): Moshi {
        return Moshi.Builder()
            .add(Date::class.java, DateJsonAdapter())
            .build()
    }
}

inline fun <reified T> String?.getObjFromJson(): T? {
    if (this == null) return null

    Timber.e("getObjFromJson: $this")

    val jsonAdapter = MoshiUtil.getMoshi().adapter(T::class.java).lenient()

    return jsonAdapter.fromJson(this)
}

inline fun <reified T> T?.getJsonFromObj(urlEncode: Boolean = true): String? {
    if (this == null) return null

    Timber.e("getJsonFromObj: $this")

    val jsonAdapter = MoshiUtil.getMoshi().adapter(T::class.java).lenient()

    return jsonAdapter.toJson(this).let { json ->
        if (urlEncode) json.urlEncode() else json
    }
}

fun String.urlEncode(): String {
    return URLEncoder.encode(this, "utf-8")
}
