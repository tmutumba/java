
public class BinarySearchRecursive {
	
	public static boolean BinarySearch(int h,int l,int x,int []A){
		boolean found = false;
		while(h > l){
			int mid = (int)(l+h)/2;
			if(A[mid]==x){
				System.out.println("Item is foud at"+mid);
				found = true;
				return found;
			}else if(A[mid] > x){
				int min = mid;
				BinarySearch(mid-1,l,x,A);
				break;
				// BinarySearch(h,l,x); 
			}else{
				BinarySearch(h,mid+1,x,A);
				
			}
			break;
		}
		return found;
	}
	public static void main(String[]args){
		int[] A = {2,4,6,8,10};
		BinarySearch(5,1,4,A);
	}
}
