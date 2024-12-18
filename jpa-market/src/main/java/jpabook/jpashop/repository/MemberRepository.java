package jpabook.jpashop.repository;

import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // private final EntityManager em = null;

    public void memberSave(Member member) {
        em.persist(member);
    }

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Member find(Long saveId) {
        return em.find(Member.class, saveId);
    }
}
