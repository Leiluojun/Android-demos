LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE:= jniTest
LOCAL_SRC_FILES := jniTest.c
OPENCV_CAMERA_MODULES:=off 
LOCAL_CFLAGS += -fvisibility=hidden
APP_ABI := armeabi armeabi-v7a x86
include $(BUILD_SHARED_LIBRARY)
