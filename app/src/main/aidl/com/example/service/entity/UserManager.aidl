// UserManager.aidl
package com.example.service.entity;
import com.example.service.entity.IUser;
// Declare any non-default types here with import statements

interface UserManager {
    List<User> queryAllUser();
    void insertUser(in User user);
}
