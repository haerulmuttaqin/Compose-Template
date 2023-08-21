plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = AndroidConfig.namespace
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.koltinCompilerVersion
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

    implementation(project(Modules.common))
    implementation(project(Modules.coreUi))
    implementation(project(Modules.login))
    implementation(project(Modules.register))
    implementation(project(Modules.category))
    implementation(project(Modules.point))
    implementation(project(Modules.account))
    implementation(project(Modules.search))
    implementation(project(Modules.banner))

    implementation(Main.kotlin)
    implementation(Main.coreKtx)
    implementation(Main.splashScreen)

    implementation(JetpackCompose.composeCompiler)
    implementation(JetpackCompose.composeActivity)
    implementation(JetpackCompose.composeMaterial)
    implementation(JetpackCompose.navigation)
    implementation(JetpackCompose.composeUi)
    implementation(JetpackCompose.icon)
    implementation(JetpackCompose.composeUiToolingPreview)
    debugImplementation(JetpackCompose.composeUiTooling)

    implementation(ArchitectureComponent.navigationRuntime)
    implementation(ArchitectureComponent.navigationUi)
    implementation(ArchitectureComponent.navigationFragment)

    implementation(Misc.timber)
    implementation(Misc.hiltAndroid)
    kapt(Misc.hiltCompiler)
    implementation(Misc.hiltNavigationCompose)

    implementation(Misc.sharedElement)
    implementation(Misc.coilCompose)

    testImplementation(Testing.junit)
    androidTestImplementation(Testing.extJunit)
    androidTestImplementation(Testing.espressoCore)
}