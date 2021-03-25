public class Tester {
    public MyList sumOfTwoLists(Node n1, Node n2){
        int sum1=0;
        int sum2=0;
        for(Node cur=n1.next; cur!=null; cur=cur.next){
            sum1 = sum1* 10;
            sum1 = sum1+cur.value;
        }
        for(Node cur=n2.next; cur!=null; cur=cur.next){
            sum2 = sum2*10;
            sum2 += cur.value;
        }
        int finalSum= sum1+sum2;
        int copyFinal=finalSum;
        //System.out.println(sum1+ sum2);
        int count = 0; 
        while (finalSum != 0) {
        // num = num/10
        finalSum /= 10;
        ++count;
        }
        //System.out.println(21232456+ 123456);
        int bhag= (int) Math.pow(10, count-1);
        //System.out.println(bhag);
        int[] amarArray=new int[count+1];
        amarArray[0]=0;
        int mainnum;
        for(int i=1;i<count+1;i++){
            mainnum=copyFinal/bhag;
            copyFinal= copyFinal%bhag;
            bhag= bhag/10;
            amarArray[i]=mainnum;
        }
        // for(int i=0; i<amarArray.length;i++){
        //     System.out.print(amarArray[i]+ " ");
        // }
        MyList newList= new MyList(amarArray);
        return newList;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        MyList m1 = new MyList(a);
        MyList l2 = new MyList();
        //task 2.2
        System.out.println("showList Method:");
        m1.showList();
        System.out.println();
        System.out.println("showList when empty:");
        l2.showList();
        System.out.println();
        //task 2.3
        System.out.println("isEmpty Method on empty MyList:");
        System.out.println(l2.isEmpty());
        //task 2.1.c
        System.out.println("Creating a new list from a list and printing using showList(): ");
        MyList l3 = new MyList(m1);
        l3.showList();
        System.out.println();
        //task 2.5
        System.out.println("Inserting Using Node:");
        //Node pp= new Node(600,null);
        //l3.insert(pp);
        l3.showList();
        System.out.println();
        //task 2.6
        System.out.println("Inserting Using value and index:");
        Node n= new Node(2, null);
        Node nu= new Node(2,null);
        l3.insert(n,0);
        l3.insert(nu,4);
        l3.showList();
        System.out.println();
        //task 2.7
        System.out.println("Removing value 20 and returning it: ");
        //System.out.println(l3.remove(20));
        System.out.println("Showing that the value has been removed: ");
        l3.showList();
        System.out.println();
        //even numbers:
        //MyList evenMyList= evenGenerator(l3);
        
        //rotate
        // task 3.6.2
        System.out.println("Right Rotate by 2: ");
        //l3.rotateList("right", 2);
        l3.showList();
        System.out.println();
        // task 3.6.1
        System.out.println("Left Rotate by 5: ");
        //l3.rotateList("left", 5);
        //l3.showList();
        //System.out.println();
        //System.out.println("Reverse List: ");
        //l3.reverseList();
        //l3.showList();

        //task 3.1
        System.out.println();
        //MyList pussy= new MyList();
        //pussy.evenGenerator(l3);
        //pussy.showList();
        //System.out.println(m1.isEmpty());
       // System.out.println("\number of elements " + m1.count());

       //task 3.2
       //System.out.println();
       System.out.println(l3.findValue(45));

       //task 3.5
       l3.printSum();

       //l3.sortList();
       //l3.showList();
    //    System.out.println();
    //    System.out.println("Print 1st Duplicate");
    //    l3.printDuplicate(l3.head);
       l3.showList();

       System.out.println();
       m1.showList();
       System.out.println();
    //    l3.rotateList("left", 2);
    //    l3.removeMultiplesFive(l3.head);
    //    l3.showList();
    Tester t= new Tester();
    MyList amarnewListGenerated;
    amarnewListGenerated= t.sumOfTwoLists(l3.head, m1.head);
    amarnewListGenerated.showList();
    System.out.println();
    m1.showList();
    System.out.println();
    m1.makeCircular();
    m1.printCircular();
    m1.insertCircular(24,6);
    System.out.println();
    m1.printCircular();
    }
}