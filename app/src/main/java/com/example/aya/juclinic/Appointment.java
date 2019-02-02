package com.example.aya.juclinic;

public class Appointment {
  private   String Appo_id;
  private   String Appo_Department;
  private   String Appo_time;
  private   String Appo_Date;
   // String Stu_Id;

    public Appointment(){}

    public Appointment(String appo_id, String appo_Department, String appo_time, String appo_Date/*, String stu_Id*/) {
        Appo_id = appo_id;
        Appo_Department = appo_Department;
        Appo_time = appo_time;
        Appo_Date = appo_Date;
       // Stu_Id = stu_Id;
    }

    public String  getAppo_id() {
        return Appo_id;
    }

    public String getAppo_Department() {
        return Appo_Department;
    }

    public String getAppo_time() {
        return Appo_time;
    }

    public String getAppo_Date() {
        return Appo_Date;
    }

   /* public String  getStu_Id() {
        return Stu_Id;
    }*/

    public void setAppo_id(String appo_id) {
        Appo_id = appo_id;
    }

    public void setAppo_Department(String appo_Department) {
        Appo_Department = appo_Department;
    }

    public void setAppo_time(String appo_time) {
        Appo_time = appo_time;
    }

    public void setAppo_Date(String appo_Date) {
        Appo_Date = appo_Date;
    }
}
