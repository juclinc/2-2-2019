package com.example.aya.juclinic;

public class Student {
    String Stu_id;
    String Stu_name;
    String Stu_Colleage;
    String Stu_major;

    public Student(){}

    public Student(String stu_id, String stu_name, String stu_Colleage, String stu_major) {
        Stu_id = stu_id;
        Stu_name = stu_name;
        Stu_Colleage = stu_Colleage;
        Stu_major = stu_major;
    }

    public String  getStu_id() {
        return Stu_id;
    }

    public String getStu_name() {
        return Stu_name;
    }

    public String getStu_Colleage() {
        return Stu_Colleage;
    }

    public String getStu_major() {
        return Stu_major;
    }
}
