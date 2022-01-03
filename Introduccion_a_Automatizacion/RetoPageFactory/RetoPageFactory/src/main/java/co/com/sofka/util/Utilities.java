package co.com.sofka.util;

import java.util.Random;

public class Utilities {

    private Utilities() {
    }

    public static String getUserDir(){
        return System.getProperty("user.dir");
    }

    public static String defineOS(){
        return System.getProperty("os.name");
    }

    public static String osPathModify(String os, String path){
        if(os.contains("Mac OS") && path.contains("\\")){
            return path.replace("\\", "/");
        } else if (os.contains("Windows") && path.contains("/")){
            return path.replace("/", "\\");
        }
        return path;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
