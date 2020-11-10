package github.sech530.cats.Services;

import github.sech530.cats.Models.Cat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatService {
    void add(Cat cat);

    List<Cat> getAll();

    Cat getById(int id);

    void update(Cat cat);

    void delete(int id);
}
