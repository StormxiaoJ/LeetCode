import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        //List<Integer> a = new ArrayList<>((a,b)-> a-b);
        //Queue<Integer> b = new PriorityQueue<>((d,c) -> d-c);

        int pointNum = Integer.parseInt(br.readLine());
        Point[] pointArray = new Point[pointNum];
        for(int i = 0; i < pointNum; i++){
            String[] input = br.readLine().split(",");
            pointArray[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        List<List<Point>> result = new ArrayList<>();
        List<Point> comb = new ArrayList<>();
        comb.add(new Point(0,0));
        helper(pointArray,result,comb,new boolean[pointNum]);
        //int[] res = new int[result.size()];
        List<Integer> res = new ArrayList<>();
        for(List<Point> list : result){
            list.add(new Point(0,0));
            Point[] array =  list.toArray(new Point[]{});
            int sum = 0;
            for(int i = 1 ; i < array.length; i++){
                sum+= Math.abs(array[i].x - array[i-1].x)+Math.abs(array[i].y-array[i-1].y);
            }
            res.add(sum);
        }
        Integer[] sorted = res.toArray(new Integer[]{});
        int[] last = new int[sorted.length];
        for(int i = 0; i < last.length; i++){
            last[i] = sorted[i].intValue();
        }
        Arrays.sort(last);
        System.out.println(last[0]);
       // Integer[] temp = new Integer[]{new };


    }

    public static void helper(Point[] pointArray,List<List<Point>> result, List<Point> comb, boolean[] visited){
        if(comb.size() == pointArray.length+1){
            //comb.add(new Point(0,0));
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int i = 0 ; i < pointArray.length; i++){
            if(visited[i]){
                continue;
            }
            comb.add(pointArray[i]);
            visited[i] = true;
            helper(pointArray, result, comb, visited);
            comb.remove(comb.size()-1);
            //comb.remove(comb.size()-1);
            visited[i] = false;
        }
    }
}
class Point{
    public int x,y;
    public Point(int x, int y){
        this.x= x;
        this.y = y;
    }

}