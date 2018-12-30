package laptrinhweb.dao;

import java.util.List;

import laptrinhweb.model.Member;

public interface MemberDAO {
	void add(Member member);

	void edit(Member member);

	void delete(int idM);

	Member getById(int idM);

	List<Member> getAll();
}
