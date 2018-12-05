package kary;
public class KAryString {
public static void main(String[] args) {
char[] cArr = {'A','B','C'};
 printString(4,4,cArr); 	
	
}
public static void printString(int n,int k,char cArr[]) {
	if(n<1)
		System.out.println(cArr);
	else
		for(int j=0;j<k;j++) {
			cArr[n-1]=cArr[j];
			printString(n-1,k,cArr);
		}
	
}
}
