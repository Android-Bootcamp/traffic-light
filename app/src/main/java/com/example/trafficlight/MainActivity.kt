package com.example.trafficlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trafficLight = findViewById<TrafficLight>(R.id.traffic_light)
        findViewById<Button>(R.id.go_button).setOnClickListener {
            trafficLight.state = TrafficState.GO
        }
        findViewById<Button>(R.id.slow_button).setOnClickListener {
            trafficLight.state = TrafficState.SLOW
        }
        findViewById<Button>(R.id.stop_button).setOnClickListener {
            trafficLight.state = TrafficState.STOP
        }
    }
}