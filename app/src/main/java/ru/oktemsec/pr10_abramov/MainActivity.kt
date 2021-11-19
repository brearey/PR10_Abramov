package ru.oktemsec.pr10_abramov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.oktemsec.pr10_abramov.databinding.ActivityMainBinding
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'

    private var CURRENT_ACTION = 0.toChar()

    private var valueOne = Double.NaN
    private var valueTwo = 0.0

    private val decimalFormat: DecimalFormat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val decimalFormat = DecimalFormat("#.##########")

        //Button dot
        binding.btnDot.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}.")
        }
        //Button 0
        binding.btn0.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}0")
        }
        //Button 1
        binding.btn1.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}1")
        }
        //Button 2
        binding.btn2.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}2")
        }
        //Button 3
        binding.btn3.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}3")
        }
        //Button 4
        binding.btn4.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}4")
        }
        //Button 5
        binding.btn5.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}5")
        }
        //Button 6
        binding.btn6.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}6")
        }
        //Button 7
        binding.btn7.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}7")
        }
        //Button 8
        binding.btn8.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}8")
        }
        //Button 9
        binding.btn9.setOnClickListener {
            binding.etEditText.setText("${binding.etEditText.text}9")
        }
        //Button add
        binding.btnAdd.setOnClickListener {
            computeCalculation()
            CURRENT_ACTION = ADDITION
            binding.tvInfo.text = "${decimalFormat.format(valueOne)}+"
            binding.etEditText.text = null
        }
        //Button minus
        binding.btnMinus.setOnClickListener {
            computeCalculation()
            CURRENT_ACTION = SUBTRACTION
            binding.tvInfo.text = "${decimalFormat.format(valueOne)}-"
            binding.etEditText.text = null
        }
        //Button umn
        binding.btnUmn.setOnClickListener {
            computeCalculation()
            CURRENT_ACTION = MULTIPLICATION
            binding.tvInfo.text = "${decimalFormat.format(valueOne)}*"
            binding.etEditText.text = null
        }
        //Button del
        binding.btnDel.setOnClickListener {
            computeCalculation()
            CURRENT_ACTION = DIVISION
            binding.tvInfo.text = "${decimalFormat.format(valueOne)}/"
            binding.etEditText.text = null
        }
        //Button itogo
        binding.btnItogo.setOnClickListener {
            computeCalculation()
            CURRENT_ACTION = ADDITION
            binding.tvInfo.text = "${binding.tvInfo.text}${decimalFormat.format(valueTwo)} = ${decimalFormat.format(valueOne)}"
            binding.etEditText.text = null
        }
        //Button clear
        binding.btnClear.setOnClickListener {
            if (binding.etEditText.text.isNotEmpty()) {
                val currentText: CharSequence = binding.etEditText.text
                binding.etEditText.setText(currentText.subSequence(0, currentText.length - 1))
            } else {
                valueOne = Double.NaN
                valueTwo = Double.NaN
                binding.etEditText.setText("")
                binding.tvInfo.text = ""
            }
        }
    }

    private fun computeCalculation() {
        if (!java.lang.Double.isNaN(valueOne)) {
            valueTwo = binding.etEditText.text.toString().toDouble()
            binding.etEditText.text = null
            if (CURRENT_ACTION == ADDITION) valueOne += valueTwo else if (CURRENT_ACTION == SUBTRACTION) valueOne -= valueTwo else if (CURRENT_ACTION == MULTIPLICATION) valueOne *= valueTwo else if (CURRENT_ACTION == DIVISION) valueOne /= valueTwo
        } else {
            try {
                valueOne = binding.etEditText.text.toString().toDouble()
            } catch (e: Exception) {
                Log.d("abramov", e.message.toString())
            }
        }
    }
}