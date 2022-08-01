load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

###############################################################################
# rules_kotlin dependencies
# See instruction at https://github.com/bazelbuild/rules_kotlin#quick-guide

# Use local check-out of repo rules (or a commit-archive from github via http_archive or git_repository)
local_repository(
    name = "release_archive",
    path = "../rules_kotlin/src/main/starlark/release_archive",
)
load("@release_archive//:repository.bzl", "archive_repository")

archive_repository(
    name = "io_bazel_rules_kotlin",
    local_path = "../rules_kotlin/"
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories", "versions")

kotlin_repositories()

load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")

kt_register_toolchains()


###############################################################################
# maven_install dependencies (to install external dependencies from maven repository)
# See instruction at https://github.com/bazelbuild/rules_jvm_external#usage
http_archive(
    name = "rules_jvm_external",
    sha256 = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca",
    strip_prefix = "rules_jvm_external-4.2",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.2.zip",
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.10",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4",
        "io.ktor:ktor-server-core-jvm:2.0.3",
        "io.ktor:ktor-server-netty-jvm:2.0.3",
        "io.ktor:ktor-server-host-common-jvm:2.0.3",
        "io.ktor:ktor-http-jvm:2.0.3",
        "io.ktor:ktor-utils-jvm:2.0.3",
        "org.slf4j:slf4j-api:1.7.36",
        "org.slf4j:slf4j-simple:1.7.36",
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)
