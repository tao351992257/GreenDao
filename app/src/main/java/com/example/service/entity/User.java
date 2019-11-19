package com.example.service.entity;

import android.os.Parcel;
import android.os.Parcelable;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author : JinTao Li
 * Create Time : 2019/9/12
 */
@Entity(nameInDb = "T_User")
public class User implements Parcelable {
    @Id(autoincrement = true)
    Long id;
    int studentNo;
    int age;
    String telPhone;
    String sex;
    String name;
    String address;
    String schoolName;
    String grade;
    Long createTime;
    @Generated(hash = 994244977)
    public User(Long id, int studentNo, int age, String telPhone, String sex,
            String name, String address, String schoolName, String grade,
            Long createTime) {
        this.id = id;
        this.studentNo = studentNo;
        this.age = age;
        this.telPhone = telPhone;
        this.sex = sex;
        this.name = name;
        this.address = address;
        this.schoolName = schoolName;
        this.grade = grade;
        this.createTime = createTime;
    }
    @Generated(hash = 586692638)
    public User() {
    }

    protected User(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        studentNo = in.readInt();
        age = in.readInt();
        telPhone = in.readString();
        sex = in.readString();
        name = in.readString();
        address = in.readString();
        schoolName = in.readString();
        grade = in.readString();
        if (in.readByte() == 0) {
            createTime = null;
        } else {
            createTime = in.readLong();
        }
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getStudentNo() {
        return this.studentNo;
    }
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getTelPhone() {
        return this.telPhone;
    }
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSchoolName() {
        return this.schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getGrade() {
        return this.grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Long getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeInt(studentNo);
        parcel.writeInt(age);
        parcel.writeString(telPhone);
        parcel.writeString(sex);
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(schoolName);
        parcel.writeString(grade);
        if (createTime == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(createTime);
        }
    }
}
