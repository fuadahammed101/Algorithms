package com.mycompany.studentsort;

import java.util.*;

class Student {
    int student_id;
    String name;
    double GPA;

    public Student(int student_id, String name, double GPA) {
        this.student_id = student_id;
        this.name = name;
        this.GPA = GPA;
    }
}

public class StudentSort {

    public static void main(String[] args) {
    
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(278, "Fuad", 2.8));
        studentList.add(new Student(276, "Wasif", 3.5));
        studentList.add(new Student(276, "Fahim", 3.9));
        studentList.add(new Student(352, "Tawhid", 3.2));
        studentList.add(new Student(252, "Emon", 3.7));

        
        mergeSort(studentList, 0, studentList.size() - 1);

        
        System.out.println("Sorted Student List (based on GPA):");
        for (Student student : studentList) {
            System.out.println("ID: " + student.student_id + ", Name: " + student.name + ", GPA: " + student.GPA);
        }

        
        Student highestGPAStudent = findHighestGPAStudent(studentList);
        System.out.println("\nStudent with the Highest GPA:");
        System.out.println("ID: " + highestGPAStudent.student_id + ", Name: " + highestGPAStudent.name + ", GPA: " + highestGPAStudent.GPA);
    }

    private static void mergeSort(List<Student> studentList, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(studentList, left, mid);
            mergeSort(studentList, mid + 1, right);

            merge(studentList, left, mid, right);
        }
    }

    private static void merge(List<Student> studentList, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Student> leftList = new ArrayList<>(studentList.subList(left, mid + 1));
        List<Student> rightList = new ArrayList<>(studentList.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftList.get(i).GPA <= rightList.get(j).GPA) {
                studentList.set(k, leftList.get(i));
                i++;
            } else {
                studentList.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            studentList.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            studentList.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    private static Student findHighestGPAStudent(List<Student> studentList) {
        if (studentList.isEmpty()) {
            return null;
        }

        return studentList.get(studentList.size() - 1);
    }
}

