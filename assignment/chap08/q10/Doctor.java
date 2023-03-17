package assignment.chap08.q10;

import java.util.Objects;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double salary;

    public Doctor(String name, int age, String job, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //判断是否同一对象
        if (o == null || getClass() != o.getClass()) return false; //判断是否同类型 写法1
//        if (!(o instanceof Doctor)) return false; //判断是否同类型 写法2
        Doctor doctor = (Doctor) o;
        return age == doctor.age && gender == doctor.gender && Double.compare(doctor.salary, salary) == 0 && Objects.equals(name, doctor.name) && Objects.equals(job, doctor.job);
    }
}
