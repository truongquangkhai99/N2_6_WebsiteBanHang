package laptrinhweb.service.impl;

import java.util.List;

import laptrinhweb.dao.MemberDAO;
import laptrinhweb.dao.impl.MemberDAOImpl;
import laptrinhweb.model.Member;
import laptrinhweb.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public void add(Member member) {
		memberDAO.add(member);
	}

	@Override
	public void edit(Member member) {
		memberDAO.edit(member);
	}

	@Override
	public void delete(int idM) {
		memberDAO.delete(idM);
	}

	@Override
	public Member getById(int idM) {
		return memberDAO.getById(idM);
	}

	@Override
	public List<Member> getAll() {
		return memberDAO.getAll();
	}

	@Override
	public boolean checkLogin(String u, String p) {
		for (Member member : memberDAO.getAll()) {
			if (member.getUsername().equals(u) && member.getPasswrod().equals(p))
				return true;
		}
		return false;
	}

	@Override
	public Member getByUsername(String username) {
		for (Member member : memberDAO.getAll()) {
			if (member.getUsername().equals(username) )
				return member;
		}
		return null;
	}

}
