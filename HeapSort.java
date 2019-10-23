

import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Collectors;

//由底向上构建最大堆。
public class HeapSort {
    public static void main(String[] args) {
        boolean check=true;
        for (int i=0;i<100;i++){
            boolean rst = compareOnce();
            if ((check=rst)==false) break;
        }
        System.out.println("total "+check);
    }

    private static boolean compareOnce() {
        int[] randomAry = getRandomAry(20, 100);
        int[] check=new int[randomAry.length];
        System.arraycopy(randomAry,0,check,0,randomAry.length);
        List<Integer> checkL=Arrays.stream(check).boxed().collect(Collectors.toList());
        Collections.sort(checkL);
        heapSort(randomAry);
        List<Integer> collect = Arrays.stream(randomAry).boxed().collect(Collectors.toList());
        System.out.println(JSONArray.toJSONString(checkL));
        System.out.println(JSONArray.toJSONString(randomAry));
        boolean rst=collect.equals(checkL);
        System.out.println("if equal "+rst);
        return rst;
    }

    public static int[] getRandomAry(int length,int max){
        Random random=new Random();
        int[] rst=new int[length];
        for (int i=0;i<length;i++){
            rst[i]=random.nextInt(max);
        }
        return rst;
    }
    private static void buildTopIsMaxTriangle(int[] ary,int rootIndex,int size){
        int left=rootIndex*2+1;
        int right=rootIndex*2+2;
        int max=rootIndex;
        if (left<size){
            if (ary[left]>ary[max]) max=left;
        }
        if (right<size){
            if (ary[right]> ary[max]) max=right;
        }
        if (max!=rootIndex){
            int tem=ary[rootIndex];
            ary[rootIndex]=ary[max];
            ary[max]=tem;
            buildTopIsMaxTriangle(ary,max,size);
        }

    }

    private static void buildTopIsMaxHeap(int[] ary,int size){
        for (int i=size/2;i>=0;i--){
            buildTopIsMaxTriangle(ary,i,size);
        }
    }

    public static void heapSort(int[] ary){
        int length=ary.length;
        for (int i=0;i<length;i++){
            //第n次build
            changeTopTail(ary, length, i);

        }
    }

    private static void changeTopTail(int[] ary, int length, int i) {
        buildTopIsMaxHeap(ary,length-i);
        int tmp=ary[0];
        ary[0]=ary[length-i-1];
        ary[length-i-1]=tmp;
    }
}
