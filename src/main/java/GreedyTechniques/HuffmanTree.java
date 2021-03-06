package GreedyTechniques;

import Entity.PriorityQueueT;

import java.util.ArrayList;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args){
        HuffmanNode node1 = new HuffmanNode("A",(float)0.35);
        HuffmanNode node2 = new HuffmanNode("B",(float)0.1);
        HuffmanNode node3 = new HuffmanNode("C",(float)0.2);
        HuffmanNode node4 = new HuffmanNode("D",(float)0.2);
        HuffmanNode node5 = new HuffmanNode("_",(float)0.15);
        List<HuffmanNode> list = new ArrayList<HuffmanNode>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);

        HuffmanNode huddmanTree = HuffmanNodeBuildHuffmanTree(list);
        System.out.println(huddmanTree.chance);
        System.out.println(huddmanTree.lchild.chance);
        System.out.println(huddmanTree.lchild.lchild.character + ":" + huddmanTree.lchild.lchild.chance);
        System.out.println(huddmanTree.lchild.rchild.character + ":" + huddmanTree.lchild.rchild.chance);
        System.out.println(huddmanTree.rchild.lchild.chance);
        System.out.println(huddmanTree.rchild.chance);
        System.out.println(huddmanTree.rchild.lchild.chance);
        System.out.println(huddmanTree.rchild.rchild.character + ":" + huddmanTree.rchild.rchild.chance);

        System.out.println();
        int[] code = new int[10];
        GetHuffmanCode(huddmanTree,code,-1);
    }

    public static HuffmanNode HuffmanNodeBuildHuffmanTree(List<HuffmanNode> nodeList){
        PriorityQueueT<HuffmanNode> pQueue = new PriorityQueueT<HuffmanNode>();
        for(HuffmanNode node: nodeList){
            pQueue.enQueue(node);
        }
        int size = pQueue.getSize();
        while(size>1){
            HuffmanNode node1 = pQueue.deQueue();
            HuffmanNode node2 = pQueue.deQueue();
            HuffmanNode nodeNew = new HuffmanNode(node1.character+node2.character, node1.chance+node2.chance);
            nodeNew.lchild = node1;
            nodeNew.rchild = node2;
            node1.parent = nodeNew;
            node2.parent = nodeNew;
            pQueue.enQueue(nodeNew);
            size = pQueue.getSize();
        }
        return pQueue.deQueue();
    }

    public static void GetHuffmanCode(HuffmanNode huffmanTree,int[] code,int index){
        if(huffmanTree.parent!=null){
            if(huffmanTree.equals(huffmanTree.parent.lchild))
                code[index] = 0;
            else if(huffmanTree.equals(huffmanTree.parent.rchild))
                code[index] = 1;
        }
        if(huffmanTree.lchild!=null&&huffmanTree.rchild!=null){
            GetHuffmanCode(huffmanTree.lchild,code,index+1);
            GetHuffmanCode(huffmanTree.rchild,code,index+1);
        } else{
            System.out.print(huffmanTree.character + ":");
            for(int i=0;i<=index;i++){
                System.out.print(code[i]);
            }
            System.out.println(" " + huffmanTree.chance);
        }
    }
}
