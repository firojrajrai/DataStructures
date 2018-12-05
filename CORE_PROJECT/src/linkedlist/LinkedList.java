package linkedlist;
public class LinkedList {
private int length=0;
ListNode head;	

//CONSTRUCTOR
public LinkedList() {
	length=0;
}

// GETHEAD
public synchronized ListNode getHead() {
	return head;
}

//INSERT BEGIN
public synchronized void insertAtBegin(ListNode node) {
	node.setNext(head);
	head = node;
	length++;
}

//INSERT END
public synchronized void insertAtEnd(ListNode node) {
	if(head==null)
		head = null;
	else {
		ListNode p,q;
		for(p=head;(q=p.getNext())!=null;p=q);
		p.setNext(node);
	}
	length++;
}

//INSERT IN POSITION
public void insert(int data, int position) {
	if(position < 0) {
		position = 0 ;
	}
	if(position > length) {
		position = length;
	}
	if(head == null) {
		head = new ListNode(data);
	}
	else if(position == 0 ) {
		ListNode temp = new ListNode(data);
		temp.setNext(head);
		head = temp;
	}else {
		ListNode temp = head;
		for(int i=1;i<position;i+= 1) {
			temp = temp.getNext();
		}
		ListNode newNode = new ListNode(data);
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);;
	}
	length += 1;
}


//REMOVE BEGIN
public synchronized ListNode removeFromBegin() {
	ListNode node = head;
	if(node !=null) {
		head = node.getNext();
		node.setNext(null);
	}
	length --;
	return node;
}

//REMOVE END
public synchronized ListNode removeFromEnd() {
	if(head==null)
		return null;
	ListNode p =head, q=null, next=head.getNext();
	if(next == null) {
		head=null;
		return p;
	}
	while((next=p.getNext()) != null) {
		q=p;
		p= next;
	}
	q.setNext(null);
	length--;
	return p;
	
}

//REMOVE MATCHED 
public synchronized void removeMatched(ListNode node) {
	if(head == null)
		return;
	if(node.equals(head)) {
		head=head.getNext();
		return;
	}
	ListNode p = head, q = null;
	while((q=p.getNext()) != null) {
		if(node.equals(q)) {
			p.setNext(q.getNext());
			return;
		}
		p=q;
	}
	length--;
}

//REMOVE FROM POSITION
public void remove(int position) {
	if(position<0) {
		position = 0;
	}
	if(position >= length) {
		position = length-1;
	}
	if(head == null)
		return;
	if(position == 0)
		head = head.getNext();
	else {
		ListNode temp = head;
		for(int i=1;i<position;i++) {
			temp = temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());
	}
	length -= 1;
}

//TOSTRING
public String toString() {
	String result = "[";
	if(head == null) {
		return result+"]";
	}
	result = result + head.getData();
	ListNode temp= head.getNext();
	while(temp != null) {
		result = result +", "+temp.getData();
		temp = temp.getNext();
	}
	return result +"]";
}

//LENGTH
public int length() {
return length;
}

//GET FROM POSITION
public int getPosition(int data) {
	ListNode temp = head;
	int pos = 0;
	while(temp !=null) {
		if(temp.getData()==data) {
			return pos;
		}
		pos += 1;
		temp = temp.getNext();
	}
	return Integer.MIN_VALUE;
}

//CLEAR
public void clearList() {
	head = null;
	length=0;
}
}