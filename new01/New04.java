package new01;

import java.util.HashMap;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		/* 단어장
		 * 단어 : 의미
		 * map으로 생성
		 * 입력받을 단어의 갯수를 입력받아 개수만큼 map에 추가
		 * 콘솔에 찍기
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> voka = new HashMap<String, String>();
		System.out.println("작성할 단어의 갯수를 입력해주세요");
		int num = scan.nextInt();
		int cnt = 0;
		do {
			System.out.println("영어단어를 입력해주세요");
			String a = scan.next();
			System.out.println("의미를 입력해주세요");
			String b = scan.next();
			voka.put(a, b);
			cnt++;
		}while(cnt != num);
		System.out.println("단어장");
		for(String a : voka.keySet()) {
			System.out.println(a+" : "+voka.get(a));
			
		}
		
		scan.close();
	}

}
