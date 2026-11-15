package com.example.ui

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class SpaceTtsManager(context: Context) {
    private var tts: TextToSpeech? = null
    private var isReady = false

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _speakingId = MutableStateFlow<String?>(null)
    val speakingId: StateFlow<String?> = _speakingId.asStateFlow()

    init {
        try {
            tts = TextToSpeech(context.applicationContext) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    isReady = true
                    tts?.language = Locale.US
                    tts?.setSpeechRate(0.92f) // Slightly slower, friendly pace for children aged 7-12
                    tts?.setPitch(1.05f)
                    tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                        override fun onStart(utteranceId: String?) {
                            _isSpeaking.value = true
                            _speakingId.value = utteranceId
                        }

                        override fun onDone(utteranceId: String?) {
                            _isSpeaking.value = false
                            _speakingId.value = null
                        }

                        @Deprecated("Deprecated in Java")
                        override fun onError(utteranceId: String?) {
                            _isSpeaking.value = false
                            _speakingId.value = null
                        }
                    })
                }
            }
        } catch (_: Exception) {
            isReady = false
        }
    }

    fun speak(id: String, text: String, hindi: Boolean = false) {
        if (!isReady) return
        if (_isSpeaking.value && _speakingId.value == id) {
            stop()
            return
        }
        try {
            tts?.stop()
            val targetLocale = if (hindi) Locale("hi", "IN") else Locale.US
            val result = tts?.setLanguage(targetLocale)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                tts?.language = Locale.US
            }
            _isSpeaking.value = true
            _speakingId.value = id
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, id)
        } catch (_: Exception) {
            _isSpeaking.value = false
            _speakingId.value = null
        }
    }

    fun stop() {
        try {
            tts?.stop()
        } catch (_: Exception) {
        }
        _isSpeaking.value = false
        _speakingId.value = null
    }

    fun shutdown() {
        stop()
        try {
            tts?.shutdown()
        } catch (_: Exception) {
        }
    }
}
