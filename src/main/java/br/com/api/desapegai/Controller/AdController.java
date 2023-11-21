package br.com.api.desapegai.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.com.api.desapegai.Model.Ad;
import br.com.api.desapegai.Model.Category;
import br.com.api.desapegai.Service.AdService;
import br.com.api.desapegai.Service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/anuncios")
public class AdController {

    private final AdService adService;

    private final CategoryService categoryService;
    

    public AdController(AdService adService, CategoryService categoryService) {
        this.adService = adService;
        this.categoryService = categoryService;
    }

    @GetMapping("/novo_anuncio")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        List<Category> categories = categoryService.getAllCategories(); // Supondo que você tenha um serviço para obter todas as categorias
        Ad ad= new Ad();
        model.addAttribute("ad", ad);
        model.addAttribute("categories", categories);
        return "create_ad";
    }

    @GetMapping
    public String getAllAds(Model model) {
        List<Ad> ads = adService.getAllAds();
        model.addAttribute("ads", ads);
        return "ad-list"; // Renderiza uma página HTML com a lista de anúncios
    }

    @GetMapping("/{id}")
    public String getAdById(@PathVariable Long id, Model model) {
        Ad ad = adService.getAdById(id);
        model.addAttribute("ad", ad);
        return "ad-details"; // Renderiza uma página HTML com os detalhes do anúncio
    }





    @PostMapping("/novo_anuncio/save")
public String createAd(@ModelAttribute Ad ad, @RequestParam Long userId) {
    adService.createAd(ad, userId);
    return "redirect:/anuncios"; // Redireciona para a lista de anúncios após a criação
}

}
