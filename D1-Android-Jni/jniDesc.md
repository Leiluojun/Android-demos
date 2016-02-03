#1.新建native方法
#2.新建jni目录
#3.编译native类生成class
#4.通过class文件生成h文件
##1）打开bin/classes目录
javah -classpath . -jni com.example.jnitest.JniLib 
##2)将com_example_jnitest_JniLib.h头文件移动到jni目录
#5.新建Android.mk文件
##1）LOCAL_PATH：在开发树中查找源文件
##2）LOCAL_SRC_FILES：需要打包进去的源文件，不用包含头文件
##3）LOCAL_MODULE：用来生成的lib名称
##4）LOCAL_CFLAGS += -fvisibility：导不导出函数符号表
##5）APP_ABI：内核
#6.ndk-buid生成so
ndk-build APP_ABI="armeabi armeabi-v7a x86 mips"
