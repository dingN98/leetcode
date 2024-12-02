package cn.njust.leetcode.QiuZhao.QiAnXin0825;

public class Exam1_2 {

    int res = 0;

    public int DagvisitedNum (int[][] nodes) {
        int len = nodes.length;
        boolean[][] visited = new boolean[len][len];
        search(nodes,0,visited);
        return res;
    }

    public void search(int[][] nodes,int start,boolean[][] visited){
        int len = nodes.length;
        if(start==len-1){
            res++;
            return;
        }
        for(int i=0;i<nodes[start].length;i++){
            int end = nodes[start][i];
            if(visited[start][end]){
                continue;
            }
            visited[start][end] = true;
            search(nodes,end,visited);
            visited[start][end] = false;
        }
    }
    public static void main(String[] args) {

        int[][] nodes = new int[5][5];
        nodes[0] = new int[]{1,2,3};
        nodes[1] = new int[]{2,3};
        nodes[2] = new int[]{3};
        nodes[3] = new int[]{4};
        nodes[4] = new int[]{};
        int res = new Exam1_2().DagvisitedNum(nodes);
        System.out.println(res);
    }
}
