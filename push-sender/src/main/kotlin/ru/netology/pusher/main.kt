package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "POST")
        .putData("content", """{
          "author": "Vasiliy",
          "published": "Today is a good day.",
          "content": "В тот вечер Анна решила прогуляться по осеннему парку. Листья под ногами шуршали, словно перешёптываясь между собой. Она шла медленно, наслаждаясь прохладой и тишиной.
            На скамейке у пруда сидела пожилая женщина. Её седые волосы развевались на ветру, а взгляд был устремлён вдаль. Анна остановилась неподалёку, не решаясь нарушить её одиночество.
            Внезапно женщина заметила девушку и улыбнулась.
            — Красиво, правда? — спросила она, указывая на деревья.
            Анна кивнула.
            — Каждый год жду этого момента, — продолжила незнакомка. — Когда природа готовится ко сну, она становится особенно прекрасной."
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}
