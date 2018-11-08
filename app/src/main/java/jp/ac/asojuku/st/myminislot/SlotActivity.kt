package jp.ac.asojuku.st.myminislot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.ImageButton
import jp.ac.asojuku.st.myminislot.R.drawable.banana
import kotlinx.android.synthetic.main.activity_slot.*

class SlotActivity : AppCompatActivity() {
    val banana = 0
    val bar = 1
    val bigwin = 2
    val cherry = 3
    val grape = 4
    val lemon = 5
    val orange = 6
    val seven = 7
    val waltermelon = 8
    val baby = 9

    var b1:Int = 0
    var b2:Int = 0
    var b3:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot)
        val haveCoin = intent.getIntExtra("haveCoin",1000)
        val betCoin = intent.getIntExtra("betCoin",10)
        haveCoin_intSlot.setText(Integer.toString(haveCoin))
        betCoin_intSlot.setText(Integer.toString(betCoin))


        BACK.setOnClickListener{onBackButtonTapped(intent)}
        SLOT1.setOnClickListener{onSlotButtonTapped(SLOT1)}
        SLOT2.setOnClickListener{onSlotButtonTapped(SLOT2)}
        SLOT3.setOnClickListener{onSlotButtonTapped(SLOT3)}

    }
    fun onBackButtonTapped(intent: Intent){
        val haveCoin =intent.getIntExtra("haveCoin",1000)
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("haveCoin",haveCoin)
        startActivity(intent)
    }
    fun onSlotButtonTapped(imageButton: ImageButton) {
        var result = (Math.random() * 10).toInt()
        when (result) {
            banana -> imageButton.setImageResource(R.drawable.banana)
            bar -> imageButton.setImageResource(R.drawable.bar)
            bigwin -> imageButton.setImageResource(R.drawable.bigwin)
            cherry -> imageButton.setImageResource(R.drawable.cherry)
            grape -> imageButton.setImageResource(R.drawable.grape)
            lemon -> imageButton.setImageResource(R.drawable.lemon)
            orange -> imageButton.setImageResource(R.drawable.orange)
            seven -> imageButton.setImageResource(R.drawable.seven)
            waltermelon -> imageButton.setImageResource(R.drawable.waltermelon)
            baby -> imageButton.setImageResource(R.drawable.baby)
        }
        var haveCoin = intent.getIntExtra("haveCoin", 1000)
        var betCoin = intent.getIntExtra("betCoin", 10)

        if (imageButton == SLOT1 && b1 !=result) {
            b1 = result
        } else if (imageButton == SLOT2 && b2 != result) {
            b2 = result
        } else if(b3 != result){
            b3 = result
        }
        if(b1 != 0 && b2 != 0 && b3 != 0) {
            if (imageButton == SLOT1 && imageButton == SLOT2 && imageButton == SLOT3 && b1 == baby || b2 == baby || b3 == baby) {
                haveCoin += betCoin * 5
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (imageButton == SLOT1 && imageButton == SLOT2 && imageButton == SLOT3 && b1 == seven && b2 == seven && b3 == seven) {
                haveCoin += betCoin * 20
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (imageButton == SLOT1 && imageButton == SLOT2 && imageButton == SLOT3 && b1 == bigwin && b2 == bigwin && b3 == bigwin) {
                haveCoin += betCoin * 10
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (imageButton == SLOT1 && imageButton == SLOT2 && imageButton == SLOT3 && b1 == bar && b2 == bar && b3 == bar) {
                haveCoin += betCoin * 5
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (b1 == b2 && b2 == b3) {
                haveCoin += betCoin * 2
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (b1 == seven && b2 == seven || b1 == seven && b3 == seven || b2 == seven && b3 == seven) {
                haveCoin += betCoin * 3
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (b1 == b2 || b2 == b3 || b1 == b3) {
                haveCoin += betCoin
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (b1 == waltermelon || b2 == waltermelon || b3 == waltermelon) {
                haveCoin += betCoin
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (b1 == orange && b2 == cherry && b3 == lemon) {
                haveCoin += betCoin * 30
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            } else if (b1 == waltermelon && b2 == banana && b3 == grape) {
                haveCoin += betCoin * 10
                intent.putExtra("haveCoin", 1000)
                haveCoin_intSlot.setText(Integer.toString(haveCoin))
            }
        }
        haveCoin_intSlot.setText(Integer.toString(haveCoin))
    }
    fun saveData(haveCoin:Int, betCoin:Int){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val haveCoin = pref.getInt("haveCoin",1000)
        val betCoin = pref.getInt("betCoin",10)

        val editor = pref.edit()
        editor.putInt("haveCoin",1000)
                .putInt("betCoin",10)
                .apply()
    }

}
