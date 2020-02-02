package com.ntuzy.sparseArray;

import java.io.*;

/**
 * @Author IamZY
 * @create 2020/2/2 10:27
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {

        // 先创建原始二维数组
        // 0 表示没有棋子 1 表示黑子  2 表示篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;

        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转稀疏数组
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        System.out.println(sum);

        // 創建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 遍历二维数组将值存入稀疏数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("============= 稀疏数组 ================");
        
        // 输出稀疏数组
        for(int[] row : sparseArr) {
            for(int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        File file = new File("D:/1.txt");
        FileOutputStream fos = new FileOutputStream(file);
        for(int[] row : sparseArr) {
            String str = "";
            for(int data : row) {
               str += data + "\t";
            }
            fos.write(str.getBytes());
            fos.write("\r\n".getBytes());
            fos.flush();
        }

        fos.close();



        // 稀疏数组恢复原始二维数组

        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 输出恢复后的二维数组
        System.out.println("恢复后的二维数组....");



        for(int i = 1;i < sparseArr.length;i++) {
           chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        for(int[] row : chessArr2) {
            for(int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


    }


}
