package com.itera.pam.myprofile

actual fun getPlatformName(): String = "Desktop JVM ${System.getProperty("java.version")}"
