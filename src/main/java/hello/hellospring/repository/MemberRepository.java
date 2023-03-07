package hello.hellospring.repository;

import hello.hellospring.domain.Menber;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Menber save(Menber menber);
    Optional<Menber> findById(long id);
    Optional<Menber> findByName(String name);
    List<Menber> findAll();
    void clearStore();
}
