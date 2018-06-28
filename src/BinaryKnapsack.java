import java.util.ArrayList;
import java.util.List;

public class BinaryKnapsack {

    static int[][] table;

    public BinaryKnapsack(int weight, int index){
        table = new int[weight+1][index];
    }

    public static List<Item> formList(List<Integer> w, List<Integer> v){
        List<Item> li = new ArrayList<>();
        for(int i=0;i<w.size();i++){
            Item a = new Item();
            a.weight=w.get(i);
            a.value=v.get(i);
            li.add(a);
        }
        return li;
    }

    public static int memoized(List<Integer> w, List<Integer> v,int weight,int index) {

//        System.out.println(weight+" "+index+v.get(index));

        List<Item> list = formList(w,v);

        if(weight<0){
            return 0;
        }


        if (index == list.size()) {
            return 0;
        }

        if (weight == 0) {
            return 0;
        }



        if (table[weight][index] == 0) {


            int res = Math.max(list.get(index).value + memoized(w,v, weight - list.get(index).weight, index + 1), memoized(w,v, weight, index + 1));
            table[weight][index]= res;
//            System.out.println(weight+" "+index+" Value is: "+res);
            return res;
        }
        else{
            return table[weight][index];
        }
    }


}

class Item{
    public int weight;
    public int value;
}
