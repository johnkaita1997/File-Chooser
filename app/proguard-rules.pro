# Required for GmailSender
-dontwarn java.awt.**
-dontwarn java.beans.Beans
-dontwarn javax.security.**
-keep class javamail** {*;}
-keep class javax.mail** {*;}
-keep class javax.activation** {*;}
-keep class com.sun.mail.dsn** {*;}
-keep class com.sun.mail.handlers** {*;}
-keep class com.sun.mail.smtp** {*;}
-keep class com.sun.mail.util** {*;}
-keep class mailcap** {*;}
-keep class mimetypes** {*;}
-keep class myjava.awt.datatransfer** {*;}
-keep class org.apache.harmony.awt** {*;}
-keep class org.apache.harmony.misc** {*;}
-keep class com.vdocipher.aegis** { *;  }
