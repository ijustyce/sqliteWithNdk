/*
 * Safe.cpp
 *
 *  Created on: 2013-12-2
 *      Author: yc
 */

#include <jni.h>
#include <sqlite3.h>
#include <stdlib.h>

jstring runSql(JNIEnv* env, char const *sql, jstring filePath);

jstring runSql(JNIEnv* env, char const *sql, jstring filePath) {

	sqlite3 *db;
	char const *file = env->GetStringUTFChars(filePath, 0);
	if (sqlite3_open(file, &db) == SQLITE_OK) {

	}

	jstring result = env->NewStringUTF("操作成功！");

	if (sqlite3_exec(db, sql, NULL, NULL, NULL) != SQLITE_OK) {

		result = env->NewStringUTF(sql);
	}
	sqlite3_close(db);
	return result;
}

extern "C" {

jstring Java_com_ijustyce_safe_MainActivity_runSql(JNIEnv* env, jobject thiz,
		jstring sql, jstring filePath);

}
;

jstring Java_com_ijustyce_safe_MainActivity_runSql(JNIEnv* env, jobject thiz,
		jstring sql, jstring filePath) {

	char const *mysql = env->GetStringUTFChars(sql, 0);
	return runSql(env, mysql, filePath);
}
