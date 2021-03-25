import java.util.HashMap;

public class MyList {
    Node head;
    //task 2 1.a
    MyList() {
        int[] arr={};
    }
    //task 2 1.b
    public MyList (int [] a) {
       head= new Node (a[0], null);
       Node current = head;
        for (int i = 1; i < a.length; i++) {
           Node temp = new Node(a[i], null);
           current.next = temp;
           current = current.next;
        }
    }
    //task 2 1.c
    public  MyList(MyList a){
        head= new Node(a.head.value, null);
        Node current = head;
        Node nextInfo = new Node( a.head.value, a.head.next);
        while (nextInfo.next != null) {
            Node nextNode = new Node(nextInfo.next.value, null);
            current.next = nextNode;
            current = current.next;
            nextInfo=nextInfo.next;
        }
    }
    //task 2 question 2
    public void showList (){
        if(head==null){
            System.out.print("empty list");
        }
        else{
            for(Node cur=head; cur!=null; cur=cur.next){
                System.out.print(cur.value + " ");
            }
        }
    }
    //task 2 question 3
    public boolean isEmpty (){
        if( head==null) {
            return true;
        }
            else{
                return false;
            }
        }
    //task 2 question 4
    public void clear(){
        for(Node cur=head; cur!=null; cur=cur.next){
            Node temp= head;
            head= head.next;
            temp.next=null;
            temp.value=0;
        }
    }
    //task 2 question 5
    public void insert(Node newElement){
        boolean p=false;
        for(Node cur=head; cur!=null; cur=cur.next){
            // if(newElement.value==cur.value){
            //     System.out.println("Value Already Exists");
            //     p=true;
            // }
            // if(cur.next==null && p==false){
                if(cur.next==null){
                Node nextNode = new Node(newElement.value, null);
                cur.next= nextNode;
                break;
            }
        }
    }
    //task 2 question 6
    public void insert(Node newElement, int index){
        boolean p=false;
        
        // for(Node cur=head; cur!=null; cur=cur.next){
        //     if(newElement.value==cur.value){
        //         System.out.println("Value Already Exists");
        //         p=true;
        //     }
        // }
        if(p==false){
            int i=0;
            for(Node cur=head; cur!=null; cur=cur.next){
                if(index==0){
                    Node nextNode = new Node(newElement.value, null);
                    nextNode.next=head;
                    head=nextNode;
                    break;
                }
                if(index==i+1){
                    Node nextNode = new Node(newElement.value, cur.next);
                    cur.next=nextNode;
                }
                i++;
            }
        }
    }
    //task 2 question 7

    public int remove(int deleteKey){
        int p=-1;
        for(Node cur=head; cur!=null; cur=cur.next){
            if(deleteKey==cur.next.value){
                p=cur.next.value;
                cur.next=cur.next.next;
                return p;
            }
        }
        return p;
    }

    //task 3 question 1

    public MyList evenGenerator(MyList a){
        MyList z= new MyList(a);
        for(Node cur=z.head; cur.next!=null; cur=cur.next){
            if(cur.next.value%2!=0){
                cur.next=cur.next.next;
            }
        }
        z.showList();
        return z;
    }

    // task 3 question 2
    public boolean findValue(int vall){
        boolean p=false;
        for(Node cur=head; cur!=null; cur=cur.next){
            if(vall==cur.value){
                //System.out.println("Value Exists");
                p= true;
                return p;
            }
        }
        return p;
    }
    //task 3 question 3
    public void reverseList(){
        Node newHead = null;
        Node x = head;
        while(x!=null){
          Node nextNode = x.next;
          x.next = newHead;
          newHead = x;
          x = nextNode;
        }
        head=newHead;
      }
    //task 3 question 4
    public void sortList(){
        for(Node x=head;x!=null;x=x.next){
          for(Node i=head;i!=null;i=i.next){
            if(x.value < i.value){
              int temp = i.value;
                i.value=x.value;
                x.value=temp;
            }
          }
        }
      }
    //task 3 question 5
    public void printSum(){
        int sum=0;
        for(Node cur=head; cur!=null; cur=cur.next){
            sum+= cur.value;
        }
        System.out.println("The sum of the values in the list is: "+ sum);
    }
    //task 3 question 6
    public void rotateList(String x, int p){
        if(x=="left"){
        while(p>0){
            Node gg = head;
            head= head.next;
            insert(gg);
            p--;
        }
    }
    else if(x=="right"){
        while(p>0){
            for(Node cur=head; cur!=null; cur=cur.next){
                if(cur.next.next==null){
                    Node saved;
                    saved=cur.next;
                    cur.next=cur.next.next;
                    insert(saved, 0);
                    break;
                }
                //System.out.println("hoitesena");
            }
            p--;
        }
    }
    else{
        System.out.println("give either right or left");
    }
    }


    //assignment 1 question 
    public void printDuplicate(Node h){
        //to do
        HashMap<Integer,
          Integer> mp = new HashMap<Integer,
                                    Integer>();
        Node head = h;
        while (h != null)
        {
            if(mp.containsKey(h.value))
            mp.put(h.value,
                    mp.get(h.value) + 1);
            else
            mp.put(h.value, 1);
        
            h = h.next;
        }
        
        h = head;
        int fuchka=0;
        while (h != null)
        {
            if (mp.get(h.value) > 1){
            System.out.println(h.value);
                fuchka=1;
                break;
            }
            h = h.next;
        }
        
        // all the nodes are unique
        if(fuchka==0){
            System.out.println("ALL VALUES ARE UNIQUE");
        }
    }
    public void removeMultiplesFive(Node n){
        Node cur=n;
        while(cur.next!=null){     
            if(head.value%5==0){
                head= head.next;
            }
            if(cur.next.value%5==0){
                cur.next=cur.next.next;   
            }
            else{
            cur= cur.next;
            }
        }
    }

    public void makeCircular(){
        for(Node cur=head;cur!=null;cur=cur.next){
            if(cur.next==null){
                cur.next=head;
                break;
            }
        }
    }
    public void printCircular(){
        System.out.print(head.value+" ");
        for(Node cur=head.next;cur!=head;cur=cur.next){
            System.out.print(cur.value+" ");
        }
    }
    public void insertCircular(int InsertKorbo, int kothayInsertKorbo){
        int ekhon=1;
        int size=1;
        Node jetaInsertKoraLagbe= new Node(InsertKorbo, null);
        //Node cur= head;
        for(Node cur=head.next;cur!=head;cur=cur.next){
            size++;
        }
        //System.out.println(size);
        if(kothayInsertKorbo%size==0){
            Node cur=head;
            while(cur.next!=head){
                cur=cur.next;
            }
            cur.next=jetaInsertKoraLagbe;
            jetaInsertKoraLagbe.next=head;
            head=jetaInsertKoraLagbe;
            }
        else{
        Node cur=head;
        while(ekhon!=kothayInsertKorbo){
            cur=cur.next;
            ekhon++;
            //System.out.println("ami loop e");
        }
        Node extra= cur.next;
        cur.next=jetaInsertKoraLagbe;
        jetaInsertKoraLagbe.next=extra;
    }
}
public void insertBefore (Node head, Object elem, Object newElement){
    Node cur= head;
    while(cur.next!=head){
        if(cur.next.value==elem.value){
            Node p= cur.next;
            cur.next= newElement;
            newElement.prev=cur;
            newElement.next=p;
            p.prev=newElement;
        }
        cur=cur.next;
    }
}
    
}
