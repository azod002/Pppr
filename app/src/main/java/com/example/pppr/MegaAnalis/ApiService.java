package com.example.pppr.MegaAnalis;


import com.example.pppr.MegaAnalis.classes.ChatResponse;
import com.example.pppr.MegaAnalis.classes.PromptRequest;
import com.example.pppr.MegaAnalis.classes.PromptResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/prompt")
    Call<PromptResponse> sendPrompt(@Body PromptRequest promptRequest);
}
