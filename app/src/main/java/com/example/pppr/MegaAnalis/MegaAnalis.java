package com.example.pppr.MegaAnalis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



import com.example.pppr.MegaAnalis.classes.ChatResponse;
import com.example.pppr.MegaAnalis.classes.PromptRequest;
import com.example.pppr.MegaAnalis.classes.PromptResponse;
import com.example.pppr.MegaAnalis.classes.dekart;
import com.example.pppr.MegaAnalis.classes.mpk;
import com.example.pppr.MegaAnalis.classes.swot;
import com.example.pppr.MegaAnalis.classes.tens;
import com.example.pppr.MegaAnalis.classes.zauprotiv;
import com.example.pppr.Methodics.dekartsquare;
import com.example.pppr.R;
import com.example.pppr.Room.database.AppDatabase;
import com.example.pppr.Room.database.DatabaseManager;
import com.example.pppr.Room.database.Entity.ContentDB;
import com.example.pppr.databinding.ActivityMegaAnalisBinding;

import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MegaAnalis extends AppCompatActivity {
    private ActivityMegaAnalisBinding binding;
    private AppDatabase database;

    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMegaAnalisBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String savedtext = getIntent().getStringExtra("savedText");
        initDatabase();

        List<String> a = database.getContentDao().fetchContentByParameters(savedtext, 1, 1);
        List<String> b = database.getContentDao().fetchContentByParameters(savedtext, 1, 2);
        List<String> c = database.getContentDao().fetchContentByParameters(savedtext, 1, 3);
        List<String> d = database.getContentDao().fetchContentByParameters(savedtext, 1, 4);
        swot swot = new swot(a, b, c, d);
        System.out.println(swot);

        List<String> a2 = database.getContentDao().fetchContentByParameters(savedtext, 2, 1);
        List<String> b2 = database.getContentDao().fetchContentByParameters(savedtext, 2, 2);
        List<String> c2 = database.getContentDao().fetchContentByParameters(savedtext, 2, 3);
        tens tens = new tens(a2, b2, c2);
        System.out.println(tens);

        List<String> a3 = database.getContentDao().fetchContentByParameters(savedtext, 3, 1);
        List<String> b3 = database.getContentDao().fetchContentByParameters(savedtext, 3, 2);
        zauprotiv zauprotiv = new zauprotiv(a3, b3);
        System.out.println(zauprotiv);

        List<String> a4 = database.getContentDao().fetchContentByParameters(savedtext, 4, 1);
        List<String> b4 = database.getContentDao().fetchContentByParameters(savedtext, 4, 2);
        List<String> c4 = database.getContentDao().fetchContentByParameters(savedtext, 4, 3);
        List<String> d4 = database.getContentDao().fetchContentByParameters(savedtext, 4, 4);
        dekart dekart = new dekart(a4, b4, c4, d4);
        System.out.println(dekart);

        List<String> a5 = database.getContentDao().fetchContentByParameters(savedtext, 5, 1);
        List<String> b5 = database.getContentDao().fetchContentByParameters(savedtext, 5, 2);
        List<String> c5 = database.getContentDao().fetchContentByParameters(savedtext, 5, 3);
        mpk mpk = new mpk(a5, b5, c5);
        System.out.println(mpk);


        AlertDialog.Builder builder = new AlertDialog.Builder(MegaAnalis.this);
        builder.setMessage("")
                .setTitle("помните, что все написанное лишь РЕКОМЕНДАЦИЯ")
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        AlertDialog dialog = builder.create();

        System.out.println("BEGIN");
        String prompt = String.format("You are an expert consultant providing a recommendation to solve a user's problem. The user will provide the problem description and additional data using various problem-solving techniques. Your task is to analyze the provided data and give a concise recommendation in russian.\n" +
                "Problem: %s\n" +
                "\n" +
                "SWOT Analysis:\n" +
                "Strengths: %s\n" +
                "Weaknesses: %s\n" +
                "Opportunities: %s\n" +
                "Threats: %s\n" +
                "\n" +
                "Rule 10/10/10 Analysis:\n" +
                "10 days: %s\n" +
                "10 weeks: %s\n" +
                "10 months: %s\n" +
                "\n" +
                "List of Pros and Cons:\n" +
                "Pros: %s\n" +
                "Cons: %s\n" +
                "\n" +
                "Walt Disney Method:\n" +
                "Dreamer: %s\n" +
                "Realist: %s\n" +
                "Critic: %s\n" +
                "\n" +
                "Cartesian Square Analysis:\n" +
                "Pros, if yes: %s\n" +
                "Pros, if not: %s\n" +
                "Cons, if yes: %s\n" +
                "Cons, if not: %s\n" +
                "\n" +
                "Recommendation:", savedtext, a.toString(), b.toString(), c.toString(), d.toString(), a2.toString(), b2.toString(), c2.toString(), a3.toString(), b3.toString(), a5.toString(), b5.toString(), c5.toString(), a4.toString(), b4.toString(), c4.toString(), d4.toString());


        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);







        String m1 = "gpt-3.5-turbo";
        String m2 = "gpt-4o";

        String baseUrl = "http://37.221.127.152:5000/";
        apiService = RetrofitClient.getClient(baseUrl).create(ApiService.class);






        binding.getanalis.setOnClickListener(v -> {
            dialog.show();
            binding.getanalis.setVisibility(false ? View.VISIBLE : View.GONE);
            sendPrompt(prompt);
        });



        binding.backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }

    private void sendPrompt(String prompt) {
        PromptRequest promptRequest = new PromptRequest(prompt);
        Call<PromptResponse> call = apiService.sendPrompt(promptRequest);

        call.enqueue(new Callback<PromptResponse>() {
            @Override
            public void onResponse(Call<PromptResponse> call, Response<PromptResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    binding.response.setText(response.body().getReply());
                } else {
                    binding.response.setText("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PromptResponse> call, Throwable t) {
                Log.e("MainActivity", "Error", t);
                binding.response.setText("Failure: " + t.getMessage());
            }
        });
    }


    private void initDatabase() {database = DatabaseManager.getInstance(this).getDatabase();}
}

