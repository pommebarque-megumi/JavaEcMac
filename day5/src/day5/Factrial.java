package day5;

import java.util.ArrayList;

public class Factrial {

	public static void main(String[] args) {
		int n=5;
		int ans=factrial(n);
		System.out.println(ans);
		System.out.println(factrial2(5));
		System.out.println(factrial1(5));
		int n1=3315;
		int n2=8177;
		 tileLength(n1,n2);
		//System.out.printf("1辺が%dcmのタイルを%d枚使って埋めます。%n",tile,(n1/tile)*(n2/tile));
	}
	static int factrial(int n) {
		int ans=n;
		int i=1;
		while(true) {
			ans=ans*(n-i);
			i++;
			if(i>=n) {
				break;
			}
		}
		return ans;
	}
	static int factrial2(int n) {
		int result=n;
		for(int i=n-1 ; i>0 ; i--) {
			result*= i;
		}
		return result;
	}
	//recursivle(再帰処理)
	static int factrial1(int n) {
		if(n==1) {
			return n;
		}
		return n*factrial(n-1);
	}

	static void tileLength(int n1 , int n2) {
		int ans=0;
		ArrayList<Integer>nums1=new ArrayList<>();
		ArrayList<Integer>nums2=new ArrayList<>();
		ArrayList<Integer>nums3=new ArrayList<>();
		for(int i=1 ;i<n1 ; i++) {
			if(n1%i==0) {
				nums1.add(i);
			}
		}
		for(int i=1 ; i<n2 ; i++) {
			if(n2%i==0) {
				nums2.add(i);
			}
		}
		if(n1>n2) {
			ans=nums1.get(0)*nums2.get(nums2.size()-1);
			System.out.printf("%d,%d",nums1.get(0),nums2.get(nums2.size()-1));
		}else {
			ans=nums2.get(0)*nums1.get(nums1.size()-1);
			System.out.printf("%d,%d",nums2.get(0),nums1.get(nums1.size()-1));
		}
		for(int i=0 ; i<nums1.size() ; i++) {
			for(int j=0 ; j< nums2.size() ; j++) {
				if(nums1.get(i)==nums2.get(j)) {
						nums3.add(nums1.get(i));
				}
			}
		}
		//return ans;
	}
}
