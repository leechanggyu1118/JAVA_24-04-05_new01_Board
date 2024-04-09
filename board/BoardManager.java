package board;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class BoardManager implements BoardInterface {
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
	
	ArrayList<Board> bL = new ArrayList<Board>();
	
	
	@Override
	public void addBoard(Scanner scan) {
		// 1.게시글추가
		System.out.println("게시글 추가를 시작합니다.");
		System.out.println("제목을 입력해주세요.");
		String title = scan.next();
		System.out.println("내용을 입력해주세요.");
		String text = scan.next();
		System.out.println("작성자를 입력해주세요.");
		String writer = scan.next();
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");
//		System.out.println(dtf.format(today));
		
		bL.add(new Board(bL.size()+1, title, text, writer, dtf.format(today)));
		System.out.println("게시글이 추가 되었습니다.");
		
	}

	@Override
	public void searchBoard(Scanner scan) {
		// 2.게시글검색
		System.out.println("검색할 게시글의 번호를 입력해주세요");
		int search = scan.nextInt();
		for(Board a : bL) {
			if(a.getNum() == search) {
				System.out.println(a);
				return;
			}
		}
		System.out.println("찾으시려는 번호의 게시물은 존재하지 않습니다.");
	}

	@Override
	public void modifyBoard(Scanner scan) {
		// 3.게시글수정 
		System.out.println("수정할 게시글의 번호를 입력해주세요");
		int search = scan.nextInt();
		for(Board a : bL) {
			if(a.getNum() == search) {
				System.out.println("수정할 게시글 => "+a);
				System.out.println("수정할 수 있는 게시글은");
				System.out.println("제목 | 내용 | 작성자 입니다.");
				System.out.println("수정하실 부분을 선택하여 입력해주세요.");
				String mf = scan.next();
				if(mf.equals("제목")) {
					System.out.println("제목 수정을 시작합니다.");
					System.out.println("수정하실 제목을 입력해주세요");
					String modify = scan.next();
					a.setTitle(modify);
					System.out.println("수정이 완료되었습니다.");
					System.out.println(a);
					return;
					
				}else if(mf.equals("내용")) {
					System.out.println("내용 수정을 시작합니다.");
					System.out.println("수정하실 내용을 입력해주세요");
					String modify = scan.next();
					a.setText(modify);
					System.out.println("수정이 완료되었습니다.");
					System.out.println(a);
					return;
					
				}else if(mf.equals("작성자")) {
					System.out.println("작성자 수정을 시작합니다.");
					System.out.println("수정하실 작성자를 입력해주세요");
					String modify = scan.next();
					a.setWriter(modify);
					System.out.println("수정이 완료되었습니다.");
					System.out.println(a);
					return;
				}
				
			}
		}
		System.out.println("찾으시려는 게시물은 존재하지 않습니다.");
		
	}

	@Override
	public void removeBoard(Scanner scan) {
		// 4.게시글삭제
		System.out.println("삭제할 게시글의 번호를 입력해주세요.");
		int search = scan.nextInt();
		for(Board a : bL) {
			if(a.getNum() == search) {
				System.out.println("삭제할 게시글 => "+a);
				System.out.println("정말로 삭제하시려면 '삭제' 를 입력해주세요");
				System.out.println("아니라면 '아니' 를 입력해주세요");
				String rm = scan.next();
				if(rm.equals("삭제")) {
					bL.remove(search-1);
					System.out.println("삭제되었습니다.");
					return;
					
				}else {
					System.out.println("취소되었습니다.");
					return;
				}
				
			}
		}
		System.out.println("찾으시려는 게시물은 존재하지 않습니다.");
		
	}

	@Override
	public void printBoard(Scanner scan) {
		// 5.게시글출력
		System.out.println("게시글을 출력합니다.");
		for(Board a : bL) {
			System.out.println(a);
		}
	}

	@Override
	public void printMenu(Scanner scan) {
		// 메뉴 선택
		int menu = 0;
		do {
			System.out.println("--------게시판--------");
			System.out.println("--menu--");
			System.out.println("1.게시글추가 | 2.게시글검색 | 3.게시글수정 ");
			System.out.println("4.게시글삭제 | 5.게시글출력 | 6.종료");
			System.out.println("메뉴를 선택해주세요>");
			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				addBoard(scan);
				break;
			case 2:
				searchBoard(scan);
				break;
			case 3:
				modifyBoard(scan);
				break;
			case 4:
				removeBoard(scan);
				break;
			case 5:
				printBoard(scan);
				break;

			default:
				break;
			}
		}while(menu != 6);
		System.out.println("시스템을 종료합니다.");
		
	}

}
