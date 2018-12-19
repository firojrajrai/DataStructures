package stack.dynamicarraystacks;
public class TestDynamicArrayStack {
public static void main(String[] args) {
try {	
DynamicArrayStack stack = new DynamicArrayStack();
System.out.println("SIZE: "+stack.size());
System.out.println("CAPACITY: "+stack.capacity);
System.out.println("STACK: "+stack);	
//System.out.println("POP: "+stack.pop());
System.out.println("\n\n PUSHING ELEMENTS: ");
stack.push(34);
stack.push(65);
stack.push(12);
stack.push(78);
stack.push(54);
stack.push(79);
System.out.println("\nSIZE: "+stack.size());
System.out.println("CAPACITY: "+stack.capacity);
System.out.println("STACK: "+stack);	

System.out.println("\n\n PUSHING ELEMENTS: ");
stack.push(22);
stack.push(33);
stack.push(44);
stack.push(77);
stack.push(34);
stack.push(88);
System.out.println("\nSIZE: "+stack.size());
System.out.println("CAPACITY: "+stack.capacity);
System.out.println("STACK: "+stack);	

stack.push(44);
stack.push(77);
stack.push(34);
stack.push(88);
System.out.println("\nSIZE: "+stack.size());
System.out.println("CAPACITY: "+stack.capacity);
System.out.println("STACK: "+stack);	

stack.push(34);
stack.push(88);
System.out.println("\nSIZE: "+stack.size());
System.out.println("CAPACITY: "+stack.capacity);
System.out.println("STACK: "+stack);	

System.out.println("\n\nPOPING ELEMENTS: ");
for(int i = 1;i<=10;i++)
	stack.pop();

System.out.println("\nSIZE: "+stack.size());
System.out.println("CAPACITY: "+stack.capacity);
System.out.println("STACK: "+stack);	
}catch(Exception e) {
	e.printStackTrace();
}
}
}
