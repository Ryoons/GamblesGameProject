package project.n01356135.ryan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        val name = pref.getString("Name", "")
        editName.setText(name)

        val nameEt = findViewById<EditText>(R.id.editName)
        var globalBalance = 10000

        btnLogin.setOnClickListener {

            val intent = Intent (this, GambleHome:: class.java)
            val name = nameEt.text.toString()
            editor.putString("Name", editName.text.toString())

            if (editName.length() >= 3) {
                intent.putExtra("Name", name)
                intent.putExtra("GlobalBalance", globalBalance)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Name can not be blank!", Toast.LENGTH_LONG).show()
            }
            editor.commit()
        }
    }


}