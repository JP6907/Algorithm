package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PriorityQueue 优先队列
 * @Description: 以最小堆为基础实现优先队列
 * @author ZJP
 * @date 18-10-21 下午3:31
 **/
public class PriorityQueueT<T extends Comparable> {

    public static int QueueEmpty = -9999;

    private List<T> data;
    private int size;

    public PriorityQueueT(){
        this.data = new ArrayList<T>();
        this.data.add(null);  //第0个位置不参与
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public T getMax(){
        if(this.size>0)
            return this.data.get(1);
        else
            return null;
    }

    public void enQueue(T x){
        //插入到最尾处
        int index = ++this.size;
        data.add(x);
        //向上调整
        this.adjustUp(this.data,index);
    }

    public T deQueue(){
        if(this.size<=0)
            return null;
        else{
            //交换第一个元素和最后一个元素
            T temp = this.data.get(1);
            this.data.set(1,this.data.get(this.size));
            this.data.set(this.size, temp);
            //向下调整
            this.adjustDown(this.data,1,--this.size);
            T t = this.data.get(this.size+1);
            this.data.remove(this.data.get(this.size+1));
            return t;
        }
    }

    /**
     * A[1....n] 将k向下调整
     * @param A
     * @param k
     * @param n
     */
    private void adjustDown(List<T> A,int k,int n) {
        A.set(0,A.get(k));
        for(int i=k*2;i<=n;i*=2) {
            if(i<n&&A.get(i+1).compareTo(A.get(i))<0)
                i++;
            if(A.get(0).compareTo(A.get(i))<0)
                break;
            else {
                A.set(k,A.get(i));
                k = i;
            }
        }
        A.set(k,A.get(0));
    }

    /**
     * @Description: TODO
     * @author ZJP
     * @date 18-10-21 下午3:10
     * @Param * @param null
     * @return
     **/
    private void adjustUp(List<T> A,int k) {
        for(int i=k/2;i>=1;i/=2) {
            if(A.get(k).compareTo(A.get(i))<0) {
                T temp = A.get(k);
                A.set(k,A.get(i));
                A.set(i,temp);
                k = i;
            }else
                break;
        }
    }

    public static void main(String[] args){
        PriorityQueueT<Integer> pQueue = new PriorityQueueT<Integer>();

        int[] data = {10,0,53,-1,5};
        for(int i=0;i<data.length;i++)
            pQueue.enQueue(data[i]);


        Integer x = pQueue.deQueue();
        while(x!= null) {
            System.out.println(x + " ");
            x = pQueue.deQueue();
        }
        System.out.println();
    }
}

