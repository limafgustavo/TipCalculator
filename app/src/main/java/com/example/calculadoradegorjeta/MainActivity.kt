package com.example.calculadoradegorjeta

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.example.calculadoradegorjeta.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.textinputeditTotal.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            updateNumbers()

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


        binding.seekbarPercentage.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                var percentageSelected = seekBar.progress.toString()
                binding.textPercentageSelected.text = "$percentageSelected%"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }


            override fun onStopTrackingTouch(seekBar: SeekBar) {
                var teste = binding.textinputeditTotal.text.toString()
                if (teste !=""){updateNumbers()}

               // Toast.makeText(this@MainActivity,"Funcionou?",Toast.LENGTH_SHORT).show()


            }
        })
    }

    private fun updateNumbers(){
        var percentage = binding.seekbarPercentage.progress.toString().toDouble()
        var totalAccountPrice = binding.textinputeditTotal.text.toString().toDouble()
        var totalValuePercentage = totalAccountPrice * percentage / 100

        

        var totalwithpercentage = totalAccountPrice + totalValuePercentage

        binding.textTotalTip.text =  totalValuePercentage.toString()
        binding.textTotalWithTip.text = "R$" + totalwithpercentage.toString()
    }
}
