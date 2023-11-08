package br.com.api.desapegai.Service;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.desapegai.Model.Ad;

import br.com.api.desapegai.Model.User;
import br.com.api.desapegai.Repository.AdRepository;
import br.com.api.desapegai.Repository.UserRepository;


import java.util.List;

@Service
public class AdService {
    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    public Ad createAd(Ad ad, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User seller = userOptional.get();
            ad.setSeller(seller);
            ad.setPublicationDate(new Date());
            return adRepository.save(ad);
        } else {
            return null; // Trate o caso em que o usuário não foi encontrado
        }
    }

    public List<Ad> getAllAds() {
        return adRepository.findAll();
    }

    public Ad getAdById(Long id) {
        return adRepository.findById(id).orElse(null);
    }

    public Ad updateAd(Long id, Ad updatedAd) {
        Optional<Ad> adOptional = adRepository.findById(id);
        if (adOptional.isPresent()) {
            Ad existingAd = adOptional.get();
            // Realize as operações de atualização necessárias
            // Por exemplo, atualizar o título, descrição, preço, etc.
            // Você deve implementar essas operações com base nos requisitos do seu aplicativo
            return adRepository.save(existingAd);
        } else {
            return null; // Trate o caso em que o anúncio não foi encontrado
        }
    }

    public void deleteAd(Long id) {
        adRepository.deleteById(id);
    }
}


