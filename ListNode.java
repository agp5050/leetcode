public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public static ListNode getListNode(int a){
        char[] chars = (a + "").toCharArray();
        Integer integer = Integer.valueOf(chars[0]+"");
        ListNode listNode = new ListNode(integer);
        ListNode first=listNode;
        for (int i=1;i<chars.length;++i){
            listNode.next=new ListNode(Integer.valueOf(chars[i]+""));
            listNode=listNode.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(16234);
        ListNode listNode2 = ListNode.getListNode(26998);
        ListNode listNode1 = new Solution2().addTwoNumbers2(listNode, listNode2);
        while (listNode1.next!=null){
            System.out.print(listNode1.val);
            listNode1=listNode1.next;
        }
        System.out.print(listNode1.val);
    }
 }
 class Solution2 {
     public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
         if (l1==null&&l2==null)
             return null;
         if (l1==null)
             return l2;
         if (l2==null)
             return l1;
         int append=0;
         append = (l1.val + l2.val+append) / 10;
         int v=(l1.val + l2.val)%10;

         ListNode listNode = new ListNode(v);
         ListNode first=listNode;
         while(l1.next!=null&&l2.next!=null){
             l1=l1.next;
             l2=l2.next;
             int v1=(l1.val+l2.val+append)%10;
             append=(l1.val+l2.val+append)/10;
             listNode.next=new ListNode(v1);
             listNode=listNode.next;
         }
         if (l1.next==null&&l2.next==null){
             if (append>0)
                 listNode.next=new ListNode(append);
             return first;
         }
         if (l1.next!=null){
             while (l1.next!=null){
                 l1=l1.next;
                 int newV = (l1.val + append) % 10;
                 append=(l1.val+append)/10;
                 listNode.next=new ListNode(newV);
                 listNode=listNode.next;
             }
             if (append>0)
                 listNode.next=new ListNode(append);
             return first;
         }
         if (l2.next!=null){
             while (l2.next!=null){
                 l2=l2.next;
                 int newV = (l2.val + append) % 10;
                 append=(l2.val+append)/10;
                 listNode=new ListNode(newV);
                 listNode=listNode.next;
             }
             if (append>0)
                 listNode.next=new ListNode(append);
             return first;
         }


         return first;

     }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode listNode = new ListNode((l1.val + l2.val)%10);
         ListNode first=listNode;
         int append=(l1.val+l2.val)/10;
         int step1=0;
         int step2=0;
         while (true){
             if (l1.next!=null){
                 if (l2.next!=null){
                     l1=l1.next;
                     l2=l2.next;
                     ++step1;
                     ++step2;
                     int newV = (l1.val + l2.val + append) % 10;
                     append=(l1.val + l2.val + append) /10; //new append
                     listNode.next=new ListNode(newV);
                     listNode=listNode.next;
                     continue;
                 }
                 l1=l1.next;
                 ++step1;
                 int newV=(l1.val+append)%10;
                 append=(l1.val+append)/10;
                 listNode.next=new ListNode(newV);
                 listNode=listNode.next;
                 continue;
             }else if (l2.next!=null){
                 l2=l2.next;
                 ++step2;
                 int newV=(l2.val+append)%10;
                 append=(l2.val+append)/10;
                 listNode.next=new ListNode(newV);
                 listNode=listNode.next;
             }

             if (l1.next==null&&l2.next==null){
                 if (append>0){
                     listNode.next=new ListNode(append);
                 }
                 break;
             }

         }
         System.out.println("l1.length="+(step1+1)+":::"+"l2.length="+(step2+1));
         return first;
     }
 }
