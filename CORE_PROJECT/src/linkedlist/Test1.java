package linkedlist;
public class Test1 {
public static void main(String[] args) {
LinkedList list = new LinkedList();
System.out.println("LENGTH: "+list.length());
list.insert(100, 0);
System.out.println("LIST: "+list);	
System.out.println("LENGTH: "+list.length());	
list.insert(200, 1);
list.insert(300, 2);
list.insert(400, 3);
list.insert(500, 4);
list.insert(600, 5);
System.out.println("\n\n\nLIST: "+list);	
System.out.println("LENGTH: "+list.length());	

System.out.println("\n\nINSERT AT 2nd POS/INDEX ");
list.insert(999,2);
System.out.println("LIST: "+list);	
System.out.println("LENGTH: "+list.length());

System.out.println("\n\nINSERT AT END ");
ListNode node = new ListNode(123);
list.insertAtEnd(node);
System.out.println("LIST: "+list);	
System.out.println("LENGTH: "+list.length());

System.out.println("\n\nINSERT IN BEGINING ");
 node = new ListNode(987);
list.insertAtBegin(node);
System.out.println("LIST: "+list);	
System.out.println("LENGTH: "+list.length());

System.out.println("\n\nREMOVE FROM BEGIN: ");
ListNode res=list.removeFromBegin();
System.out.println("LIST: "+list);	
System.out.println("NODE: "+res);
System.out.println("LENGTH: "+list.length());

System.out.println("\n\nREMOVE FROM END: ");
res=list.removeFromEnd();
System.out.println("LIST: "+list);	
System.out.println("NODE: "+res);
System.out.println("LENGTH: "+list.length());

System.out.println("\n\nREMOVE FROM POSITION: ");
list.remove(2);
System.out.println("LIST: "+list);	
System.out.println("LENGTH: "+list.length());


System.out.println("\n\nGET POSITION ");
int x=list.getPosition(200);
System.out.println("DATA: "+x);


/*System.out.println("\n\nCLEAR ");
list.clearList();
System.out.println("LIST: "+list);	
System.out.println("LENGTH: "+list.length());*/
}
}
