package chapter5_sort;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class P2751 {
    
    public static void Swap(int[] arr,int first,int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public static void QuickSort(int[] arr,int left,int right) {
        if(left >= right) return;
        int pivot = arr[right];
        int l = left;
        int r = right-1;
        
        while(l <= r) {    // 교차하기 전까지 진행
            while(l<=r && arr[l]<=pivot) l++;
            while(l<=r && arr[r]>=pivot) r--;
            if(l<r) Swap(arr,l,r);
        }
        Swap(arr,l,right);
        QuickSort(arr,left,l-1);
        QuickSort(arr,l+1,right);
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[N];
        
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(br.readLine().trim());
        
        QuickSort(arr,0,N-1);
        
        for(int i=0;i<N;i++)
            sb.append(arr[i]+"\n");
        
        System.out.println(sb);
    }
}
