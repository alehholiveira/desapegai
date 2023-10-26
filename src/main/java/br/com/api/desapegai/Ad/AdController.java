package br.com.api.desapegai.Ad;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public List<Ad> getAllAds() {
        return adService.getAllAds();
    }

    @GetMapping("/{id}")
    public Ad getAdById(@PathVariable Long id) {
        return adService.getAdById(id);
    }

    @PostMapping
    public Ad createAd(@RequestBody Ad adModel) {
        return adService.createAd(adModel);
    }

    @PutMapping("/{id}")
    public Ad updateAd(@PathVariable Long id, @RequestBody Ad adModel) {
        return adService.updateAd(id, adModel);
    }

    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
    }
}