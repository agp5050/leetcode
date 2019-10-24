


import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Collectors;

public class HeapSortGeneric<T extends Comparable> {
    public static void main(String[] args) {
        boolean b=true;
        for (int i=0;i<1000;i++){
            if (b!=checkOnce()){
                System.out.println(i);
                break;
            }

        }

    }
    public static boolean checkOnce(){
        Integer[] randomL=generateRandomAry(40,100);
        Integer[] copy=new Integer[randomL.length];
        System.arraycopy(randomL,0,copy,0,randomL.length);
        HeapSortGeneric<Integer> heapSortGeneric=new HeapSortGeneric(randomL);
        heapSortGeneric.heapSort();
        List<Integer> list = Arrays.asList(copy);
        Collections.sort(list);
        System.out.println(JSONArray.toJSONString(randomL));
        System.out.println(JSONArray.toJSONString(copy));
        List<Integer> randomLTrans = Arrays.asList(randomL).stream().collect(Collectors.toList());
        List<Integer> collect = list.stream().collect(Collectors.toList());
        System.out.println(randomLTrans.equals(collect));
        return randomLTrans.equals(collect);
    }

    private static Integer[] generateRandomAry(int length, int max) {
        Random random=new Random();
        Integer[] rst=new Integer[length];
        for (int i=0;i<length;i++){
            rst[i]=(random.nextInt(max));
        }
        return rst;
    }

    private T[] values;
    public HeapSortGeneric(T[] values){
        this.values=values;
    }

    private void initFormatMaxOnTopHeap(){
        for (int i=values.length/2;i>=0;i--){
            adjustHeapFromNode(i,values.length);
        }
    }
    public void heapSort(){
        initFormatMaxOnTopHeap();
        for(int i=values.length-1;i>0;i--){
            swap(0,i);
            adjustHeapFromNode(0,i);
        }

    }

    private void adjustHeapFromNode(int i,int limit) {
        int length = limit;
        int leftChild=getLeftChild(i);
        int rightChild=getRightChild(i);
        int max=i;
        if(leftChild<length && values[leftChild].compareTo(values[max])>0){
            max=leftChild;
        }
        if(rightChild<length && values[rightChild].compareTo(values[max])>0){
            max=rightChild;
        }
        if (i!=max){
            swap(i,max);
            adjustHeapFromNode(max,limit);
        }

    }

    private void swap(int i, int max) {
        T value = values[i];
        values[i]=values[max];
        values[max]=value;
    }

    private int getRightChild(int i) {
        return 2*i+2;
    }

    private int getLeftChild(int i) {
        return 2*i+1;
    }


}
