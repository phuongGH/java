/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceclass;


public class Student {

    private String name;

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

    public University getUsniversity() {
        return usniversity;
    }

    public void setUsniversity(University usniversity) {
        this.usniversity = usniversity;
    }
    private int point;
    private University usniversity;
    
    public void displayName(){
        System.out.println(name + " gets " + usniversity.calculatePoint(point));
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("student 1");
        s1.setPoint(55);
        s1.setUsniversity(new UniversityB());
        s1.displayName();
    }
    
}
