package com.example.jnitest;

/**
 * 
 * @author yezi
 * 
 */
public class JniLib {

	/**
	 * java调用jni内部方法
	 * 
	 * @return JniInfo
	 */
	public static native JniInfo getInfo();

	// 加载.so
	static {
		System.loadLibrary("jniTest");
	}
}
