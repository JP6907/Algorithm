package GreedyTechniques;

import java.util.Comparator;

public class HuffmanNode implements Comparator<HuffmanNode> {

    public char character;  //字符
    public float chance;   //概率

    public HuffmanNode lchild;
    public HuffmanNode rchild;

    public HuffmanNode(char character,float chance){
        this.character = character;
        this.chance = chance;
        lchild = null;
        rchild = null;
    }

    @Override
    public int compare(HuffmanNode node1,HuffmanNode node2){
        if(node1.chance - node2.chance > 0)
            return 1;
        else if(node1.chance == node2.chance)
            return 0;
        else
            return -1;
    }
}
