package br.com.api.desapegai.Category;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategories() {
        Iterable<CategoryModel> categoriesIterable = categoryRepository.findAll();
        return StreamSupport.stream(categoriesIterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
