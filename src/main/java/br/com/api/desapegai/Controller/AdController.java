package br.com.api.desapegai.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.desapegai.Model.Ad;
import br.com.api.desapegai.Model.Category;
import br.com.api.desapegai.Service.AdService;
import br.com.api.desapegai.Service.CategoryService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

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
    public String createAd(@ModelAttribute Ad ad, @RequestParam Long userId, Model model, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        try {
            String originalFileName = multipartFile.getOriginalFilename();
            String fileExtension = "";
            
            if (originalFileName != null && originalFileName.contains(".")) {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            }
            
            String fileName = UUID.randomUUID().toString() + "_" + fileExtension;
            ad.setPhotos(fileName);
            Ad savedad = adService.createAd(ad, userId);
     
            String uploadDir = "src/main/resources/static/ad-images/" + savedad.getId();
            Path uploadPath =  Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try(InputStream inputStream = multipartFile.getInputStream()){
                Path filepPath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filepPath, StandardCopyOption.REPLACE_EXISTING);
            } catch(IOException e){
                throw new IOException("Não foi possivel salvar a imagem: " + fileName);
            }
             
            adService.createAd(ad, userId);
            return "redirect:/anuncios";
        } catch (Exception e) {
            model.addAttribute("error", "Ocorreu um erro ao criar o anúncio: " + e.getMessage());

            return "redirect:/anuncios/novo_anuncio"; 
            // criar uma pagina para quando se da um erro de criacao de anuncio
        }
    }

}
