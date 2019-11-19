package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.greendao.R
import com.example.service.entity.User
import com.example.utils.DbUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_save.setOnClickListener {
            val address = et_address.text.trim().toString()
            val age = et_age.text.trim().toString().toInt()
            val grade = et_class.text.trim().toString()
            val name = et_name.text.trim().toString()
            val number = et_number.text.trim().toString().toInt()
            val phone = et_phone.text.trim().toString()
            val schoolName = et_school_name.text.trim().toString()
            val sex = et_sex.text.trim().toString()
            val currentTimeMillis = System.currentTimeMillis()
            val user = User()
//            user.address = address
//            user.age = age
//            user.grade = grade
//            user.name = name
//            user.studentNo = number
//            user.schoolName = schoolName
//            user.sex = sex
//            user.telPhone = phone
            insertUser(user)
        }
        btn_search.setOnClickListener {
            val users = DbUtil.getInstance(this).queryAllUser()
            users.forEach {
                Log.d("TAG","$it")
            }
        }
    }

    private fun insertUser(user: User) {
        DbUtil.getInstance(this).insertOrUpdateUser(user)
    }
}
