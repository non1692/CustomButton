plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.softtek.buttonapp"
    compileSdk = 34

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

/**
 * Publicación de paquete
 */
/*
publishing {
    publications {

        register<MavenPublication>("release") {
            //groupId = "com.softtek.buttonapp"
            groupId = "com.softtek.buttonapp"
            artifactId = "custombutton"
            version = "1.0.7"
            artifact ("$buildDir/outputs/aar/buttonapp-release.aar")
        }
    }

    repositories {
        maven {
            name = "CustomButton"
            url = uri("https://maven.pkg.github.com/non1692/CustomButton")
            credentials {
                username = "non1692"
                password = "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"
            }
        }
    }

}
*/
/**
 * Publicación de release
 */
publishing{
    publications{
        register<MavenPublication>("release") {
            groupId = "com.github.non1692"
            artifactId = "CustomButton"
            version = "2.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}