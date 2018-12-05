package binaryString;

public class BinaryString {
public static void main(String[] args) {
char[] cArr = new char[4];
printBinary(4,cArr);
}
public static void printBinary(int n,char[] cArr) {
	if(n<1)
		System.out.println(cArr);
	else {
		cArr[n-1]='0';
		printBinary(n-1,cArr);
		cArr[n-1]='1';
		printBinary(n-1,cArr);
	}
	
}
}
