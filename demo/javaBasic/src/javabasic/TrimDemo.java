package javabasic;


public class TrimDemo {
    public static void show(String str)
    {
        System.out.println(trimspace(str));
    }
    private static String trimspace(String str)
    {
        str = str.replaceAll("\\s+", " ");
        str = str.replaceAll("^\\s+|\\s+$", "");
        return str;
    }   
}
