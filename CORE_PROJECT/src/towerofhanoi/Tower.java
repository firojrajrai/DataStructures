package towerofhanoi;

public class Tower {
 public static void main(String[] args) {
TowersOfHanoi(20,'A','C','B');
 
}
 
 public static void TowersOfHanoi(int n,char frompeg, char topeg,char auxpeg) {
	if(n==1) {
		System.out.println("Move Disk 1 from peg "+frompeg +" to peg "+topeg);
		return;
	} 
	TowersOfHanoi(n-1,frompeg,auxpeg,topeg);
	System.out.println("Move disk from peg "+frompeg+" to peg "+topeg);
	 
	TowersOfHanoi(n-1, auxpeg, topeg, frompeg);
 }
}

