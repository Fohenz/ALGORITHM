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
		Queue result = new LinkedList();
		
		String[] strArr = str.split(" ");
		
		int length = Integer.parseInt(strArr[0]);
		int count = Integer.parseInt(strArr[1]);
		
		for (int i = 0; i < length; i++) {
			qu.add(i+1);
		}
		
		System.out.println(length);
		System.out.println(count);
	}
}
