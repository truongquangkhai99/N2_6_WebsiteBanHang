package laptrinhweb.service;

import java.util.List;

import laptrinhweb.model.Member;

public interface MemberService {

	void add(Member member);

	void edit(Member member);

	void delete(int idM);

	Member getById(int idM);

	Member getByUsername(String username);

	List<Member> getAll();

	boolean checkLogin(String u, String p);
}
