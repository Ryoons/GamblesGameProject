package project.n01356135.ryan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_score.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class Score : AppCompatActivity() {

    private lateinit var mDb:ScoreboardDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val intent = getIntent()
        val name = intent.getStringExtra("Name")
        var balance = intent.getIntExtra("GlobalBalance", 0)

        mDb = ScoreboardDatabase.getInstance(applicationContext)

        val mytext = findViewById<TextView>(R.id.txtScore)
        mytext.movementMethod = ScrollingMovementMethod()

        val refresh = findViewById<Button>(R.id.btnRefresh)
        refresh.setOnClickListener{
            doAsync {

                val list = mDb.scoreDao().getAll()

                uiThread {

                    toast("${list.size} records found.")
                    mytext.text = ""
                    for (score in list){
                        mytext.append("${score.id} : ${score.fullName} : ${score.balanceScore}\n")
                    }
                }
            }
        }

        btnDelete.setOnClickListener {

            Toast.makeText(this, "Data Cleared please refresh.", Toast.LENGTH_SHORT).show()

            doAsync {
                mDb.clearAllTables()
                mDb.scoreDao().getAll()

            }
        }

        btnScoreEarn.setOnClickListener {
            val intent = Intent (this, EarnMoney:: class.java)
            intent.putExtra("Name", name)
            intent.putExtra("GlobalBalance", balance)
            startActivity(intent)
        }


    }
}