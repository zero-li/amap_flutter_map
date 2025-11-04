plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.amap.flutter.amap_flutter_map_example"
    compileSdk = flutter.compileSdkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        // TODO: Specify your own unique Application ID (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.amap.flutter.amap_flutter_map_example"
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    signingConfigs {
        getByName("debug") {
            // keystore中key的别名
            keyAlias = "androiddebugkey"
            // keystore中key的密码
            keyPassword = "android"
            // keystore的文件路径，可以是绝对路径也可以是相对路径
            storeFile = file("../debug.keystore")
            // keystore的密码
            storePassword = "android"
        }
    }


    buildTypes {
        release {
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
            signingConfig = signingConfigs.getByName("debug")

            //关闭混淆, 否则在运行release包后可能出现运行崩溃， TODO后续进行混淆配置
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }
}


dependencies {
    //demo中引入高德地图SDK
    implementation("com.amap.api:3dmap:8.1.0")
}

flutter {
    source = "../.."
}
