package com.example.pppr.MegaAnalis;

import com.example.pppr.MegaAnalis.classes.ChatRequest;
import com.example.pppr.MegaAnalis.classes.ChatResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OpenAIApi {
    @Headers("Content-Type: application/json")
    @POST("v1/chat/completions")
    Call<ChatResponse> getChatResponse(@Body ChatRequest request);
}
