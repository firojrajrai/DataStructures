package circularlinkedlist;

public class CLLTest {
public static void main(String[] args) {
	CircularLinkedList cll = new CircularLinkedList();
	System.out.println("LENGTH: "+cll.length);
	System.out.println("CLL: "+cll);
	
	cll.add(45);
	cll.add(56);
	cll.add(12);
	cll.add(76);
	System.out.println("\n\nADDING SOME ELEMENTS:");
	System.out.println("LENGTH: "+cll.length);
	System.out.println("CLL: "+cll);
	
	System.out.println("\n\nPEEK HEAD: "+cll.peek());
	System.out.println("\n\nPEEK TAIL: "+cll.tailPeek());
	
	System.out.println("\n\nADD TO TAIL:");
	cll.addToTail(63);
	System.out.println("LENGTH: "+cll.length);
	System.out.println("CLL: "+cll);
	
	System.out.println("\n\nPEEK HEAD: "+cll.peek());
	System.out.println("\n\nPEEK TAIL: "+cll.tailPeek()); 
	
	System.out.println("\n\nREMOVE FROM HEAD: ");
	int data=cll.removeFromHead();
	System.out.println("REMOVED DATA: "+data);
	System.out.println("LENGTH: "+cll.length);
	System.out.println("CLL: "+cll);
}
}
