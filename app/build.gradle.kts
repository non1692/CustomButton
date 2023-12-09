plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {

    signingConfigs {
        create("config") {
            keyAlias = "keystore"
            keyPassword = "android"
            storeFile = file("debug.keystore.jks")
            //storeFile = file("C:\\Users\\noe.rojasf\\AndroidStudioProjects\\CustomButton\\app\\debug.keystore.jks")
            storePassword = "android"
        }
    }

    namespace = "com.softtek.custombutton"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.softtek.custombutton"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = true
            signingConfig = signingConfigs["config"]

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    /*    buildTypes {
            release {
                this.isMinifyEnabled = true
                this.isDebuggable = true
            }
        }*/

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(project(mapOf("path" to ":buttonapp")))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}