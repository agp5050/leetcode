

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderedArrayChangeToBalanceTree {
    public static void main(String[] args) {
        int[] ary={1,3,5,7,9,11,13,15,17,19,21};
        List<Integer> collect = Arrays.stream(ary).boxed().collect(Collectors.toList());
        Integer[] rst=new Integer[collect.size()];
        collect.toArray(rst);
        Node node = Node.buildNode(rst, 0, ary.length - 1);
        System.out.println(node);
    }
}
@Data
class Node<E extends Comparable>{
    E data;
    public Node left;
    public Node right;
    public Node(E data){
        this.data=data;
    }

    public static <E extends Comparable> Node buildNode(E[] ary,int start,int end){
        if (start==end) return new Node(ary[start]);
        int middle=start+(end-start)/2;
        Node root=new Node(ary[middle]);
        if (start==middle) root.left=null;
        else {
            root.left=buildNode(ary,start,middle-1);
        }
        if (end==middle) root.right=null;
        else {
            root.right=buildNode(ary,middle+1,end);
        }
        return root;
    }


}
