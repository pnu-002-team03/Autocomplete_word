package word_store;
import java.util.*;
public class Store_test1 {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] keywordDB = {"롯데","롯데자이언츠","한화","한화이글스"};
		//이후에 사용자가 사용한 단어가 저장된 sqlite3를 이욯한 DB부분으로 대체
		String userinput;
		Scanner reader = new Scanner(System.in);
		userinput=reader.next();
		reader.close();
		
		for(int i =0; i<keywordDB.length;i++)
		{
			System.out.println(keywordDB[i]+" 와 입력한 단어와의 유사도: "+String.valueOf(levenshtein(userinput,keywordDB[i])));
		}
		//이후에 실시간으로 사용자가 쓰고있는 단어를 변환하여 이값에 저장
	}
	
	static int levenshtein(String userinput,String keyword) {
		int[][] dist = new int[1001][1001];
		for(int i = 1;i<=userinput.length();i++)
			dist[i][0]=i;
		for(int j = 1;j<=keyword.length();j++)
			dist[0][j]=j;
		
		for(int j =1; j<=keyword.length();j++) {
			for(int i =1; i <=userinput.length();i++) {
				if(userinput.charAt(i-1)==keyword.charAt(j-1)) {
					dist[i][j]=dist[i-1][j-1];
				}
				else {
					dist[i][j]=Math.min(dist[i-1][j-1]+1,Math.min(dist[i][j-1],dist[i-1][j]+1));
				}
					
			}
		}
		return dist[userinput.length()][keyword.length()];		
	}//편집거리 알고리즘을통해 저장되있는 키워드와 지금 쓰고있는 글자와의 유사도 비교
}



