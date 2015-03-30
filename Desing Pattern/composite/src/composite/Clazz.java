package composite;

import java.util.ArrayList;
import java.util.Random;

public class Clazz implements Education{
    //composite
    ArrayList<student> students = new ArrayList<student>();

    public Clazz() {
        for (int i = 0; i < 10; i++) {
            students.add(new student(new Random().nextFloat(), new Random().nextFloat()));
        }
    }

    
    @Override
    public float calculatePoint() {
        float sum = 0;
        for(student s: students){
            sum += s.calculatePoint();
        }
        return sum/students.size();
    }
}
