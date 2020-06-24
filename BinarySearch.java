
public class BinarySearch {
	 public static void main(String[]args){
		 int [] B = {2,4,6,8,10};
		 BinarySearch obj = new BinarySearch();
		 obj.binarySearch(1, 5, B, 4);
	 }
	 public void binarySearch(int l,int h,int [] A,int target){
		 
		 while(l < h){
			 int mid = (int)(l+h)/2;
			 if(target == A[mid]){
				 System.out.println("Item is found at");
				 return;
			 }else if(target < A[mid]){
				 h = mid = -1;
			 }else{
				 l = mid + 1;
			 }
		 }
		 System.out.println("Item is not in the list");
	 }
}
