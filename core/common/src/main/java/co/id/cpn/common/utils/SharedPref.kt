package co.id.cpn.common.utils

import android.content.Context
import android.content.SharedPreferences
import co.id.cpn.common.models.User
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import timber.log.Timber

@Singleton
class SharedPref @Inject constructor(
    @ApplicationContext context: Context
) {

    companion object {
        private const val PREF_LOGIN = "is_login"
        private const val PREF_TOKEN = "token"
        private const val PREF_USER = "user"
        private const val PREF_DARK_MODE = "dark_mode"
    }

    private val context: Context = context.applicationContext

    @Volatile
    private var sharedPref: SharedPreferences? = null

    @Volatile
    private var user: User? = null

    private fun getSharedPerf(): SharedPreferences {
        return sharedPref ?: synchronized(this) {
            context.getSharedPreferences(
                "${context.packageName}.main",
                Context.MODE_PRIVATE
            )
        }
    }

    fun reset() {
        getSharedPerf().edit().clear().apply()

        user = null
    }

    // ----------------------------------------------------------------

    fun setLogin(login: Boolean) {
        getSharedPerf()
            .edit()
            .apply {
                putBoolean(PREF_LOGIN, login)
                apply()
            }
    }

    fun isLogin(): Boolean {
        return getSharedPerf().getBoolean(PREF_LOGIN, false)
    }


    // ----------------------------------------------------------------

    fun setToken(token: String) {
        getSharedPerf()
            .edit()
            .apply {
                putString(PREF_TOKEN, token)
                apply()
            }
    }

    fun getToken(): String? {
        return getSharedPerf().getString(PREF_TOKEN, null)
    }

    // ----------------------------------------------------------------

    fun setUser(user: User) {
        getSharedPerf()
            .edit()
            .apply {
                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi.adapter(User::class.java)

                putString(PREF_USER, jsonAdapter.toJson(user))
                apply()
            }

        // Reset data if exist.
        this.user = null
    }

    fun getUser(): User? {
        return user ?: synchronized(this) {
            getSharedPerf()
                .let {
                    val moshi = Moshi.Builder().build()
                    val jsonAdapter = moshi.adapter(User::class.java)

                    val userJson = it.getString(PREF_USER, null)

                    user = if (userJson == null) {
                        null
                    } else {
                        jsonAdapter.fromJson(userJson)
                    }

                    Timber.d("user: $user")

                    user
                }
        }
    }

    // ----------------------------------------------------------------

    fun isUserLoggedIn(): Boolean {
        return getUser() != null
    }

    // ----------------------------------------------------------------

    fun setDarkMode(isDark: Boolean) {
        getSharedPerf()
            .edit()
            .apply {
                putBoolean(PREF_DARK_MODE, isDark)
                apply()
            }
    }

    fun getDarkMode(): Boolean {
        return getSharedPerf().getBoolean(PREF_DARK_MODE, false)
    }
}
