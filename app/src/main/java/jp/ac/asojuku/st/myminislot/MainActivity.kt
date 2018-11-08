package jp.ac.asojuku.st.myminislot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.TextView
import jp.ac.asojuku.st.myminislot.R.string.betCoin
import jp.ac.asojuku.st.myminislot.R.string.haveCoin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val haveCoin = intent.getIntExtra("haveCoin",1000)
        val betCoin = intent.getIntExtra("betCoin",10)
        haveCoin_intMain.setText(Integer.toString(haveCoin))
        betCoin_intMain.setText(Integer.toString(betCoin))


        START.setOnClickListener{ onStartButtonTapped(intent) }
        Button_betUp.setOnClickListener{onButton_betUpTapped(intent)}
        Button_betDown.setOnClickListener{onButton_betDownTapped(intent)}
        Button_betReset.setOnClickListener{onButton_betResetTapped(intent)}
    }
    fun onStartButtonTapped(intent: Intent){
        var haveCoin = intent.getIntExtra("haveCoin",1000)
        var betCoin = intent.getIntExtra("betCoin",10)
        if(haveCoin>=10 && haveCoin>=betCoin) {
            haveCoin -= betCoin
            val intent = Intent(this, SlotActivity::class.java)
            intent.putExtra("haveCoin", haveCoin)
            intent.putExtra("betCoin",betCoin)
            startActivity(intent)
        }
    }
    fun onButton_betUpTapped(intent: Intent){
        var betCoin = intent.getIntExtra("betCoin",10)
        var haveCoin = intent.getIntExtra("haveCoin",1000)
        if(betCoin>=haveCoin){
            betCoin = haveCoin
        }else{
            betCoin += 10
        }
        intent.putExtra("betCoin",betCoin)
        betCoin_intMain.setText(Integer.toString(betCoin))
    }
    fun onButton_betDownTapped(intent: Intent){
        var betCoin = intent.getIntExtra("betCoin",10)
        if(betCoin<=10){
            betCoin = 10
        }else{
            betCoin -= 10
        }
        intent.putExtra("betCoin",betCoin)
        betCoin_intMain.setText(Integer.toString(betCoin))
    }
    fun onButton_betResetTapped(intent: Intent){
        intent.putExtra("haveCoin",1000)
        haveCoin_intMain.setText(haveCoin)
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
