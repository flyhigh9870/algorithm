import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean visited[];
	static int min= Integer.MAX_VALUE;
	//static int ans[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n];
		for(int i = 0; i <n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0]=true;
		dfs(1,0,0);
		
		if(min== Integer.MAX_VALUE)
			min = 0;
		System.out.println(min);
		
	}
	private static void dfs(int cnt,int before,int len) {
		if(len>min) return;
		if(cnt == arr.length) {
			if(arr[before][0]==0)
				return;
			if(len+arr[before][0]<min)
				min = len+arr[before][0];
			return;
		}
		for(int i = 1; i<arr.length; i++) {
			if(visited[i]) continue;
			if(arr[before][i]==0)continue;
			visited[i]= true;
			dfs(cnt+1,i,len+arr[before][i]);
			visited[i] = false;
			
		}
		
	}
	

}
