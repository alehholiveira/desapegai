package br.com.api.desapegai.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleMapsService {

    @Value("${google.maps.api.key}")
    private String apiKey;

    public String sugerirPontoEncontro(String cepVendedor, String cepUsuario) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        try {
            // Obtenha as coordenadas do CEP do vendedor
            GeocodingResult[] resultVendedor = GeocodingApi.geocode(context, cepVendedor).await();
            LatLng latLngVendedor = resultVendedor[0].geometry.location;

            // Obtenha as coordenadas do CEP do usuário
            GeocodingResult[] resultUsuario = GeocodingApi.geocode(context, cepUsuario).await();
            LatLng latLngUsuario = resultUsuario[0].geometry.location;

            // Calcule o ponto médio (ou use lógica específica para sugerir um ponto de encontro)
            double latMedia = (latLngVendedor.lat + latLngUsuario.lat) / 2;
            double lngMedia = (latLngVendedor.lng + latLngUsuario.lng) / 2;

            // Realiza a geocodificação inversa para obter o endereço do ponto médio
            GeocodingResult[] resultPontoEncontro = GeocodingApi.reverseGeocode(context, new LatLng(latMedia, lngMedia)).await();
            return resultPontoEncontro[0].formattedAddress;
        } catch (Exception e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }

        return null;
    }

    public String obterEnderecoPorCEP(String cep) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        try {
            // Use um serviço de geocodificação para obter as coordenadas a partir do CEP
            GeocodingResult[] results = GeocodingApi.geocode(context, cep).await();

            if (results != null && results.length > 0) {
                return results[0].formattedAddress;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }

        return null;
    }
}
