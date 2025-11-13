package com.example.mad_23012021063_practical4

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class AlarmService : Service() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Alarm Service Started", Toast.LENGTH_SHORT).show()

        // Play alarm sound
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm_music)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        Toast.makeText(this, "Alarm Service Stopped", Toast.LENGTH_SHORT).show()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}

