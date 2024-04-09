package board;

import java.util.Scanner;

public interface BoardInterface {
	/* -menu 
	 * 1.게시글추가 | 2.게시글검색 | 3.게시글수정 
	 * 4.게시글삭제 | 5.게시글출력 | 6.종료
	 * 
	 */
	void addBoard(Scanner scan);
	void searchBoard(Scanner scan);
	void modifyBoard(Scanner scan);
	void removeBoard(Scanner scan);
	void printBoard(Scanner scan);
	void printMenu(Scanner scan);
	
}
