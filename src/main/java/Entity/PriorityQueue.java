package Entity;

import java.util.Arrays;

/**
 * @ClassName PriorityQueue 优先队列
 * @Description: 以最小堆为基础实现优先队列
 * @author ZJP
 * @date 18-10-21 下午3:31
 **/
public class PriorityQueue {

    public static int QueueEmpty = -9999;

    private int InitSize = 20;
    private int[] data;
    private int size;

    public PriorityQueue(int size){
        if(size<0)
            size = InitSize;
        this.data = new int[size];
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public int getMax(){
        if(this.size>0)
            return this.data[1];
        else
            return QueueEmpty;
    }

    public void enQueue(int x){
        if(this.size>=this.data.length-1)
            this.resize(this.size*2);
        //插入到最尾处
        int index = ++this.size;
        this.data[index] = x;
        //向上调整
        this.adjustUp(this.data,index);
    }

    public int deQueue(){
        if(this.size<=0)
            return QueueEmpty;
        else{
            //交换第一个元素和最后一个元素
            int temp = this.data[1];
            this.data[1] = this.data[this.size];
            this.data[this.size] = temp;
            //向下调整
            this.adjustDown(this.data,1,--this.size);
            return this.data[this.size+1];
        }
    }


    private void resize(int newSize){
        int[] temp = this.data;
        this.data = Arrays.copyOf(temp,newSize);
    }

    /**
     * A[1....n] 将k向下调整
     * @param A
     * @param k
     * @param n
     */
    private void adjustDown(int[] A,int k,int n) {
        A[0] = A[k];
        for(int i=k*2;i<=n;i*=2) {
            if(i<n&&A[i+1]<A[i])
                i++;
            if(A[0]<A[i])
                break;
            else {
                A[k] = A[i];
                k = i;
            }
        }
        A[k] = A[0];
    }

    /**
     * @Description: TODO
     * @author ZJP
     * @date 18-10-21 下午3:10
     * @Param * @param null
     * @return
     **/
    private void adjustUp(int[] A,int k) {
        for(int i=k/2;i>=1;i/=2) {
            if(A[k]<A[i]) {
                int temp = A[k];
                A[k] = A[i];
                A[i] = temp;
                k = i;
            }else
                break;
        }
    }

    public static void main(String[] args){
        PriorityQueue pQueue = new PriorityQueue(10);
        int[] data = {10,0,53,-1,5};
        for(int i=0;i<data.length;i++)
            pQueue.enQueue(data[i]);


        int x = pQueue.deQueue();
        while(x!=PriorityQueue.QueueEmpty) {
            System.out.println(x + " ");
            x = pQueue.deQueue();
        }
        System.out.println();
    }
}

