package com.aldoj.tripplaniaapi.models;

import org.springframework.ai.openai.api.OpenAiApi;

import java.util.List;

public record GPTResponseDTO(List<OpenAiApi.ChatCompletion.Choice> choices) {

}