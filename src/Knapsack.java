import java.util.Scanner;

public class Knapsack {

        static int max=0;
        static int[][] table;

        // Complete the unboundedKnapsack function below.
        static int unboundedKnapsack(int k, int[] arr) {
            table = new int[k+1][arr.length+1];
            memoized(arr,k,0);
            return max;

        }

        public static int memoized(int[] w,int k,int index) {


            if(index==w.length){
                return 0;
            }

            if (table[k][index] == 0) {
                int hj=0;
                if(k==0){
                    return 0;
                }
                if(k-w[index]>=0){
                    hj = Math.max(w[index]+memoized(w,k-w[index],index),memoized(w,k,index+1));
                    table[k][index]= hj;
                    max = Math.max(max,hj);
                }


//            System.out.println(weight+" "+index+" Value is: "+res);
                return hj;
            }
            else{
                return table[k][index];
            }
        }


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        Scanner scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int t = scanner.nextInt();
        for(int looper =0;looper<t;looper++){

            scanner = new Scanner(System.in);
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = unboundedKnapsack(k, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
            System.out.println(result);
        }
    }


}
