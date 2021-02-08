package project.n01356135.ryan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        txtAboutInfo.setText("Project Submission Date: \nTuesday December 8, 2020" +
                "\n\nStudent Name: \nRyan Nguyen" +
                "\n\nStudent ID: \nN01356135" +
                "\n\nI am a student at Humber College and enrolled in the Computer Programming " +
                "program I made this game because I enjoy playing games like this. So I decided to make" +
                " one myself")

    }
}