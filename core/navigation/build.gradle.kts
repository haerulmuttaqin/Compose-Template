apply {
    from("$rootDir/buildSrc/android-common.gradle")
}

dependencies {
    "implementation"(JetpackCompose.navigation)
}