import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoinChange {

    public static Map<String, Integer> table;


    public static int min(List<Integer> li){

        int m = Integer.MAX_VALUE;
        for(int a: li){
            if (a<m){
                m=a;
            }
        }
        return m;
    }

    public static int bruteForce(List<Integer> coins, int c){

        if(c==0){
            return 1;
        }

        if(c<0){
            return 0;
        }

        if(coins.size()==0){
            return 0;
        }
        else{
            List<Integer> takenInto = new ArrayList<>(coins);
            coins.remove(coins.size()-1);
            return bruteForce(coins,c)+bruteForce(takenInto,c-takenInto.get(takenInto.size()-1));
        }
    }

    public static int memoized(List<Integer> coins, int c){

        String key = coins.size()+","+c;
        if(c==0){
            return 1;
        }

        if(c<0){
            return 0;
        }

        if(coins.size()==0){
            return 0;
        }

        else if(table.containsKey(key)){
            return table.get(key);
        }
        else{
            List<Integer> takenInto = new ArrayList<>(coins);
            coins.remove(coins.size()-1);
            int res = memoized(coins,c)+memoized(takenInto,c-takenInto.get(takenInto.size()-1));
//            System.out.println(res);
            table.put(key,res);
            return res;
        }
    }

    public static int bottomUp(List<Integer> li, int c){
        int[][] table = new int[li.size()][c+1];
        for(int i=0;i<li.size();i++){
            table[i][0] = 1;
        }

        for(int i=0;i<li.size();i++){
            for(int j=1;j<c+1;j++){
                int x = (j-li.get(i)>=0)?table[i][j-li.get(i)]:0;
                int y = (i>0)?table[i-1][j]:0;
                table[i][j]=x+y;
            }
        }

        return table[li.size()-1][c];



    }



}
