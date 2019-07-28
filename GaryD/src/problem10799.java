import java.util.Scanner;
import java.util.Stack;

/*
	���� ���� �踷��⸦ �������� �����Ϸ��� �Ѵ�. ȿ������ �۾��� ���ؼ� �踷��⸦ �Ʒ����� ���� ���� ����, �������� ������ �������� �߻��Ͽ� �踷������ �ڸ���. �踷���� �������� ��ġ�� ���� ������ �����Ѵ�.
�踷���� �ڽź��� �� �踷��� ������ ���� �� �ִ�. - �踷��⸦ �ٸ� �踷��� ���� ���� ��� ������ ���Եǵ��� ����, ������ ��ġ�� �ʵ��� ���´�.
�� �踷��⸦ �ڸ��� �������� ��� �ϳ� �����Ѵ�.
�������� � �踷����� �� �������� ��ġ�� �ʴ´�. 
�Ʒ� �׸��� �� ������ �����ϴ� ���� �����ش�. �������� �׷��� ���� �Ǽ��� �踷����̰�, ���� �������� ��ġ, �������� �׷��� ���� ȭ��ǥ�� �������� �߻� �����̴�.

�̷��� �������� �踷����� ��ġ�� ������ ���� ��ȣ�� �̿��Ͽ� ���ʺ��� ������� ǥ���� �� �ִ�.
�������� ���� ��ȣ�� �ݴ� ��ȣ�� ������ �� ��( ) �� ���� ǥ���ȴ�. ����, ��� ��( ) ���� �ݵ�� �������� ǥ���Ѵ�.
�踷����� ���� ���� ���� ��ȣ �� ( �� ��, ������ ���� ���� ��ȣ ��) �� �� ǥ���ȴ�. 
�� ���� ��ȣ ǥ���� �׸� ���� �־��� �ִ�.
�踷���� �������� ���� �� ���� �������� �߷����µ�, �� ������ ���� ���� �ִ� �� ���� �踷���� ���� 3���� 2���� �������� �߷�����, �̿� ���� ������� �־��� �踷������ �� 17���� �������� �߷�����. 
�踷���� �������� ��ġ�� ��Ÿ���� ��ȣ ǥ���� �־����� ��, �߷��� �踷��� ������ �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/
public class problem10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack st = new Stack();
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				st.push('(');
			} else if (str.charAt(i) == ')') {
				if (str.charAt(i - 1) == '(') {
					st.pop();
					result += st.size();
				} else {
					st.pop();
					result += 1;
				}
			}
		}
		System.out.println(result);
	}
}