import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Interview2 {

    static class Pair{
        int i , j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }


    public static void main(String[] args) {
        

        int [] arr = {3, 4, 7, 1, 2, 9, 8};
        int n = arr.length;
        Map<Integer, List<Pair>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            for(int j = i +1 ; j < n; j++){
                int sum = arr[i] + arr[j];
                map.computeIfAbsent(sum , k -> new ArrayList<>()).add(new Pair(i, j));
            }
        }

        for(Map.Entry<Integer, List<Pair>> entry : map.entrySet()){
            List<Pair> pairs = entry.getValue();

            for(Pair p : pairs){
                System.out.print(arr[p.i] + " ," + arr[p.j]);
                System.out.print(" ");
            }

                    System.out.println();

        }


        for( int sum : map.keySet()){
            List<Pair> pairs = map.get(sum);

            


        //     for(int i = 0; i < pairs.size(); i++){
        //         for(int j = i+1; j < pairs.size(); j++){
        //         Pair p1 = pairs.get(i);
        //         Pair p2 = pairs.get(j);
                
        //          if(p1.i )
        //         System.out.println(arr [p1.i] + " ," + arr[p1.j]);
        //     }
        // }

            // System.out.println();
        }

    }
}
