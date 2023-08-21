apply {
    from("$rootDir/buildSrc/android-common.gradle")
}
dependencies {
    "implementation"(project(Modules.coreUi))
    "implementation"(ArchitectureComponent.navigationRuntime)
    "implementation"(ArchitectureComponent.navigationUi)
    "implementation"(ArchitectureComponent.navigationFragment)
    "implementation"(JetpackCompose.composeRuntime)
    "implementation"(JetpackCompose.composeLifecycle)
    "implementation"(JetpackCompose.composeCompiler)
    "implementation"(JetpackCompose.composeActivity)
    "implementation"(JetpackCompose.composeMaterial)
    "implementation"(JetpackCompose.navigation)
    "implementation"(JetpackCompose.composeUi)
    "debugImplementation"(JetpackCompose.composeUiTooling)
    "implementation"(JetpackCompose.composeUiToolingPreview)
    "implementation"(Misc.coilCompose)
}