package cn.njust.leetcode.QiuZhao.AboveAll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        //树节点及其方法
        class Treenode {
            int value;
            Treenode lchild = null;
            Treenode rchild = null;

            public Treenode(int value) {
                this.value = value;
            }
            //计算带权路径长度，采用递归的方法，level代表层数，初始为0
            //递归计算部分不怎么好理解，可以自己画图试试看
            public int haffman(int level, int sum) {
                //当左子树和右子树为空时，则表示为哈夫曼树的叶子结点
                if (lchild == null && rchild == null) {
                    sum += level * value;
                    return sum;
                }
                //否则不为空时，分别遍历左子树和右子树
                sum = lchild.haffman(level + 1, sum);
                sum = rchild.haffman(level + 1, sum);
                return sum;
            }
        }

        //构建一个链表
        List<Treenode> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //告诉程序有几个数需要输入
        int value = sc.nextInt();
        System.out.println("get it");
        for (int i = 0; i < value; i++) {
            Treenode node = new Treenode(sc.nextInt());
            list.add(node);
            System.out.println("ok");
        }
        //对线性表进行排序
        list.sort(new Comparator<Treenode>() {
            @Override
            public int compare(Treenode o1, Treenode o2) {
                if (o1.value >= o2.value) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        //当链表的长度大于1的时候，构建哈夫曼树
        while (list.size() > 1) {
            Treenode temp = new Treenode(list.get(0).value + list.get(1).value);
            temp.lchild = list.get(0);
            temp.rchild = list.get(1);
            list.remove(0);
            list.remove(0);
            list.add(temp);
            //插入新结点后，对线性表重新排序
            list.sort(new Comparator<Treenode>() {
                @Override
                public int compare(Treenode o1, Treenode o2) {
                    if (o1.value >= o2.value) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }
        //链表的第一个节点即为哈夫曼树的根节点
        Treenode t = list.get(0);
        //计算带权路径长度
        int sum = t.haffman(0, 0);
        System.out.println(sum);
    }
}

