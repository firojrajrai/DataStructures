package doublylinkedlist;
public class TestDLL {
public static void main(String[] args) {
	
	DoublyLinkedList dll = new DoublyLinkedList();
	dll.insert(99);
	dll.insert(23);
	dll.insert(34);
	dll.insert(54);
	dll.insert(56);
	dll.insert(78);
	System.out.println("LENGTH: "+dll.length());
	System.out.println(dll);
	
	System.out.println("\n\nINSERT IN POSITION 2");
	dll.insert(55, 2);
	System.out.println("LENGTH: "+dll.length());
	System.out.println(dll);
	
	System.out.println("\n\nREMOVE DATA FROM POSITION 3");
	dll.remove(3);
	System.out.println("LENGTH: "+dll.length());
	System.out.println(dll);
	
	System.out.println("\n\nREMOVE HEAD");
	dll.removeHead();
	System.out.println("LENGTH: "+dll.length());
	System.out.println(dll);
	
	System.out.println("REMOVE TAIL");
	dll.removeTail();
	System.out.println("LENGTH: "+dll.length());
	System.out.println(dll);
	
	System.out.println("\nINSERT TAIL");
	dll.insertTail(89);
	System.out.println("LENGTH: "+dll.length());
	System.out.println(dll);
	
	System.out.println("\n\nGET POSITION OF DATA");
	int pos = dll.getPosition(34);
	System.out.println("POSITION OF 34 : "+pos);
	
	System.out.println("\n\nGETTING DATA FROM POSITION");
	int data = dll.get(4);
	System.out.println(dll);
	System.out.println("DATA: "+data);
	
	System.out.println("\n\nCLEAR LIST:");
	dll.clearList();
	System.out.println("LENGTH: "+dll.length());
	System.out.println(dll);
	
	
}
	
}
