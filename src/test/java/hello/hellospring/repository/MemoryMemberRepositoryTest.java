package hello.hellospring.repository;

import hello.hellospring.domain.Menber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository() ;
//    MemoryMemberRepository repository = new MemoryMemberRepository() ;

        @AfterEach
        public void afterEach() {
            repository.clearStore();
        }

        @Test
        public void save() {
            Menber member = new Menber();
            member.setName("Spring");
            repository.save(member);

            Menber result = repository.findById(member.getId()).get();
//            System.out.println("(result == member) = " + (result == member));
//            Assertions.assertEquals(result,member);
            assertThat(member).isEqualTo(result);
        }

        @Test
        public void findByName(){
            Menber menber1 = new Menber();
            menber1.setName("Spring1");
            repository.save(menber1);

            Menber menber2 = new Menber();
            menber2.setName("Spring2");
            repository.save(menber2);

           Menber result = repository.findByName("Spring1").get();
            assertThat(result).isEqualTo(menber1);
        }

        @Test
        public void findAll(){
            Menber menber1 = new Menber();
            menber1.setName("spring1");
            repository.save(menber1);

            Menber menber2 = new Menber();
            menber2.setName("spring1");
            repository.save(menber2);

            List<Menber> result = repository.findAll();
            assertThat(result.size()).isEqualTo(2);
        }
}
