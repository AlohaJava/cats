package github.sech530.cats.Repository;

import github.sech530.cats.Models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CatRepository extends JpaRepository<Cat, Integer> {
}