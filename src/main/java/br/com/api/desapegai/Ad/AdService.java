package br.com.api.desapegai.Ad;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AdService {
    private final AdRepository adRepository;

    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public List<Ad> getAllAds() {
        Iterable<Ad> adIterable = adRepository.findAll();
        List<Ad> adList = new ArrayList<>();
        adIterable.forEach(adList::add);
        return adList;
    }

    public Ad getAdById(Long id) {
        return adRepository.findById(id).orElse(null);
    }

    public Ad createAd(Ad adModel) {
        return adRepository.save(adModel);
    }

    public Ad updateAd(Long id, Ad adModel) {
        if (adRepository.existsById(id)) {
            adModel.setId(id);
            return adRepository.save(adModel);
        }
        return null;
    }

    public boolean deleteAd(Long id) {
        if (adRepository.existsById(id)) {
            adRepository.deleteById(id);
            return true;
        }
        return false;
    }
}