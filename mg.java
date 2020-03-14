import java.util.*;
public class mg {
    static int[][] migong;
    static int n;//矩阵大小
    static int m;//最短步长
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = n*n;
        migong = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                migong[i][j] = sc.nextInt();
        recursion(1, 1, 0);//起始点为（1，1），初始步长为0
        if(m==n*n)
            System.out.println("No solution");
        else
            System.out.println(m);
    }
    public static void recursion(int x, int y, int count) {
        if(x==n-2 && y==n-2)//跳出条件，走到[n-2][n-2]位置即为终点
            m = Math.min(count, m);
        else {
            migong[x][y]=1;//走过的位置不能重复走，故而走过就设为1（障碍物）

            if(x>1 && migong[x-1][y]==0) {
                recursion(x - 1, y, count + 1);             //上
            }
            if(x<n-1 && migong[x+1][y]==0) {
                recursion(x + 1, y, count + 1);            //下
            }
            if(y>1 && migong[x][y-1]==0) {
                recursion(x, y-1, count+1);			//左
            }
            if(y<n-1 && migong[x][y+1]==0) {
                recursion(x, y+1, count+1);			//右
            }
            migong[x][y]=0;//即从该处相邻地方出发没有找到完整路径，所以将之前走过的这条路径状态恢复
        }
    }

}
