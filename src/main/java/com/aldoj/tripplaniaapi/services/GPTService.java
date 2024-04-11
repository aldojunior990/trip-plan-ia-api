package com.aldoj.tripplaniaapi.services;

import com.aldoj.tripplaniaapi.models.GPTResponseDTO;
import com.aldoj.tripplaniaapi.models.TripRequestDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GPTService {
    @Value("${spring.ai.openai.api.key}")
    private String GPT_API_KEY;

    private OpenAiApi openAiApi;

    @PostConstruct
    public void init() {
        this.openAiApi = new OpenAiApi(GPT_API_KEY);
    }


    public ResponseEntity<GPTResponseDTO> generateRoadMap(TripRequestDTO tripRequestDTO) {
        var prompt = generatePrompt(tripRequestDTO);
        var message = new OpenAiApi.ChatCompletionMessage(prompt, OpenAiApi.ChatCompletionMessage.Role.USER);
        var response = openAiApi.chatCompletionEntity(new OpenAiApi.ChatCompletionRequest(List.of(message), "gpt-3.5-turbo", 0.8f, false));
        return ResponseEntity.ok(new GPTResponseDTO(Objects.requireNonNull(response.getBody()).choices()));
    }

    private String generatePrompt(TripRequestDTO tripRequestDTO) {

        return "Gere um markdown contendo um roteiro de viagem seguindo o seguinte template:\n " + "## Roteiro de Viagem de " + tripRequestDTO.countOfDays() + " dias para " + tripRequestDTO.destination() + "\n" + "## 1. Melhor tipo de viagem\n" + "\n" + "Fale sobre o melhor meio de viajar para o local partindo de " + tripRequestDTO.currentLocal() + "\n" + "## 2. Clima típico da região\n" + "\n" + "Fale sobre o clima típico da região na data de " + tripRequestDTO.travelDate() + "\n" + "## 3. Pontos turísticos ideais para se visitar na cidade\n" + "\n" + "Enumere os pontos turisticos da região seguindo o exemplo \n:" + "- **Ponto turístico 1**: Breve descrição\n" + "- **Ponto turístico 2**: Breve descrição \n" + "- **Ponto turístico 3**: Breve descrição";
    }

}
