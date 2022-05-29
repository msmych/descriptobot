package descriptobot

import com.google.gson.GsonBuilder
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener.CONFIRMED_UPDATES_ALL
import com.pengrad.telegrambot.model.request.ParseMode.MarkdownV2
import com.pengrad.telegrambot.request.SendMessage

fun main(vararg args: String) {
    val bot = TelegramBot(args[0])
    bot.setUpdatesListener { updates ->
        updates.forEach { update ->
            val message = update.message()
            if (message != null) {
                val sticker = message.sticker()
                if (sticker != null) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    bot.execute(SendMessage(
                        update.message().from().id(),
                        "```\n${gson.toJson(sticker)}\n```"
                    ).replyToMessageId(message.messageId())
                        .parseMode(MarkdownV2))
                }
            }
        }
        CONFIRMED_UPDATES_ALL
    }
    println("Поехали!")
}
