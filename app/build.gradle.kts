plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("com.google.devtools.ksp")
}

android {
    namespace = "com.dicoding.todoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dicoding.todoapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments += mapOf(
            "clearPackageData" to "true"
        )
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    ext {
        set("kotlin_version", "1.9.10")

        set("core_version", "1.12.0")
        set("appcompat_version", "1.6.1")
        set("material_version", "1.10.0")
        set("constraint_version", "2.1.4")

        set("junit_version", "4.13.2")
        set("ext_junit_version", "1.1.5")
        set("espresso_version", "3.5.1")
        set("runner_version", "1.2.0")

        set("room_version", "2.6.0")
        set("arch_lifecycle_version", "2.6.2")
        set("lifecycle_version", "2.6.1")
        set("work_version", "2.8.1")
        set("preference_version", "1.2.1")
        set("paging_version", "2.1.2")
    }

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${extra["kotlin_version"]}")
    implementation("androidx.core:core-ktx:${extra["core_version"]}")
    implementation("androidx.appcompat:appcompat:${extra["appcompat_version"]}")
    implementation("com.google.android.material:material:${extra["material_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:${extra["constraint_version"]}")

    testImplementation("junit:junit:${extra["junit_version"]}")
    androidTestImplementation("androidx.test.ext:junit:${extra["ext_junit_version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${extra["espresso_version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-intents:${extra["espresso_version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:${extra["espresso_version"]}")
    androidTestImplementation("androidx.test:runner:${extra["runner_version"]}")

    implementation("androidx.room:room-runtime:${extra["room_version"]}")
    ksp("androidx.room:room-compiler:${extra["room_version"]}")
    implementation("androidx.room:room-ktx:${extra["room_version"]}")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${extra["arch_lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${extra["arch_lifecycle_version"]}")

    implementation("androidx.work:work-runtime-ktx:${extra["work_version"]}")
    implementation("androidx.preference:preference-ktx:${extra["preference_version"]}")

    implementation("androidx.paging:paging-runtime-ktx:${extra["paging_version"]}")

    androidTestUtil("androidx.test:orchestrator:1.4.2")
    androidTestImplementation("com.kaspersky.android-components:kaspresso:1.5.3")

}