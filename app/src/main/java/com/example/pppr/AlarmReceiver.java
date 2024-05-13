package com.example.pppr;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "reminder_notifications_channel";

    @Override
    public void onReceive(Context context, Intent intent) {
        // Создаем канал уведомлений
        createNotificationChannel(context);

        // Создаем само уведомление
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.trash) // Иконка уведомления (добавьте свою)
                .setContentTitle("Напоминание")
                .setContentText("Не забудьте о важном деле!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)

                .build();

        // Показываем уведомление
        if (notificationManager != null) {
            notificationManager.notify(1, notification);
        }
    }

    // Создаем канал уведомлений для Android 8.0 (API 26) и выше
    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Reminder Notifications";
            String description = "Channel for reminder notifications";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }
}
