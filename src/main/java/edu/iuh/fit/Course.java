/*
 * @ (#) Course.java       1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package edu.iuh.fit;

/*
 * @description: This class represents a bank with many bank accounts
 * @author: Tuyen,Nguyen Cong
 * @date:    8/29/2024
 * @version:    1.0
 * @created: 29-Aug-2024 4:05:50 PM
 */

public class Course {
    private int credit;
    private String department,id, title;


    public Course(int credit, String department, String id, String title) {
        this.credit = credit;
        this.department = department;
        this.id = id;
        this.title = title;
    }

    public Course() {
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(this.id != null) throw new IllegalArgumentException("id cannot be changed");
        if (id == null || id.trim().length() < 3) {
            throw new IllegalArgumentException("ID must have at least 3 characters");
        }
        int len = id.length();
        for (int i = 0; i < len; i++) {
            char ch = id.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                throw new IllegalArgumentException("ID must contain only letters and numbers");
            }
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%-10d%-20s", id, title, credit, department);
    }
}
