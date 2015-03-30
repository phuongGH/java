/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javabasic;

/**
 *
 * @author AA
 */
public class StringBuliderDemo {
    public void show()
    {
        StringBuilder a = new StringBuilder("Hello");
        StringBuilder b = new StringBuilder("Hello World");
        b = a;
        a.append("Java");
        System.out.println(b);
    }
}
