package baekjoonPjt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2750 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] array = new int[n];
		
		for(int i=0;i<n;i++) {
			array[i] = Integer.parseInt(bf.readLine());
		}
		
		// ���� ����
		// �迭 [1]��° Key �� ���� 
		// Key �迭 ��ġ -1 �� ���Ͽ� ���� ����
		for(int i=1;i<array.length;i++) {
			int key = array[i];

			for(int j=i-1;j>=0;j--) {
				int num = array[j];
				
				if(num > key) {
					array[j] = key;
					array[j+1] = num;
				} 

			}
		}
		
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
}
