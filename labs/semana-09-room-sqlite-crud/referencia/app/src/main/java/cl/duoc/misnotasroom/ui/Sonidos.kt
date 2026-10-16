package cl.duoc.misnotasroom.ui

import android.media.AudioManager
import android.media.ToneGenerator

/** Sonido de interacción; NO confirma éxito de persistencia. */
fun reproducirConfirmacion() {
    val tono = ToneGenerator(AudioManager.STREAM_NOTIFICATION, 45)
    try {
        tono.startTone(ToneGenerator.TONE_PROP_BEEP, 120)
    } finally {
        tono.release()
    }
}
