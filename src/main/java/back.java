import java.util.*;

public class back {
    public static int taskId = 0;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (int i=1; i<=49; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<6; i++) {
            resultList.add(list.get(i));
        }

        Collections.sort(resultList);
        resultList.forEach(integer -> System.out.println(integer));
    }


}
