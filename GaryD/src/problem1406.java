/*	
	�� �ٷ� �� ������ �����͸� �����Ϸ��� �Ѵ�. �� ������� ���� �ҹ��ڸ��� ����� �� �ִ� �������, �ִ� 600,000���ڱ��� �Է��� �� �ִ�.
�� �����⿡�� 'Ŀ��'��� ���� �ִµ�, Ŀ���� ������ �� ��(ù ��° ������ ����), ������ �� ��(������ ������ ������), �Ǵ� ���� �߰� ������ ��(��� ���ӵ� �� ���� ����)�� ��ġ�� �� �ִ�. �� ���̰� L�� ���ڿ��� ���� �����⿡ �ԷµǾ� ������, Ŀ���� ��ġ�� �� �ִ� ���� L+1���� ��찡 �ִ�.
�� �����Ⱑ �����ϴ� ��ɾ�� ������ ����.
L
Ŀ���� �������� �� ĭ �ű� (Ŀ���� ������ �� ���̸� ���õ�)
D
Ŀ���� ���������� �� ĭ �ű� (Ŀ���� ������ �� ���̸� ���õ�)
B
Ŀ�� ���ʿ� �ִ� ���ڸ� ������ (Ŀ���� ������ �� ���̸� ���õ�)
������ ���� Ŀ���� �� ĭ �������� �̵��� ��ó�� ��Ÿ������, ������ Ŀ���� �����ʿ� �ִ� ���ڴ� �״����
P $
$��� ���ڸ� Ŀ�� ���ʿ� �߰���
�ʱ⿡ �����⿡ �ԷµǾ� �ִ� ���ڿ��� �־�����, �� ���� �Է��� ��ɾ ���ʷ� �־����� ��, ��� ��ɾ �����ϰ� �� �� �����⿡ �ԷµǾ� �ִ� ���ڿ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, ��ɾ ����Ǳ� ���� Ŀ���� ������ �� �ڿ� ��ġ�ϰ� �ִٰ� �Ѵ�.
*/

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;


public class problem1406 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack leftSt = new Stack();
		Stack rightSt = new Stack();
		Iterator it1, it2;
		
		String alph = sc.nextLine();
		
		for (int i = 0; i < alph.length(); i++) {
			leftSt.push(alph.charAt(i));
		}
		
		int cnt = sc.nextInt();
		
		for (int i = 0; i <= cnt; i++) {
			String b = sc.nextLine();
			String[] c = b.split(" ");
			
			if(c[0].equals("P")) {
				leftSt.push(c[1]);
			}else {
				if(b.equals("L")) {
					if(leftSt.size() != 0) {
						rightSt.add(0, leftSt.pop());
					}
				}else if(b.equals("D")) {
					if(rightSt.size() != 0) {
						leftSt.push(rightSt.pop());
					}
				}else if(b.equals("B")) {
					if(leftSt.size() != 0) {
						leftSt.pop();
					}
				}
			}
			//print(leftSt, rightSt);
		}
		it1 = leftSt.iterator();
		it2 = rightSt.iterator();
		
		while(it1.hasNext()) {
			System.out.print(it1.next());
		}
		
		while(it2.hasNext()) {
			System.out.print(it2.next());
		}
	}
	
	public static void print(Stack left, Stack right) {
		System.out.println(left.toString());
		System.out.println(right.toString());
	}
}
