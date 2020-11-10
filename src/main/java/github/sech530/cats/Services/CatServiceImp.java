package github.sech530.cats.Services;

import github.sech530.cats.Models.Cat;
import github.sech530.cats.Repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImp implements CatService {
    private CatRepository repository;

    @Autowired
    public void setCatRepository(CatRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Cat cat) {
        repository.save(cat);
    }

    @Override
    public List<Cat> getAll() {
        return repository.findAllByOrderByAgeAsc();
    }

    @Override
    public Cat getById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void update(Cat cat) {
        Cat oldCat = repository.findById(cat.getId()).orElseThrow();
        oldCat.setAge(cat.getAge());
        oldCat.setName(cat.getName());
        repository.save(oldCat);
    }

    @Override
    public void delete(int id) {
        Cat cat = repository.findById(id).orElseThrow();
        repository.delete(cat);
    }
}
