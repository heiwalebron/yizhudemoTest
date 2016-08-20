package com.example.administrator.yizhudemo.beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class Doc_Nur implements Serializable {
    private int id;
    private String Name;
    private String Gender;
    private String Occupation;
    private String Department;
    private String Mobile;
    private String Job_History;
    private String Education;
    private String Description;

    public Doc_Nur(String name, String mobile) {
        Name = name;
        Mobile = mobile;
    }

    public Doc_Nur(int id, String name, String mobile) {
        this.id = id;
        Name = name;
        Mobile = mobile;
    }

    public Doc_Nur(int id, String name, String gender,
                   String occupation, String department,
                   String mobile, String job_History,
                   String education, String description) {
        this.id = id;
        Name = name;
        Gender = gender;
        Occupation = occupation;
        Department = department;
        Mobile = mobile;
        Job_History = job_History;
        Education = education;
        Description = description;
    }

    public Doc_Nur(String gender, String name,
                   String occupation, String department,
                   String mobile, String job_History,
                   String education, String description) {
        Gender = gender;
        Name = name;
        Occupation = occupation;
        Department = department;
        Mobile = mobile;
        Job_History = job_History;
        Education = education;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getJob_History() {
        return Job_History;
    }

    public void setJob_History(String job_History) {
        Job_History = job_History;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}