Example project for [Adaptive](https://github.com/spxbhuhb/adaptive).

A simple Adaptive application with:

- server (works)
- browser app (works)
- android app (works)
- ios app (in progress)

## Setup and Run

Easiest way to use this example project is with Android Studio:

1. clone the repository
2. wait till all imports and downloads finish
3. if you are not on Mac, set `ios-support` to `none` in [libs.versions.toml](gradle/libs.versions.toml) (see [iOS targets](#ios-targets))
4. create a file `local.properties` in the project root and put `sdk.dir=/Users/<your-username>/Library/Android/sdk` into it (or wherever your SDK is)
5. open terminal and run `./gradlew server:run`
6. open another terminal and run `./gradlew browser:jsBrowserRun`
7. run `androidApp` on your test device from Android Studio

## iOS targets

If you are building with iOS targets you have to run the build on Mac OS X. This is a requirement from Apple,
see [Multiplatform Setup](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-setup.html) for details.

To disable iOS targets set the version of `ios-support` to `none` in [libs.versions.toml](gradle/libs.versions.toml). Any
value other than `none` adds support for iOS.

This is also useful when you don't want to wait for the iOS linking during development.

## License

> Copyright (c) 2024 Simplexion Kft, Hungary and contributors
>
> Licensed under the Apache License, Version 2.0 (the "License");
> you may not use this work except in compliance with the License.
> You may obtain a copy of the License at
>
>    http://www.apache.org/licenses/LICENSE-2.0
>
> Unless required by applicable law or agreed to in writing, software
> distributed under the License is distributed on an "AS IS" BASIS,
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
> See the License for the specific language governing permissions and
> limitations under the License.