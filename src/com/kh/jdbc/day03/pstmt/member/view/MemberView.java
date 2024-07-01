package com.kh.jdbc.day03.pstmt.member.view;

import java.util.Scanner;

import com.kh.jdbc.day03.pstmt.member.controller.MemberController;
import com.kh.jdbc.day03.pstmt.member.model.vo.Member;

public class MemberView {
	MemberController mController;

	private int mainMenu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 회원 관리 프로그램 ======");
		System.out.println("1. 회원 가입");
		System.out.println("2. 로그인");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 탈퇴");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		int input = sc.nextInt(); // 호출하는 곳에서 쓰니까 return input
	
		return input;
	}

	public MemberView() {
		mController = new MemberController();
	}

	public void startProgram() {
		finish: while (true) {
			int choice = this.mainMenu();
			switch (choice) {
			// 1. 회원가입
			// 회원 정보를 입력 받은 후 입력 받은 정보를 객체에 저장한 후
			// 객체를 컨트롤러로 전달
			case 1:
				Member member = this.inputInfo();
				System.out.println(member.toString());
				int result = mController.registerMember(member);
				if (result > 0) {
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("회원가입 실패ㅠㅠ");
				}
				break;
			// 2. 로그인
			// 로그인 정보(아이디 패스워드) 받기
			// 입력한 ID와 PW가 DB에 있는 지 확인
			case 2:
				member = this.inputLoginInfo(); // 로그인 정보 받음
				member = mController.checkLogin(member);
				if (member != null) {
					this.printOneMember(member);
				} else {
					printMessage("존재하지 않는 정보입니다. ");
				}
				break;
			// 3. 회원정보 수정
			case 3:
				String memberId = inputMemberId();
				member = mController.checkMember(memberId);
				if(member !=null) {
					member = modifyMember();
					member.setMemberId(memberId);
					result = mController.updateMember(member);
					if(result>0) {
						printMessage("정보 수정 성공!");
					}
				}else {
					printMessage("존재하지 않는 정보입니다. ");
				}
				break;
			//4. 회원탈퇴
			case 4:
				memberId = inputMemberId();
				member = mController.checkMember(memberId);
				if(member != null) {
					result = mController.removeMember(memberId);
					if(result>0) {
						this.printMessage("삭제 성공!");
					}
			
				}else {
					printMessage("존재하지 않는 정보입니다.");
				}

				break;

			case 5:
				break;
			case 6:
				break;
			case 9:
				printMessage("프로그램 종료");
				break finish;
			case 0:
				break;

			}
		}
	}

	private Member modifyMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 회원 정보 수정 =======");
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미 : ");
		String hobby = sc.nextLine();
		Member member = new Member(memberPw, email, phone, address, hobby);
		return member;

	}

	private String inputMemberId() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" 아이디 입력 : ");
		String memberId = sc.next();
		return memberId;
	}

	private Member inputInfo() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 회원 정보 입력 ======");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("성별 : ");
		String gender = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미 : ");
		String hobby = sc.nextLine();
// 리턴 여러개가 안되니까 객체를 이용
		Member member = new Member(memberId, memberPw, memberName, gender, age, email, phone, address, hobby, null);
		return member;
	}

	private void printOneMember(Member member) {
		// TODO Auto-generated method stub
		System.out.println("========회원정보 출력========");
		System.out.printf(
				"이름 : %s\t 나이 : %s\t 아이디 : %s\t 성별 : %s\t 이메일 : %s\t 전화번호 : %s\t 주소 : %s\t 취미 : %s\t 가입날짜 : %s\n ",
				member.getMemberName(), member.getAge(), member.getMemberId(), member.getGender(), member.getEmail(),
				member.getPhone(), member.getAddress(), member.getHobby(), member.getRegDate());

	}

	private Member inputLoginInfo() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 회원 정보 입력 ======");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		// 리턴 여러개 안되니까 객체이용
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		return member;
	}

	private void printMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("[결과] : " + message);
	}
}
