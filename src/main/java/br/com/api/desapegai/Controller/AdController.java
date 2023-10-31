package br.com.api.desapegai.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.com.api.desapegai.Model.Ad;
import br.com.api.desapegai.Service.AdService;


import java.util.List;

@Controller
@RequestMapping("/anuncios")
public class AdController {

    private final AdService adService;
    

    public AdController(AdService adService) {
        this.adService = adService;
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

    @GetMapping("/create")
    public String showAdCreationForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ad-creation"; // Renderiza uma página HTML para criar um anúncio
    }

    @PostMapping("/create")
public String createAd(@ModelAttribute Ad ad, @RequestParam Long userId) {
    adService.createAd(ad, userId);
    return "redirect:/anuncios"; // Redireciona para a lista de anúncios após a criação
}

}
