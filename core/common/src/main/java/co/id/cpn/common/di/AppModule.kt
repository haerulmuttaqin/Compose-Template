package co.id.cpn.common.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import co.id.cpn.common.extensions.MoshiUtil
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return MoshiUtil.getMoshi()
    }

//    @Singleton
//    @Provides
//    fun provideRetrofit(moshi: Moshi): Retrofit {
//        return ApiClient.getRetrofit(moshi)
//    }
//
//    @Singleton
//    @Provides
//    fun provideGithubApiInterface(moshi: Moshi): GithubApiInterface {
//        return ApiClient.getRetrofit(
//            moshi,
//            Constants.SERVER_ENDPOINT + "/"
//        ).create(GithubApiInterface::class.java)
//    }
}
