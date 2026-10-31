package com.ayatschool.quickchat

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "FCM_Service"

    /**
     * Se llama cuando se genera un nuevo token de registro de FCM.
     * Esto puede ocurrir si se comprometió la seguridad del token anterior.
     * Nota: esto también se llama cuando se genera inicialmente el token.
     */
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Nuevo token de registro: $token")

        // Aquí puedes enviar el token a tu servidor de aplicaciones.
    }

    /**
     * Se llama cuando se recibe un mensaje de FCM.
     * Esto sucede cuando la app está en primer plano.
     */
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Muestra en el Logcat la información del remitente
        Log.d(TAG, "Mensaje recibido de: ${remoteMessage.from}")

        // Revisa si el mensaje contiene datos de carga útil
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Carga útil de datos del mensaje: ${remoteMessage.data}")
            // Procesa los datos del mensaje aquí, si es necesario.
        }

        // Revisa si el mensaje contiene una notificación
        remoteMessage.notification?.let {
            Log.d(TAG, "Título de la notificación: ${it.title}")
            Log.d(TAG, "Cuerpo de la notificación: ${it.body}")
            // Muestra una notificación en la barra de notificaciones.
            // Para esta práctica, el Logcat es suficiente para verificar que se recibió.
        }
    }
}
