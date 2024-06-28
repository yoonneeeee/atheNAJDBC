package com.kh.jdbc.day02.member.controller;

import java.util.List;
import com.kh.jdbc.day02.member.mode.vo.Member;
import com.kh.jdbc.day02.member.model.dao.MemberDAO;

public class MemberController {
	
	MemberDAO mDao; 
	
	public MemberController() {
		mDao = new MemberDAO();
	}

	public void insertMember(Member member) {
		mDao.insertMember(member);
	}
		// List 임포트 : 컨트롤
	public List<Member> printAllMember() {
		//  여러개니까 List, 멤버니까 List<Member>
		List<Member> mList = mDao.selectList();
		// 호출한 곳에서 써야하나까 return MemberView : 35
		return mList;
	}
			// 뷰가 준 것 받아야 하니까 printOneMember(string memberId)
	public Member printOneMember(String memberId) {
			// 한개니까 List없어도 됨, Member
			// DAO로 전달해야하니까 selectOne(memberId)
		Member member = mDao.selectOne(memberId);
			// 호출한 곳에서 써야되니까 return member, memberview : 44
		return member;
	}
	public int modifyMember(Member modifyInfo) {
		// DML의 결과는 int 니까 int result
		// memberId 전달해야하니까 updateMember(modifyInfo)
		int result = mDao.updateMember(modifyInfo);
		return result;
	}

	// View 에서 memberId값 받아야하니까 removeMember(String memberID)
	// 리턴하는 값의 자료형이 인트니까 void 대신 int
	public int removeMember(String memberId) {
		// DML의 결과는 int 니까 int result
		// memberId 전달해야하니까 deleteMember(memberId)
		int result = mDao.deleteMember(memberId);
		// 호출한 곳에서 써야되니까 리턴 리전트
		return result;
	}


}