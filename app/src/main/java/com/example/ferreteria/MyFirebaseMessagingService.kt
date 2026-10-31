package com.ayatschool.quickchat

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "FCM_Service"

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Nuevo token de registro: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        Log.d(TAG, "Mensaje recibido de: ${remoteMessage.from}")

        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Carga útil de datos del mensaje: ${remoteMessage.data}")
        }

        remoteMessage.notification?.let {
            Log.d(TAG, "Título de la notificación: ${it.title}")
            Log.d(TAG, "Cuerpo de la notificación: ${it.body}")
        }
    }
}
