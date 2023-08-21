plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "co.id.cpn.common"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    "implementation"(Main.kotlin)
    "implementation"(Main.coreKtx)
    "implementation"(Misc.moshi)
    "implementation"(Misc.moshiKotlin)
    "implementation"(Misc.timber)
    "implementation"(Misc.retrofit)
    "implementation"(Misc.okhttp)
    "implementation"(Misc.loggingInterceptor)

    "implementation"(ArchitectureComponent.lifecycleKtx)
    "implementation"(ArchitectureComponent.lifecycleCommon)

    "implementation"(JetpackCompose.composeCompiler)

    "implementation"(Misc.hiltAndroid)
    "kapt"(Misc.hiltCompiler)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}