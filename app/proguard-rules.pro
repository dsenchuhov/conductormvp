-keepattributes Signature,*Annotation*,SourceFile,LineNumberTable,InnerClasses,EnclosingMethod

-dontwarn rx.internal.util.unsafe.**
-dontwarn kotlin.**

-keep class kotlin.** { *; }
-keep class org.jetbrains.kotlin.** { *; }
-keep class org.jetbrains.annotations.** { *; }
-keepclassmembers public class com.cypressworks.kotlinreflectionproguard.** { *; }
-keepclassmembers class ** { @org.jetbrains.annotations.ReadOnly public *; }
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}
-keepclassmembers class **$WhenMappings { <fields>; }
-keep class kotlin.Metadata { *; }

-keep public class * extends android.app.Activity { *; }

#ok
-keep class **.R
-keep class **.R$* {
    <fields>;
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class **.R$* {
    public static <fields>;
}