package com.ntuzy.tree.huffmancode;

import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import jdk.nashorn.internal.ir.Flags;
import sun.misc.OSEnvironment;

import java.io.*;
import java.util.*;

/**
 * @Author IamZY
 * @create 2020/2/15 15:01
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);  // 40

        List<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes);
        System.out.println();

        Node root = createHuffmanTree(nodes);

        preOrder(root);

        System.out.println();

        getCodes(root, "", stringBuilder);

//        getCodes(root);

        System.out.println(huffmanCodes);

        byte[] zip = zip(contentBytes, huffmanCodes);

        System.out.println(Arrays.toString(zip));


        byte[] decode = decode(huffmanCodes, zip);

        System.out.println(new String(decode));

    }

    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    static StringBuilder stringBuilder = new StringBuilder();


    // 编写方法将文件压缩

    /**
     * @param src
     * @param dest
     */
    public static void zipFile(String src, String dest) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fis = new FileInputStream(new File(src));
            fos = new FileOutputStream(new File(dest));

            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);

            // 获取文件的编码表
            byte[] huffmanbytes = huffmanZip(bytes);

            oos = new ObjectOutputStream(fos);
            oos.writeObject(huffmanbytes);
            // 把哈夫曼编码后的字节数组 写入压缩文件
            // 编码表也需要输入到数据中
            oos.writeObject(huffmanCodes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void unZipFile(String zipFile, String dest) {
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;


        try {
            is = new FileInputStream(new File(zipFile));
            ois = new ObjectInputStream(is);
            os = new FileOutputStream(dest);

            byte[] huffmanBytes = (byte[]) ois.readObject();


            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            byte[] bytes = decode(huffmanCodes, huffmanBytes);

            os.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * @param huffmanCodes 哈夫曼编码表
     * @param huffmanBytes 哈夫曼编码得到的字节数组
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        // 先得到huffmanBytes 队医你个的俄日禁止的字符串

        StringBuilder stringBuilder = new StringBuilder();
        // 将byte专程二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }


        // 把字符串按照制定法的哈夫曼编码进行解码
        // 把哈夫曼编码表进行调换 因为反响查询a->100 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> e : huffmanCodes.entrySet()) {
            map.put(e.getValue(), e.getKey());
        }

        List<Byte> list = new ArrayList<>();

        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                // 取出一个‘1’或者‘0’
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);

                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }

        // 把list中的数据放入byte[]数组并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }

        return b;
    }


    // 数据的解压

    /**
     * @param flag true 需要补到高位 如果是true 标识需要补高位  如果是false 标识不补
     * @param b
     * @return
     */
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        // 如果是正数
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);

        if (flag) {
            // 没有到最后一位
            return str.substring(str.length() - 8);
        } else {
            return str;
        }

    }


    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //
        Node huffmanTreeRoot = createHuffmanTree(nodes);

        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);

        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

        return huffmanCodeBytes;
    }


    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        // 利用huffmanCodes
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        int len;

        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }

        // 创建 存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];

        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                // 不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }


    /**
     * 将传入的node节点的所有叶子节点 的哈夫曼编码得到 并放入到huffmanCodes集合中
     *
     * @param node          传入节点
     * @param code          路径  左子节点 0 右子节点 1
     * @param stringBuilder 适用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);

        stringBuilder2.append(code);

        if (node != null) {
            // 判断是叶子节点还是非叶子节点
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                // 就表示某个叶子节点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }

    }

    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            new RuntimeException("huffman tree is empty");
        }

        Node node = root;

        getCodes(node.left, "0", stringBuilder);
        getCodes(node.right, "1", stringBuilder);

        return huffmanCodes;
    }


    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            new RuntimeException("huffman is empty");
        }
    }


    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);

        }
        return nodes.get(0);
    }


    private static List<Node> getNodes(byte[] bytes) {

        ArrayList<Node> nodes = new ArrayList<>();

        HashMap<Byte, Integer> counts = new HashMap<>();

        for (int i = 0; i < bytes.length; i++) {
            Integer count = counts.get(bytes[i]);

            if (count == null) {
                counts.put(bytes[i], 1);
            } else {
                counts.put(bytes[i], ++count);
            }
        }


        for (Map.Entry<Byte, Integer> e : counts.entrySet()) {
            nodes.add(new Node(e.getKey(), e.getValue()));
        }

        return nodes;
    }


}


// 创建code 数据和权值
class Node implements Comparable<Node> {
    Byte data;  // 存放数字本省
    int weight;  // 权值 字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }

    }

}