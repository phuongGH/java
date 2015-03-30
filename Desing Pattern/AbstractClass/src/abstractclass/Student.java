/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstractclass;

/**
 *
 * @author AA
 */
public class Student {

    private String name;
    private int point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    private School school;
            
     public void displayName(){
        System.out.println(name + " gets " + school.calculatePoint(point));
        school.displayNote();
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("student 1");
        s1.setPoint(55);
        s1.setSchool(new SchoolA());
        s1.displayName();
    }
    
}
