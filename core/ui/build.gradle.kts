apply {
    from("$rootDir/buildSrc/android-common.gradle")
}

dependencies {
    // JetpackCompose
    "implementation"(JetpackCompose.composeCompiler)
    "implementation"(JetpackCompose.composeActivity)
    "implementation"(JetpackCompose.composeMaterial)
    "implementation"(JetpackCompose.navigation)
    "implementation"(JetpackCompose.composeUi)
    "implementation"(JetpackCompose.icon)
    "debugImplementation"(JetpackCompose.composeUiTooling)
    "implementation"(JetpackCompose.composeUiToolingPreview)

    // Accompanist
    "implementation"(Accompanist.systemuicontroller)
    "implementation"(Accompanist.flowlayout)
    "implementation"(Accompanist.flowlayout)
    "implementation"(Accompanist.swipeRefresh)
    "implementation"(Accompanist.pager)
    "implementation"(Misc.libPhoneNumber)

    // Misc
    "implementation"(Misc.sharedElement)

}