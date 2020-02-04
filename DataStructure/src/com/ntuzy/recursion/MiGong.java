package com.ntuzy.recursion;

/**
 * @Author IamZY
 * @create 2020/2/4 10:27
 */
public class MiGong {
    public static void main(String[] args) {

        int[][] map = new int[8][7];

        // 使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 挡板
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println();
        // 输出新的地图 走过并标识过的地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * map[i][j] 1 表示 墙 2表示可以走 3表示该点已经走过 但是走不通
     * 在走迷宫时 需要确定一个策略 下->右->上->左
     *
     * @param map 表示地图
     * @param i   从那个位置开始找
     * @param j
     * @return 如果周到通路
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            // 当前节点没有做过
            if (map[i][j] == 0) {
                // 假设该店可以走
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 当map[i][j] != 0时 map[i][j] 为1 2 3
                return false;
            }
        }
    }


}
