package stack.arraystacks;
public class TestFizedSizedArrayStack {
public static void main(String[] args) {
try {
FixedSizeArrayStack stack = new FixedSizeArrayStack();
System.out.println("SIZE: "+stack.size());
System.out.println("STACK: "+stack);	
System.out.println("POP: "+stack.pop());
//System.out.println("TOP: "+ stack.top());
stack.push(88);
stack.push(43);
stack.push(23);
stack.push(54);
stack.push(65);
System.out.println("\n\nSIZE: "+stack.size());
System.out.println("STACK: "+stack);	

System.out.println("\n\nTOP: "+stack.top());

System.out.println("\n\nPOP: "+stack.pop());
System.out.println("\n\nSIZE: "+stack.size());
System.out.println("STACK: "+stack);	

System.out.println("\n\nPUSHING SOME MORE ELEMENTS:");
stack.push(12);
stack.push(21);
stack.push(32);
stack.push(28);
stack.push(16);
stack.push(22);
System.out.println("SIZE: "+stack.size());
System.out.println("STACK: "+stack);	

//stack.push(11);


}catch(Exception e) {
	e.printStackTrace();
}
}
}
