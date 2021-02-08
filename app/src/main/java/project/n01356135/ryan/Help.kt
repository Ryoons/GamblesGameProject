package project.n01356135.ryan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_help.*

class Help : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        txtHelpInfo.setText("The objective of the game is to be able to work or gamble for your dream home" +
                " you will land on the home page which is the page where you can buy your home." +
                "\n\nStep 1: \nGo to earn money and decide whether you want to earn $300 a day!" +
                "\n\nGamble by entering in the amount you wish to gamble and you and the dealer will" +
                "roll a number between 1 and 100 whoever gets a higher number wins!" +
                "\n\nStep 2:\nOnce enough money is earned go back to the home page and buy your house!")


    }
}