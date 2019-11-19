package com.example.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.greendao.dao.DaoMaster
import com.example.greendao.dao.UserDao
import org.greenrobot.greendao.database.Database

/**
 *  Author : JinTao Li
 *  Create Time : 2019/10/22
 */
class DbHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?) : DaoMaster.OpenHelper(context, name, factory) {
    override fun onUpgrade(db: Database?, oldVersion: Int, newVersion: Int) {
        MigrationHelper.migrate(db,UserDao::class.java)
    }
}