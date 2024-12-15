package cn.cetc28.leetcode;

import java.util.HashSet;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/10 21:13
 * 036 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class Test1210a {

    public static void main(String[] args) {

        Test1210a t = new Test1210a();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        boolean res = t.isValidSudoku(board);
        System.out.println(res);

    }

    public boolean isValidSudoku(char[][] board) {

        int len = board.length;
        // 验证行
        for(int i=0;i<len;i++){
            int size = 0;
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<len;j++){
                if(board[i][j]!='.'){
                    size++;
                    set.add(board[i][j]);
                }
            }
            if(set.size()!=size){
//                System.out.println("第"+i+"行有问题");
                return false;
            }
        }
        // 验证列
        for(int i=0;i<len;i++){
            int size = 0;
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<len;j++){
                if(board[j][i]!='.'){
                    size++;
                    set.add(board[j][i]);
                }
            }
            if(set.size()!=size){
//                System.out.println("第"+i+"列有问题");
                return false;
            }
        }
        // 验证九宫格
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int x = 0;
                int y = 0;
                int size = 0;
                HashSet<Character> set = new HashSet<>();
                for(int k=0;k<9;k++){
                    x = i*3+k/3;
                    y = j*3+k%3;
                    if(board[x][y]!='.'){
                        size++;
                        set.add(board[x][y]);
                    }
                }
                if(set.size()!=size){
//                    System.out.println("第"+i+","+j+"个小九宫格有问题");
                    return false;
                }
            }
        }
        return true;
    }
}
