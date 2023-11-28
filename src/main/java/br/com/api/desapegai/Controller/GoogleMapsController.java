package br.com.api.desapegai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.api.desapegai.Service.GoogleMapsService;

@RestController
@RequestMapping("/api/maps")
public class GoogleMapsController {

    private final GoogleMapsService googleMapsService;

    @Autowired
    public GoogleMapsController(GoogleMapsService googleMapsService) {
        this.googleMapsService = googleMapsService;
    }

    @GetMapping("/address")
    public String obterEnderecoPorCEP(@PathVariable String cep) {
        return googleMapsService.obterEnderecoPorCEP(cep);
    }
}
