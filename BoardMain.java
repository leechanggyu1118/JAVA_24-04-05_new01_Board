package board;

import java.util.Scanner;


public class BoardMain {

	public static void main(String[] args) {
		/* Board class 생성
		 * 번호, 제목, 내용, 작성자, 작성일
		 * - 번호 : 객체 생성 시 자동으로 증가
		 * - 작성일 : 오늘날짜로 자동생성
		 * - 번호가 일치하면 같은 게시물로 인지 equals 추가
		 * 
		 * -menu
		 * 1.게시글추가 | 2.게시글검색 | 3.게시글수정 
		 * 4.게시글삭제 | 5.게시글출력 | 6.종료
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		BoardManager b = new BoardManager();
		b.printMenu(scan);

		
		scan.close();

	}

}
