package com.example.mad_23012021063_practical4

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    lateinit var cardListAlarm: MaterialCardView
    lateinit var cardCancelAlarm: MaterialCardView

    lateinit var btnCreateAlarm: MaterialButton
    lateinit var btnCancelAlarm: MaterialButton
    lateinit var textAlarmTime: TextView
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cardListAlarm = findViewById(R.id.set_alram)
        cardCancelAlarm = findViewById(R.id.cancel_alarm)
        btnCreateAlarm = findViewById(R.id.set_button)
        btnCancelAlarm = findViewById(R.id.cancelAlarmButton)
        textAlarmTime = findViewById(R.id.alarmTimeDisplay)

        cardCancelAlarm.visibility = View.GONE

        btnCreateAlarm.setOnClickListener {
            showTimerDialog()
        }
        btnCancelAlarm.setOnClickListener {
            setAlarm(-1, "Stop")
            cardCancelAlarm.visibility=View.GONE
        }

    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun showTimerDialog() {
        val cldr: Calendar = Calendar.getInstance()
        val hour: Int = cldr.get(Calendar.HOUR_OF_DAY)
        val minutes: Int = cldr.get(Calendar.MINUTE)

        val picker = TimePickerDialog(
            this,
            { tp, sHour, sMinute -> sendDialogDataToActivity(sHour, sMinute) },
            hour,
            minutes,
            false
        )
        picker.show()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun sendDialogDataToActivity(hour: Int, minute: Int) {
        val alarmCalendar = Calendar.getInstance()
        val year: Int = alarmCalendar.get(Calendar.YEAR)
        val month: Int = alarmCalendar.get(Calendar.MONTH)
        val day: Int = alarmCalendar.get(Calendar.DATE)
        alarmCalendar.set(year, month, day, hour, minute, 0)
        cardCancelAlarm.visibility=View.VISIBLE
        setAlarm(alarmCalendar.timeInMillis,"Start")
        textAlarmTime.text = SimpleDateFormat("hh:mm ss a").format(alarmCalendar.time)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun setAlarm(millisTime: Long, str: String) {
        val intent = Intent(this, AlarmBroadcastReceiver::class.java)
        intent.putExtra("Service1", str)
        val pendingIntent =
            PendingIntent.getBroadcast(
                applicationContext,
                234324243,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        if (str == "Start") {
            if (alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    millisTime,
                    pendingIntent
                )
                Toast.makeText(this, "Start Alarm", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Can't set Alarm", Toast.LENGTH_SHORT).show()
                startActivity((Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)))
            }
        } else if (str == "Stop") {
            alarmManager.cancel(pendingIntent)
            sendBroadcast(intent)
            Toast.makeText(this, "Stop Alarm", Toast.LENGTH_SHORT).show()
        }
    }
}
