package view.manipulation;

import view.ProductSelect;

public class ManipulationMessage{
    public static void turnonMessage(String productName) {
        System.out.printf("*%s 전원 ON*\n",productName);
    }
    public static void turnoffMessage(String productName){
        System.out.printf("*%s 전원 OFF*\n",productName);
    }
    public static  void volumupMessage(String productName){
        System.out.printf("*%s volum +1*\n",productName);
    }
    public static  void volumdownMessage(String productName){
        System.out.printf("*%s volum -1*\n",productName);
    }
}
