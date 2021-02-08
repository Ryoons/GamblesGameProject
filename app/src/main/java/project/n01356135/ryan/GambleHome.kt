package project.n01356135.ryan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gamble_home.*

class GambleHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamble_home)

        val intent = getIntent()
        val name = intent.getStringExtra("Name")
        var balance = intent.getIntExtra("GlobalBalance", 0)
        val dreamTv = findViewById<TextView>(R.id.textNameHome)

        textBalance.text = "Balance: " + balance
        dreamTv.text = name + "'s Dream Home"

        btnGamble.setOnClickListener {

            val intent = Intent (this, EarnMoney:: class.java)
            intent.putExtra("Name", name)
            intent.putExtra("GlobalBalance", balance)
            startActivity(intent)

        }

        btnBuyHome.setOnClickListener {
            if(balance >= 300000) {
                balance -= 300000
                Toast.makeText(this, "You bought your dream home!", Toast.LENGTH_SHORT).show()
                textBalance.text = "Balance:" + balance
            } else
            Toast.makeText(this, "Not enough money.", Toast.LENGTH_SHORT).show()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_search -> {
            true
        }
        R.id.action_about -> {
            val intent = Intent (this, About:: class.java)
            startActivity(intent)
            true
        }
        R.id.action_help -> {
            val intent = Intent (this, Help:: class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

}