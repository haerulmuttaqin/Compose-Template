pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if( requested.id.id == "dagger.hilt.android.plugin") {
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.44")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots")
    }
}
rootProject.name = "Sadix Outlet Order"
include(":app")
include(":features:register:register_data")
include(":features:register:register_domain")
include(":features:register:register_ui")
include(":features:login:login_data")
include(":features:login:login_domain")
include(":features:login:login_ui")
include(":core:common")
include(":core:ui")
include(":core:navigation")
include(":core:network")
include(":features:category:category_ui")
include(":features:point")
include(":features:point:point_ui")
include(":features:account:account_ui")
include(":features:search:search_ui")
include(":features:banner:banner_ui")
