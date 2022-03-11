import java.util.*;
import java.io.*;

public class hashcode 
{
    static fastreaderrr sc=new fastreaderrr();
    public static void main(String args[])
    {
        int n=sc.I();
        List<Point> p=new ArrayList<>();
        for(int i=0;i<n;i++){
            p.add(new Point(sc.I(),sc.I()));
        }
        List<Point> sp=sortVerticies(p);
        double x[]=new double[sp.size()];
        double y[]=new double[sp.size()];
        for(int i=0;i<sp.size();i++){
            x[i]=sp.get(i).x;
            y[i]=sp.get(i).y;
        }
        System.out.println((int)polygonArea(x,y,sp.size()));
    }
    public static double polygonArea(double X[], double Y[], int n)
    {
        double area = 0.0;
      
        int j = n - 1;
        for (int i = 0; i < n; i++)
        {
            area += (X[j] + X[i]) * (Y[j] - Y[i]);
            j = i; 
        }
      
        return Math.abs(area / 2.0);
    }
    public static class Point
    {
        int x,y;
        public Point(int a,int b)
        {
            x=a;
            y=b;
        }
    }
    public static Point findCentroid(List<Point> points) 
    {
        int x = 0;
        int y = 0;
        for (Point p : points) {
            x += p.x;
            y += p.y;
        }
        Point center = new Point(0, 0);
        center.x = x / points.size();
        center.y = y / points.size();
        return center;
    }
    public static List<Point> sortVerticies(List<Point> points) 
    {
        // get centroid
        Point center = findCentroid(points);
        Collections.sort(points, (a, b) -> {
            double a1 = (Math.toDegrees(Math.atan2(a.x - center.x, a.y - center.y)) + 360) % 360;
            double a2 = (Math.toDegrees(Math.atan2(b.x - center.x, b.y - center.y)) + 360) % 360;
            return (int) (a1 - a2);
        });
        return points;
    }
}
class fastreaderrr {  
    BufferedReader br;
    StringTokenizer st;
    public fastreaderrr(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        while (st == null || !st.hasMoreElements()){
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int I(){ return Integer.parseInt(next());}
    long L(){ return Long.parseLong(next());}
    double D(){return Double.parseDouble(next());}
    String S(){
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }
}

