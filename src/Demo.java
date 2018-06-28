import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        CoinChange.table = new HashMap<>();
        int n = Integer.parseInt(s.nextLine());
        List<String> li = Arrays.asList(s.nextLine().split(" "));
        List<Integer> weight = li.stream().map( i -> Integer.parseInt(i)).collect(Collectors.toList());
        List<String> val = Arrays.asList(s.nextLine().split(" "));
        List<Integer> value = val.stream().map( i -> Integer.parseInt(i)).collect(Collectors.toList());
//        System.out.println(CoinChange.bruteForce(lout,n));
        BinaryKnapsack bn = new BinaryKnapsack(n,weight.size());
        System.out.println(bn.memoized(weight,value,n,0));
    }
}
