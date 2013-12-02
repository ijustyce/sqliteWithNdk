LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := Safe
LOCAL_SRC_FILES := Safe.cpp \
              sqlite3.c
LOCAL_LDLIBS := -llog
include $(BUILD_SHARED_LIBRARY)
