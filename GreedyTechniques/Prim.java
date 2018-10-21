package GreedyTechniques;

import Entity.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>ClassName: Prim</p>
 * <p>Description: </p>
 *
 * @author
 */
public class Prim {


    public static void GetSpanningTree(Graph G){
        List<Integer> inList = new ArrayList<Integer>();
        List<Integer> outList = new ArrayList<Integer>();

        inList.add(0);
        for(int i=0;i<G.vertexNum;i++)
            outList.add(i);

        while(outList.size()>0){
            for(int i=0;i<inList.size();i++){
                for(int j=0;j<outList.size();j++){

                }
            }
        }

    }
}
