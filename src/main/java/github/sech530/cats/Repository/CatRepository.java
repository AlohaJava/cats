package github.sech530.cats.Repository;

import github.sech530.cats.Models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatRepository extends JpaRepository<Cat, Integer> {
    List<Cat> findAllByOrderByAgeAsc();
}