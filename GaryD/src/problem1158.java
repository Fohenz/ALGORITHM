import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 �����۽� ������ ������ ����.
1������ N������ N���� ����� ���� �̷�鼭 �ɾ��ְ�, ���� ���� K(�� N)�� �־�����. 
���� ������� K��° ����� �����Ѵ�. �� ����� ���ŵǸ� ���� ������ �̷���� ���� ���� �� ������ ����� ������. 
�� ������ N���� ����� ��� ���ŵ� ������ ��ӵȴ�. ������ ������� ���ŵǴ� ������ (N, K)-�����۽� �����̶�� �Ѵ�. 
���� ��� (7, 3)-�����۽� ������ <3, 6, 2, 7, 5, 1, 4>�̴�.
N�� K�� �־����� (N, K)-�����۽� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 
 */
public class problem1158 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		Queue qu = new LinkedList();
		
		ArrayList result = new ArrayList();
		
		String[] strArr = str.split(" ");
		
		int length = Integer.parseInt(strArr[0]);
		int cnt = Integer.parseInt(strArr[1]);
		for (int i = 0; i < length; i++) {
			qu.add(i+1);          
		}
		
		int count = 1;
		while(true) {
			if(qu.size() == 1) {
				result.add(qu.poll());
				break;
			}
			
			if(count == cnt) {
				result.add(qu.poll());
				count = 0;
			}else {
				qu.add(qu.poll());
			}
			
			count++;
		}
		System.out.print("<");
		for (int i = 0; i < result.size(); i++) {
			if((i+1) == result.size()) {
				System.out.print(result.get(i));
			}else {
				System.out.print(result.get(i) + ", ");
			}
		}
		System.out.print(">");
	}
}
