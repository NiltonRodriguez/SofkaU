package co.com.sofka.util;

public class Utilities {
    public static String getUserDir(){
        return System.getProperty("user.dir");
    }

    public static String defineOS(){
        return System.getProperty("os.name");
    }
}
