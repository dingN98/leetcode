package cn.njust.leetcode.QiuZhao.QiAnXin0825;

public class Exam1 {

    int res = 0;

    public int DagvisitedNum (int[][] nodes) {
        boolean[][] visited = new boolean[5][5];
//        for(int i=0;i<nodes.length;i++){
//            for(int j=0;j<nodes[i].length;j++){
//                visited[i][nodes[i][j]] = 1;
//            }
//            System.out.println();
//        }
//        for(int i=0;i<visited.length;i++){
//            for(int j=0;j<visited[i].length;j++){
//                System.out.print(visited[i][j]+" ");
//            }
//            System.out.println();
//        }
        search(nodes,0,visited);

        return res;
    }

    public void search(int[][] nodes,int start,boolean[][] visited){
        if(start==4){
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
        nodes[1] = new int[]{3};
        nodes[2] = new int[]{3};
        nodes[3] = new int[]{4};
        nodes[4] = new int[]{};
        int res = new Exam1().DagvisitedNum(nodes);
        System.out.println(res);




    }
}
