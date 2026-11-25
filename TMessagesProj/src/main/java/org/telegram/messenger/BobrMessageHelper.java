package org.telegram.messenger;

import android.widget.Toast;

public class BobrMessageHelper {

    public static void onSendText(CharSequence text) {
        if (text == null) {
            return;
        }
        String msg = text.toString().toLowerCase();

        // Рофл 1: Детектор казика
        if (msg.contains("🎰") || msg.contains("🎲") || msg.contains("казик")) {
            showToast("🎰 Лудик");
        }

        // Рофл 2: Пасхалка на бобра
        if (msg.contains("бобр") || msg.contains("курва")) {
            showToast("🦫 Bóbr kurwa! Ja pierdolę!");
        }
    }

    private static void showToast(String message) {
        AndroidUtilities.runOnUIThread(() ->
            Toast.makeText(ApplicationLoader.applicationContext, message, Toast.LENGTH_SHORT).show()
        );
    }
}
