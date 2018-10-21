package GreedyTechniques;

import java.util.Comparator;

public class HuffmanNode implements Comparable<HuffmanNode> {

    public String character;  //字符
    public float chance;   //概率

    public HuffmanNode lchild;
    public HuffmanNode rchild;

    public HuffmanNode(String character,float chance){
        this.character = character;
        this.chance = chance;
        lchild = null;
        rchild = null;
    }

    @Override
    public String toString(){
        return "node:" + this.character + " " + this.chance;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        if(this.chance > o.chance)
            return 1;
        else if(this.chance == o.chance)
            return 0;
        else
            return -1;
    }
}
