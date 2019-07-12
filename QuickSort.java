package com.fbank.ai;

import java.util.*;

public class QuickSort {
    public static void heapSort(int[] ary,int start,int end){
        int originStart=start;
        int originEnd=end;
        int middle=start;
        boolean MilddleInFront=true;
        while (true){
            if (end<=start) break;
            if (MilddleInFront){
                if (ary[middle]<=ary[end]){
                    end--;
                    continue;
                }else {
                    int tmp=ary[end];
                    ary[end]=ary[middle];
                    ary[middle]=tmp;
                    start=middle+1;
                    middle=end;
                    MilddleInFront=false;
                    continue;
                }
            }else {
                if (ary[start]<=ary[middle]){
                    start++;
                    continue;
                }else {
                    int tmp=ary[start];
                    ary[start]=ary[middle];
                    ary[middle]=tmp;
                    end=middle-1;
                    middle=start;
                    MilddleInFront=true;
                    continue;
                }

            }
        }
        if (middle>originStart+1){
            heapSort(ary,originStart,middle-1);
        }
        if (middle+1<originEnd){
            heapSort(ary,middle+1,originEnd);
        }



    }

    public static void test(int length){
        Random random=new Random();
        int[] ary=new int[length];
        List list=new ArrayList(length);
        for (int i=0;i<length;++i){
            ary[i]=random.nextInt(100);
            list.add(ary[i]);
        }
        long start=System.currentTimeMillis();
        heapSort(ary,0,ary.length-1);
        long startEnd=System.currentTimeMillis();
        System.out.println("spent time milliseconds :"+ (startEnd-start));
        long start2=System.currentTimeMillis();
        Collections.sort(list);
        long startEnd2=System.currentTimeMillis();
        System.out.println("spent time milliseconds :"+ (startEnd2-start2));
        boolean equal=true;
        for (int i=0;i<length;++i){
            System.out.print(ary[i]+"\t");
            if (ary[i]!=(int)list.get(i)){
                equal=false;
            }
        }

        System.out.println();
        System.out.println(list);
        System.out.println(equal);
    }
    public static void main(String[] args) {

        test(10000);





    }
}
