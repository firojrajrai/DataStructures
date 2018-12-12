package circularlinkedlist;
public class CLLNode {
private int data;
private CLLNode next;
public CLLNode(int data) {
	this.data=data;
}

public CLLNode() {}

public int getData() {
	return data;
}

public void setData(int data) {
	this.data = data;
}

public CLLNode getNext() {
	return next;
}

public void setNext(CLLNode next) {
	this.next = next;
}
}
