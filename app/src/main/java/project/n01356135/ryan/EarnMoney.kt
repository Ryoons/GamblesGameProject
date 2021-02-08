package project.n01356135.ryan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_earn_money.*
import kotlinx.android.synthetic.main.activity_gamble_home.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class EarnMoney : AppCompatActivity() {

    private lateinit var mDb:ScoreboardDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_earn_money)

        mDb = ScoreboardDatabase.getInstance(applicationContext)
        val intent = getIntent()
        val name = intent.getStringExtra("Name")
        var balance = intent.getIntExtra("GlobalBalance", 0)
        val userBalance = findViewById<TextView>(R.id.textEarnBalance)

        val userRoll = findViewById<TextView>(R.id.textUserRoll)

        userBalance.text = balance.toString()


        btnWork.setOnClickListener {

            balance += 300
            Toast.makeText(this, "Earned $300.", Toast.LENGTH_SHORT/4).show()
            textEarnBalance.setText(balance.toString())

            val score = ScoreEntity(0,
                fullName = name.toString(),
                balanceScore = balance
            )

            doAsync {
                mDb.scoreDao().insert(score)
            }
        }

        btnGambles.setOnClickListener {

            var userAmount = editGambleAmnt?.text.toString().toInt()

            var userRoll = (Math.random() * (99 - 1)).toInt() + 1
            var dealerRoll = (Math.random() * (99 - 1)).toInt() + 1

            if (userAmount <= balance) {
                if (userRoll > dealerRoll) {
                    textDealerRoll.setText("Dealer Rolled: \n" + dealerRoll.toString())
                    textUserRoll.setText("You Rolled: \n" + userRoll.toString())
                    balance += userAmount * 2
                    textEarnBalance.setText(balance.toString())

                } else if (userAmount == dealerRoll) {
                    textDealerRoll.setText("Dealer Rolled: \n" + dealerRoll.toString())
                    textUserRoll.setText("You Rolled: \n" + userRoll.toString())
                    balance += 0
                    textEarnBalance.setText(balance.toString())

                } else if (userRoll < dealerRoll) {
                    textDealerRoll.setText("Dealer Rolled: \n" + dealerRoll.toString())
                    textUserRoll.setText("You Rolled: \n" + userRoll.toString())
                    balance -= userAmount
                    textEarnBalance.setText(balance.toString())

                }
            }
            val score = ScoreEntity(0,
                fullName = name.toString(),
                balanceScore = balance
            )

            doAsync {
                mDb.scoreDao().insert(score)
            }

        }

        btnGambleHome.setOnClickListener {
            val balance = userBalance.text.toString().toInt()
            val intent = Intent (this, GambleHome:: class.java)
            intent.putExtra("GlobalBalance", balance)
            intent.putExtra("Name", name)
            startActivity(intent)
        }

        btnScoreboard.setOnClickListener {
            val balance = userBalance.text.toString().toInt()
            val intent = Intent (this, Score:: class.java)
            intent.putExtra("GlobalBalance", balance)
            intent.putExtra("Name", name)
            startActivity(intent)
        }

    }

}