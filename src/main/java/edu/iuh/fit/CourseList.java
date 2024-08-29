/*
 * @ (#) CourseList.java       1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package edu.iuh.fit;
import java.util.*;
/*
 * @description: This class represents a bank with many bank accounts
 * @author: Tuyen,Nguyen Cong
 * @date:    8/29/2024
 * @version:    1.0
 * @created: 29-Aug-2024 4:05:50 PM
 */



public class CourseList {
    private Course[] courses;
    private int count = 0;

    public CourseList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Length of array must be greater than 0");
        }
        courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }

    public boolean addCourse(Course course) {
        if (courses == null) {
            return false;
        }
        if (isExists(course)) {
            return false;
        }
        if (count == courses.length) {
            return false;
        }
        courses[count++] = course;
        return true;
    }

    public void inDS() {
        System.out.printf("%-10s%-30s%-10s%-20s\n", "ID", "Title", "Credit", "Department");
        for (Course c : this.courses) {
            if (c != null) {
                System.out.printf("%-10s%-30s%-10d%-20s\n", c.getId(), c.getTitle(), c.getCredit(), c.getDepartment());
            }
        }
    }

    private boolean isExists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId())) {
                return true;
            }
        }
        return false;
    }

    public void courseList() {
        System.out.println("----------------------Course List-----------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println(courses[i].getTitle());
        }
    }

    public void removeTitle(String id) {
        boolean kt = false;
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                kt = true;
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[count - 1] = null;
                count--;
                System.out.println("Course with ID " + id + " has been removed.");
                break;
            }
        }

        if (!kt) {
            System.out.println("Course with ID " + id + " does not exist.");
        }
    }


    public String findId(String maTim) {
        maTim.toLowerCase();
        for (int i = 0; i < count; i++) {
            courses[i].getId().toLowerCase();
            if (courses[i].getId().equals(maTim)) {
                return courses[i].getTitle();
            }
        }
        return null;
    }

    public String timTheoTen(String tenTim){
        tenTim.toLowerCase();
        for(int i=0; i< count; i++){
            courses[i].getTitle().toLowerCase();
            if(courses[i].getTitle().equals(tenTim)){
                System.out.printf("%-10s%-30s%-10s%-20s\n", "ID", "Title", "Credit", "Department");
                return courses[i].toString();
            }
        }
        return null;
    }

    public void sapXepTheoTenKhoa() {

        Course[] tmp = Arrays.copyOfRange(courses, 0, count);

        int len = tmp.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (tmp[i].getTitle().compareTo(tmp[j].getTitle()) > 0) {
                    Course temp = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = temp;
                }
            }
        }
        System.out.println("sau khi sap xep theo ten khoa hoc");
        for (Course c : tmp) {
            if (c != null) {
                System.out.printf("%-10s%-30s%-10d%-20s\n", c.getId(), c.getTitle(), c.getCredit(), c.getDepartment());
            }
        }

    }

    public String khoaTcCaoNhat() {
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() > max) {
                max = i;
            }
        }
        System.out.printf("%-10s%-30s%-10s%-20s\n", "ID", "Title", "Credit", "Department");
        return this.courses[max].toString();
    }



}