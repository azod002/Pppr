package com.example.pppr.Methodics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.pppr.AlarmReceiver;

import com.example.pppr.R;
import com.example.pppr.databinding.ActivityAnsFromTimeBinding;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AnsFromTime extends AppCompatActivity {
    private ActivityAnsFromTimeBinding binding;
    private Context context;
    private boolean areFabsVisible = false;

    private static final String CHANNEL_ID = "reminder_notifications_channel";
    private static final int NOTIFICATION_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnsFromTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initviews();
        binding.savetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int hours = Integer.parseInt(binding.hours.getText().toString());
                    int minutes = Integer.parseInt(binding.mins.getText().toString());
                    if((hours * 60 + minutes) <= 4320 && (hours * 60 + minutes) >= 60){
                        setMultipleAlarms(hours, minutes);}
                    else{
                        Toast.makeText(AnsFromTime.this, "Пожалуйста, введите корректное количество времени", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(AnsFromTime.this, "Пожалуйста, введите корректное количество времени", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initviews() {
        binding.backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
        binding.questbutt.setOnClickListener(va -> {
            areFabsVisible = !areFabsVisible;
            binding.ans.setVisibility(areFabsVisible ? View.VISIBLE : View.GONE);
        });
    }

    private void setMultipleAlarms(int hours, int minutes) {
        long totalMinutes = hours * 60 + minutes;
        long totalTimeInMilliseconds = totalMinutes * 60000;

        int[] percentages = {20, 40, 60, 80, 90, 95, 96, 97, 98, 99};

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long currentTime = System.currentTimeMillis();

        for (int percent : percentages) {
            long alarmTime = currentTime + (totalTimeInMilliseconds * percent / 100);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, percent, new Intent(this, AlarmReceiver.class), PendingIntent.FLAG_IMMUTABLE);

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent);
        }

        Toast.makeText(this, "Уведомления запланированы на " + Arrays.toString(percentages) + "% времени.", Toast.LENGTH_SHORT).show();
    }

}