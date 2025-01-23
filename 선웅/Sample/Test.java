
public class Test {
    public static void main(String[] args) {
        int a = 10;
        int[] arr = new int[4];
        int[][] arr2 = new int[2][3];
        int[][] arr3 = new int[2][];
        arr3[0] = new int[3];
        arr3[1][1] = 100;
        System.out.println(arr3[1][1]);
    }
}
