#include <com_example_jnitest_JniLib.h>
#include <jni.h>
#include <stdlib.h>
#include <stdio.h>
JNIEXPORT jobject JNICALL Java_com_example_jnitest_JniLib_getInfo(JNIEnv *env,
		jclass clazz) {
	jclass claz = (*env)->FindClass(env, "com/example/jnitest/JniInfo");
	jmethodID mid = (*env)->GetMethodID(env, claz, "<init>", "()V");
	jobject result = (*env)->NewObject(env, claz, mid);
	return result;
}
