/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class backend_ColumnStoreCBackend */

#ifndef _Included_backend_ColumnStoreCBackend
#define _Included_backend_ColumnStoreCBackend
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     reset0
 * Signature:  ()V
 */
JNIEXPORT void JNICALL Java_backend_ColumnStoreCBackend_reset0
  (JNIEnv *, jobject);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     cuboidGC0
 * Signature:  (I)V
 */
JNIEXPORT void JNICALL Java_backend_ColumnStoreCBackend_cuboidGC0
  (JNIEnv *, jobject, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     sRehash0
 * Signature:  (I[II)I
 */
JNIEXPORT jint JNICALL Java_backend_ColumnStoreCBackend_sRehash0
  (JNIEnv *, jobject, jint, jintArray, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     dRehash0
 * Signature:  (I[I)I
 */
JNIEXPORT jint JNICALL Java_backend_ColumnStoreCBackend_dRehash0
  (JNIEnv *, jobject, jint, jintArray);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     dFetch0
 * Signature:  (I)[J
 */
JNIEXPORT jlongArray JNICALL Java_backend_ColumnStoreCBackend_dFetch0
  (JNIEnv *, jobject, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     sFetch640
 * Signature:  (IILjava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_backend_ColumnStoreCBackend_sFetch640
  (JNIEnv *, jobject, jint, jint, jobject);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     sSize0
 * Signature:  (I)I
 */
JNIEXPORT jint JNICALL Java_backend_ColumnStoreCBackend_sSize0
  (JNIEnv *, jobject, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     sNumBytes0
 * Signature:  (I)J
 */
JNIEXPORT jlong JNICALL Java_backend_ColumnStoreCBackend_sNumBytes0
  (JNIEnv *, jobject, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     mkAll0
 * Signature:  (II)I
 */
JNIEXPORT jint JNICALL Java_backend_ColumnStoreCBackend_mkAll0
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     add_1i
 * Signature:  (IIIILjava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_backend_ColumnStoreCBackend_add_1i
  (JNIEnv *, jobject, jint, jint, jint, jint, jobject);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     freezeMkAll
 * Signature:  (I)V
 */
JNIEXPORT void JNICALL Java_backend_ColumnStoreCBackend_freezeMkAll
  (JNIEnv *, jobject, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     mk0
 * Signature:  (I)I
 */
JNIEXPORT jint JNICALL Java_backend_ColumnStoreCBackend_mk0
  (JNIEnv *, jobject, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     add
 * Signature:  (IIILjava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_backend_ColumnStoreCBackend_add
  (JNIEnv *, jobject, jint, jint, jint, jobject);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     freeze
 * Signature:  (I)V
 */
JNIEXPORT void JNICALL Java_backend_ColumnStoreCBackend_freeze
  (JNIEnv *, jobject, jint);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     readMultiCuboid0
 * Signature:  (Ljava/lang/String;[Z[I[I)[I
 */
JNIEXPORT jintArray JNICALL Java_backend_ColumnStoreCBackend_readMultiCuboid0
  (JNIEnv *, jobject, jstring, jbooleanArray, jintArray, jintArray);

/*
 * Class:      backend_ColumnStoreCBackend
 * Method:     writeMultiCuboid0
 * Signature:  (Ljava/lang/String;[Z[I)V
 */
JNIEXPORT void JNICALL Java_backend_ColumnStoreCBackend_writeMultiCuboid0
  (JNIEnv *, jobject, jstring, jbooleanArray, jintArray);

#ifdef __cplusplus
}
#endif
#endif
