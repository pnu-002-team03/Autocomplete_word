package word_store;
import java.util.*;
public class Store_test1 {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] keywordDB = {"�Ե�","�Ե����̾���","��ȭ","��ȭ�̱۽�"};
		//���Ŀ� ����ڰ� ����� �ܾ ����� sqlite3�� �̟G�� DB�κ����� ��ü
		String userinput;
		Scanner reader = new Scanner(System.in);
		userinput=reader.next();
		reader.close();
		
		for(int i =0; i<keywordDB.length;i++)
		{
			System.out.println(keywordDB[i]+" �� �Է��� �ܾ���� ���絵: "+String.valueOf(levenshtein(userinput,keywordDB[i])));
		}
		//���Ŀ� �ǽð����� ����ڰ� �����ִ� �ܾ ��ȯ�Ͽ� �̰��� ����
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
	}//�����Ÿ� �˰��������� ������ִ� Ű����� ���� �����ִ� ���ڿ��� ���絵 ��
}



