package org.telegram.messenger;

import android.widget.Toast;
import java.util.Random;

public class BobrMessageHelper {

    private static final Random random = new Random();

    // Подколы про Nob (можешь дописать любые свои в кавычках через запятую)
    private static final String[] NOB_ROASTS = {
        "Nob — главный мастер автоатаки в FUT Esports!",
        "Nob опять пикнул Эдгара первым пиком и пошел фидить.",
        "Nob, даже мой бобр на лагах отыграет этот драфт лучше.",
        "Nob срочно нужен трансфер обратно на 500 кубков!",
        "Nob опять слил катку на Мортисе в стену!"
        "Nob где размен блять"
        "Nob замiнiт"
        
    };

    // Подколы про Angelboy
    private static final String[] ANGELBOY_ROASTS = {
        "Angelboy думает, что он про-игрок, но ультанул в пустоту.",
        "Angelboy — ангел только тогда, когда не заходит в катку.",
        "Angelboy опять затащил команду... прямо на дно таблицы.",
        "Даже с нимбом Angelboy не попадает тычками в упор!"
        "Angelboy, рекомендую тебе пойти нахуй"
        "Angelboy жиртрест ебучий"
    };

    // Подколы про Ярика / Гуести
    private static final String[] YARIK_ROASTS = {
        "Ярик, хватит сливать кубки, иди строй плотину!",
        "Гуести снова нажал «Играть снова» и оформил минус 100.",
        "Ярик в команде — это автолуз еще на стадии пиков.",
        "Гуести, твой пинг выше, чем твой винрейт!"
        "Гуести, надеюсь тебя нахуй заменят"
        "Гуести иди нахуй делать свои квести"
        "Гуести из-за своего жира даже не может голову поднять"
    };

    // Подмена текста ДО отправки в чат (видят все в чате)
    public static String replaceOutgoingText(String text) {
        if (text == null) {
            return null;
        }
        String trimmed = text.trim().toLowerCase();

        // Строгий триггер на .нобо -> отправляет только "диктатор"
        if (trimmed.equals(".нобо")) {
            return "диктатор";
        }

        // Триггеры на Nob
        if (trimmed.equals(".ноб") || trimmed.equals(".nob?") ||
            trimmed.equals(".nob") || trimmed.equals(".нiб")) {
            return NOB_ROASTS[random.nextInt(NOB_ROASTS.length)];
        }

        // Триггеры на Angelboy
        if (trimmed.equals(".ангел") || trimmed.equals(".ангелбой") ||
            trimmed.equals(".angelboy")) {
            return ANGELBOY_ROASTS[random.nextInt(ANGELBOY_ROASTS.length)];
        }

        // Триггеры на Ярика / Гуести
        if (trimmed.equals(".ярик") || trimmed.equals(".гуести")) {
            return YARIK_ROASTS[random.nextInt(YARIK_ROASTS.length)];
        }

        return text;
    }

    // Всплывающие плашки только у тебя на экране
    public static void onSendText(CharSequence text) {
        if (text == null) {
            return;
        }
        String msg = text.toString().toLowerCase();

        if (msg.contains("🎰") || msg.contains("🎲") || msg.contains("казик")) {
            showToast("🎰 Лудик");
        }

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
