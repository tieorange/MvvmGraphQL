MVVM App template
**MVVM + Kotlin + RxJava2 + Dagger 2.14**

_annotationProcessor "com.google.dagger:dagger-android-processor:$daggerVersion"
debugCompile 'com.readystatesoftware.chuck:library:1.1.0'
implementation fileTree(dir: 'libs', include: ['*.jar'])
implementation('com.afollestad.material-dialogs:core:0.9.4.5') { exclude module: 'support-v13' }
implementation "com.android.support:appcompat-v7:$supportLibVersion"
implementation "com.android.support:cardview-v7:$supportLibVersion"
implementation "com.android.support:design:$supportLibVersion"
implementation 'com.android.support:multidex:1.0.2'
implementation "com.android.support:preference-v14:$supportLibVersion"
implementation "com.android.support:preference-v7:$supportLibVersion"
implementation "com.android.support:recyclerview-v7:$supportLibVersion"
implementation "com.android.support:support-core-ui:$supportLibVersion"
implementation "com.android.support:support-fragment:$supportLibVersion"
implementation "com.android.support:support-v13:$supportLibVersion"
implementation "com.android.support:support-v4:$supportLibVersion"
implementation 'com.android.support.constraint:constraint-layout:1.0.2'
implementation 'com.dmitrymalkovich.android:material-design-dimens:1.4'
implementation('com.github.hotchemi:permissionsdispatcher:3.0.1') { exclude module: 'support-v13' }
implementation 'com.google.code.gson:gson:2.8.2'
implementation "com.google.dagger:dagger:$daggerVersion"
implementation "com.google.dagger:dagger-android-support:$daggerVersion"
implementation 'com.jakewharton.timber:timber:4.5.1'
implementation 'com.mcxiaoke.koi:core:0.5.4'
implementation 'com.miguelcatalan:materialsearchview:1.4.0'
implementation 'com.orhanobut:hawk:2.0.1'
implementation "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
implementation "com.squareup.okhttp3:okhttp:$okHttpVersion"
implementation 'com.squareup.picasso:picasso:2.5.2'
implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
implementation "com.squareup.retrofit2:converter-gson:$retrofitVersion"
implementation "com.squareup.retrofit2:retrofit:$retrofitVersion"
implementation 'de.hdodenhof:circleimageview:2.2.0'
implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
implementation 'io.reactivex.rxjava2:rxjava:2.1.7'
implementation 'me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:2.1.0'
implementation 'me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:2.1.0'
implementation "nz.bradcampbell:paperparcel:$paperParcelVersion"
implementation "nz.bradcampbell:paperparcel-kotlin:$paperParcelVersion"
implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
implementation "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlinVersion"
kapt "com.android.databinding:compiler:$gradlePluginVersion"
kapt 'com.github.hotchemi:permissionsdispatcher-processor:3.0.1'
kapt "com.google.dagger:dagger-compiler:$daggerVersion"
kapt "nz.bradcampbell:paperparcel-compiler:$paperParcelVersion"
releaseCompile 'com.readystatesoftware.chuck:library-no-op:1.1.0'_
