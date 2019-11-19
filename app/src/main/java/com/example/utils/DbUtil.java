package com.example.utils;

import android.content.Context;
import com.example.greendao.dao.DaoMaster;
import com.example.greendao.dao.DaoSession;
import com.example.greendao.dao.UserDao;
import com.example.service.entity.User;
import org.greenrobot.greendao.database.Database;

import java.util.List;

/**
 * Author : JinTao Li
 * Create Time : 2019/9/12
 */
public class DbUtil {
    private static DbUtil dbUtil;
    private final Database encryptedWritableDb;
    private final DaoSession mDaoSession;
    private final UserDao userDao;

    private DbUtil(Context context) {
        DbHelper dbHelper = new DbHelper(context.getApplicationContext(), "user", null);
        encryptedWritableDb = dbHelper.getEncryptedWritableDb("admin");
        DaoMaster mDaoMaster = new DaoMaster(encryptedWritableDb);
        mDaoSession = mDaoMaster.newSession();
        userDao = mDaoSession.getUserDao();
    }

    public static void reset() {
        if (dbUtil != null) {
            dbUtil = null;
        }
    }

    public static DbUtil getInstance(Context context) {
        if (dbUtil == null) {
            synchronized (DbUtil.class) {
                if (dbUtil == null) {
                    dbUtil = new DbUtil(context);
                }
            }
        }
        return dbUtil;
    }

    public synchronized void insertOrUpdateUser(User user) {
        if (user.getId() == null) {
            List<User> list = userDao.queryBuilder().where(UserDao.Properties.StudentNo.eq(user.getStudentNo())).list();
            if (list.size() > 0) {
                user.setId(list.get(0).getId());
            }
        }
        userDao.insertOrReplace(user);
    }

    public List<User> queryAllUser() {
        List<User> list = userDao.queryBuilder().list();
        if (list.size() > 0) {
            return list;
        }
        return null;
    }
}
