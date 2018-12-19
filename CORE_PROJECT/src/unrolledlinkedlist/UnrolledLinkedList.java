package unrolledlinkedlist;

import java.io.Serializable;
import java.util.*;

import jdk.nashorn.internal.runtime.arrays.NumericElements;
public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E>,Serializable{
private int nodeCapacity;
private int size;
private ListNode firstNode;
private ListNode lastNode;

public UnrolledLinkedList(int nodeCapacity)throws IllegalArgumentException{
	if(nodeCapacity < 8) {
		throw new IllegalArgumentException("Node capacity < 8");
	}
	this.nodeCapacity=nodeCapacity;
	firstNode= new ListNode();
	lastNode = firstNode;
}

public UnrolledLinkedList() {
	this(16);
}
public int size() {
	return size;
}

public boolean isEmpty() {
	return size == 0;
}

public boolean contains(Object o) {
	return (indexOf(o) != -1);
}

public Iterator<E> iterator(){
	return new ULLIterator(firstNode,0,0);
}

public boolean add(E e) {
	insertIntoNode(lastNode,lastNode.numElements,e);
	return true;
}

public boolean remove(Object o) {
	int index = 0;
	ListNode node = firstNode;
	if(o==null) {
		while(node != null) {
			for(int ptr=0;ptr<node.numElements;ptr++) {
				if(node.elements[ptr] == null) {
					removeFromNode(node,ptr);
				}
			}
			index += node.numElements;
			node = node.next;
		}
	}else {
		while(node != null) {
			for(int ptr =0;ptr <node.numElements;ptr++) {
				if(o.equals(node.elements[ptr])) {
					removeFromNode(node,ptr);
					return true;
				}
			}
			index += node.numElements;
			node = node.next;
		}
	}
return false;
}

public E remove(int index)throws IndexOutOfBoundsException{
if(index <0 || index>= size) {
	throw new IndexOutOfBoundsException();
}
E element = null;
ListNode node;
int p=0;
if(size - index > index) {
	node = firstNode;
	while(p<= index-node.numElements) {
		p += node.numElements;
		node = node.next;
	}
}else {
	node = lastNode;
	p = size;
	while((p-= node.numElements)> index) {
		node = node.previous;
	}
}
element = (E) node.elements[index-p];
removeFromNode(node,index-p);
return element;
	
}

public void clear() {
	ListNode node = firstNode.next;
	while(node != null) {
		ListNode next = node.next;
		node.next = null;
		node.previous = null;
		node.elements = null;
		node = next;
	}
	lastNode = firstNode;
	for(int ptr=0; ptr<firstNode.numElements;ptr++) {
		firstNode.elements[ptr] = null;
	}
	firstNode.numElements=0;
	firstNode.next = null;
	size = 0;
}

@Override
public E get(int index) throws IndexOutOfBoundsException{
	if(index < 0 || index >= size) {
		throw new IndexOutOfBoundsException();
	}
	ListNode node;
	int p =0;
	if(size-index > index) {
		node = firstNode;
		while(p<=index-node.numElements) {
			p += node.numElements;
			node = node.next;
		}
	}else {
		node=lastNode;
		p=size;
		while((p -= node.numElements)>index) {
			node = node.previous;
		}
	}
	return (E)node.elements[index -p];
}

public E set(int index, E element) {
	if(index<0 || index>=size) {
		throw new IndexOutOfBoundsException();
	}
	E el = null;
	ListNode node;
	int p =0;
	if(size-index> index) {
		node = firstNode;
		while(p<=index-node.numElements) {
			p += node.numElements;
			node = node.next;
		}
	}else {
		node = lastNode;
		p=size;
		while((p -= node.numElements) > index) {
			node=node.previous;
		}
	}
	el = (E)node.elements[index-p];
	node.elements[index-p]=element;
	return el;
}

public void add(int index,E element)throws IndexOutOfBoundsException{
	if(index<0 || index>size) {
		throw new IndexOutOfBoundsException();
	}
	ListNode node;
	int p=0;
	if(size-index > index) {
		node = firstNode;
		while(p<=index-node.numElements) {
			p += node.numElements;
			node = node.next;
		}
	}else {
		node = lastNode;
		p = size;
		while(p <= index - node.numElements) {
			node = node.previous;
		}
	}
	insertIntoNode(node,index-p,element);
}

		//LISTNODE
private class ListNode{
	ListNode next;
	ListNode previous;
	int numElements =0;
	Object[] elements;
	ListNode(){
		elements = new Object[nodeCapacity];
	}
}

		//ITERATOR IMPLEMENTATION

private class ULLIterator implements ListIterator<E>{
	ListNode currentNode;
	int ptr;
	int index;
	private int expectedModCount = modCount;
	
	ULLIterator(ListNode node, int ptr,int index){
		this.currentNode=currentNode;
		this.ptr=ptr;
		this.index=index;
	}
	
	public boolean hasNext() {
		return (index < size-1);
	}
	
	public E next() {
		ptr++;
		if(ptr >= currentNode.numElements) {
			if(currentNode.next != null) {
				currentNode = currentNode.next;
				ptr=0;
			}else {
				throw new NoSuchElementException();
			}
		}
		index ++;
		checkForModification();
		return (E)currentNode.elements[ptr];
	}
	
	@Override
	public E previous() {
		ptr--;
		if(ptr < 0) {
			if(currentNode.previous != null) {
				currentNode = currentNode.previous;
						ptr = currentNode.numElements -1;
			}else {
				throw new NoSuchElementException();
			}
		}
		index--;
		checkForModification();
		return (E)currentNode.elements[ptr];
	}
	
	@Override
	public boolean hasPrevious() {
		return (index>0);
	}
	
	@Override
	public int nextIndex() {
		return (index+1);
	}
	
	@Override
	public int previousIndex() {
		return (index -1);
	}
	
	@Override
	public void add(E e) {
		checkForModification();
		insertIntoNode(currentNode,ptr+1,e);
		
	}
	
	@Override
	public void remove() {
		checkForModification();
		removeFromNode(currentNode,ptr);
		
	}
	
	@Override
	public void set(E e) {
		checkForModification();
		currentNode.elements[ptr]=e;
	}
	
	private void checkForModification() {
		if(modCount != expectedModCount) {
			throw new ConcurrentModificationException();
		}
	}
}

private void insertIntoNode(ListNode node,int ptr,E element) {
	if(node.numElements == nodeCapacity) {
		ListNode newNode = new ListNode();
		int elementsToMove = nodeCapacity/2;
		int startIndex = nodeCapacity - elementsToMove;
		for(int i=0;i<elementsToMove;i++) {
			newNode.elements[i]=node.elements[startIndex + i];
			node.elements[startIndex + i] = null;
		}
		node.numElements -= elementsToMove;
		newNode.numElements=elementsToMove;
		newNode.next = node.next;
		newNode.previous = node;
		if(node.next != null) {
			node.next.previous = newNode;
		}
		node.next = newNode;
		if(node == lastNode) {
			lastNode = newNode;
		}
		if(ptr >node.numElements) {
			node = newNode;
			ptr -= node.numElements;
		}
	}
	for(int i=node.numElements;i>ptr;i--) {
		node.elements[i] = node.elements[i-1];
	}
	node.elements[ptr] = element;
	node.numElements++;
	size++;
	modCount++;
}

private void removeFromNode(ListNode node,int ptr) {
	node.numElements--;
	for(int i=ptr;i<node.numElements;i++) {
		node.elements[i] = node.elements[i+1];
	}
	node.elements[node.numElements] = null;
	if(node.next != null && node.next.numElements+ node.numElements <=nodeCapacity) {
		mergeWithNextNode(node);
	}else if(node.previous != null && node.previous.numElements+node.numElements<=nodeCapacity) {
		mergeWithNextNode(node.previous);
	}
	size--;
	modCount++;
}

private void mergeWithNextNode(ListNode node) {
	ListNode next = node.next;
	for(int i=0;i<next.numElements;i++) {
		node.elements[node.numElements+i]=next.elements[i];
		next.elements[i]=null;
	}
	node.numElements += next.numElements;
	if(next.next != null) {
		next.next.previous = node;
	}
	node.next = next.next.next;
	if(next == lastNode) {
		lastNode = node;
	}
}
}
