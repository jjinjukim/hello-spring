package hello.hellospring.repository;

import hello.hellospring.domain.Menber;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Menber> store = new HashMap<>();
    private static long sequence = 0l;


    @Override
    public Menber save(Menber menber) {
        menber.setId(++sequence);
        store.put(menber.getId(), menber);
        return menber;
    }

    @Override
    public Optional<Menber> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Menber> findByName(String name) {
        return store.values().stream().filter(menber -> menber.getName().equals(name)).findAny();
    }

    @Override
    public List<Menber> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
