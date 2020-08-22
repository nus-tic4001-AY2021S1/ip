import java.util.*;

public class Paser {
    private String[] ls;
    private int arrSize;
    private int actualSize;
    public Paser(String[] ls,int arrSize){
        this.ls = ls;
        this.arrSize=arrSize;
    }
    public void storeInArray(String str,int index) {
        ls[index]=str;
        this.actualSize=index+1;
    }
    public void printArray(){
        System.out.println("-----------");
        for (int i = 0;i<actualSize;i++){
            System.out.println((i+1)+"."+ ls[i]);
        }
        System.out.println("-----------");
    }
}