package isSorted;

public class TestSorted {
public static void main(String[] args) {
int[] arr = {12,34,45,78,56,67,89,97,98};	
int res=isArrayInSortedOrder(arr, arr.length-1);
	if(res==1)
		System.out.println("Array is Sorted");
	else
		System.out.println("Array is not Sorted");
}
public static int isArrayInSortedOrder(int[] A,int index) {
	if(A.length==1 || index==1)
		return 1;
	
	return (A[index-1] <A[index-2]?0:isArrayInSortedOrder(A, index-1));
}
}
