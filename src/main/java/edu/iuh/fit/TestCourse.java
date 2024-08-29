/*
 * @ (#) TestCourse.java       1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package edu.iuh.fit;
import java.util.Scanner;
/*
 * @description: This class represents a bank with many bank accounts
 * @author: Tuyen,Nguyen Cong
 * @date:    8/29/2024
 * @version:    1.0
 * @created: 29-Aug-2024 4:05:50 PM
 */



public class TestCourse {
    public static void main(String[] args) {
        CourseList cl = new CourseList(10);
        initData(cl);
      /*  System.out.println("khoa co tc cao nhat");
        System.out.println(cl.khoaTcCaoNhat());
        cl.sapXepTheoTenKhoa();
        cl.removeTitle("TA1");
        cl.inDS();*/
        System.out.println("-----------------------MENU-----------------------------");
        System.out.println("1. Them mot khoa hoc");
        System.out.println("2. In danh sach khoa hoc");
        System.out.println("3. Tim khoa hoc theo ma khoa hoc");
        System.out.println("4. Tim khoa hoc theo ten (tim tuong doi)");
        System.out.println("5. Sap xep theo ten khoa hoc khong sap xep tren danh sach goc");
        System.out.println("6. Khoa hoc co so tin chi lon nhat");
        System.out.println("0. THOAT !");
        System.out.println("--------------------------------------------------------");
        System.out.print("\n nhap lua chon: ");
        int luaChon = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                luaChon = sc.nextInt();
            } catch (Exception e) {
                throw new IllegalArgumentException("khong duoc nhap ky tu");
            }
            if (luaChon < 0 || luaChon > 6) {
                throw new IllegalArgumentException("nhap khoang (0, 6)");
            }
            switch (luaChon) {
                case 1:
                    System.out.println("nhap thong tin khoa hoc de them: ");

                    System.out.print("\ncredit: ");
                    int cre = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\ndepartment: ");
                    String depar = sc.nextLine();
                    System.out.print("\nid: ");
                    String id = sc.nextLine();
                    System.out.print("\ntitle: ");
                    String title = sc.nextLine();
                    Course them = new Course(cre, depar, id, title);
                    cl.addCourse(them);
                    break;
                case 2:
                    System.out.print("in danh sach khoa hoc: \n");
                    cl.inDS();
                    break;
                case 3:
                    System.out.print("in danh sach khoa hoc theo ma: ");
                    System.out.print("\n nhap ma de tim: ");
                    sc.nextLine();
                    String idTim = sc.nextLine();
                    System.out.println(cl.findId(idTim));
                    break;
                case 4:
                    System.out.print("\nin danh sach khoa hoc theo ten: ");
                    System.out.print("\nnhap ten de tim: ");
                    sc.nextLine();
                    String idTen = sc.nextLine();
                    System.out.println(cl.timTheoTen(idTen));
                    break;
                case 5:
                    System.out.println("5. Sau khi sap xep theo ten khoa hoc khong sap xep tren danh sach goc");
                    cl.sapXepTheoTenKhoa();
                    break;
                case 6:
                    System.out.println("khao co so tin chi cao nhat la: ");
                    System.out.println( cl.khoaTcCaoNhat());
                    break;
                case 0:
                    System.out.println("thoat chuong trinh!");
                    break;

            }
            System.out.print("\n nhap lua chon: ");
        } while (luaChon >= 0 && luaChon < 7);

    }

    private static void initData(CourseList cl) {
        Course c1 = new Course(3, "fit", "SE12", "Software Engineering");
        Course c2 = new Course(4, "fit", "CS16", "C Programming");
        Course c3 = new Course(5, "fit", "DB06", "Database Systems");
        Course c4 = new Course(2, "kNN", "TA1", "English1");
        Course c5 = new Course(2, "kNN", "TA2", "English2");
        Course c6 = new Course(3, "KHCB", "TCC1", "Math1");

        cl.addCourse(c1);
        cl.addCourse(c2);
        cl.addCourse(c3);
        cl.addCourse(c4);
        cl.addCourse(c5);
        cl.addCourse(c6);
    }
}
