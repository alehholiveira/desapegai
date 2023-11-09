package br.com.api.desapegai.Service;

import org.springframework.stereotype.Service;

import br.com.api.desapegai.Model.Category;
import br.com.api.desapegai.Repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        Iterable<Category> categoriesIterable = categoryRepository.findAll();
        return StreamSupport.stream(categoriesIterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
