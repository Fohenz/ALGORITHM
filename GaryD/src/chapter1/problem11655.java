package chapter1;
import java.util.Arrays;
import java.util.Scanner;

/*
ROT13�� ī�̻縣 ��ȣ�� �������� ���� ���ĺ��� 13���ھ� �о �����.
���� ���, "Baekjoon Online Judge"�� ROT13���� ��ȣȭ�ϸ� "Onrxwbba Bayvar Whqtr"�� �ȴ�. 
ROT13���� ��ȣȭ�� ������ ���� �������� �ٲٷ��� ��ȣȭ�� ���ڿ��� �ٽ� ROT13�ϸ� �ȴ�. 
�տ��� ��ȣȭ�� ���ڿ� "Onrxwbba Bayvar Whqtr"�� �ٽ� ROT13�� �����ϸ� "Baekjoon Online Judge"�� �ȴ�.
ROT13�� ���ĺ� �빮�ڿ� �ҹ��ڿ��� ������ �� �ִ�. ���ĺ��� �ƴ� ���ڴ� ���� ���� �״�� ���� �־�� �Ѵ�. 
���� ���, "One is 1"�� ROT13���� ��ȣȭ�ϸ� "Bar vf 1"�� �ȴ�.
���ڿ��� �־����� ��, "ROT13"���� ��ȣȭ�� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/
public class problem11655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char chArr[] = str.toCharArray();
		
		for (int i = 0; i < chArr.length; i++) {
			if (chArr[i] >= 'a' && chArr[i] <= 'm')
				chArr[i] += 13;
			else if (chArr[i] >= 'n' && chArr[i] <= 'z')
				chArr[i] -= 13;
			else if (chArr[i] >= 'A' && chArr[i] <= 'M')
				chArr[i] += 13;
			else if (chArr[i] >= 'N' && chArr[i] <= 'Z')
				chArr[i] -= 13;
		}
		
		for (int i = 0; i < chArr.length; i++) {
			System.out.print(chArr[i]);
		}
	}
}
