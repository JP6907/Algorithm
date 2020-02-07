package Sort;

/**
 * <p>ClassName: </p>
 * <p>Description: </p>
 *
 * @author
 */
public class ThreadSort implements Runnable{

    private String num;

    public ThreadSort(int num){
        this.num = num + "";
    }

    public static void main(String[] args){
        int[] num = {11,3,998,5455,1,152,990};
        for(int i=0;i<num.length;i++){
            new Thread(new ThreadSort(num[i])).start();
        }
    }

    @Override
    public void run() {
        try{
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
