package com.example.calc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.calc.databinding.CalculatorMainBinding
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.getValue

class MainActivity : AppCompatActivity() {
    private val viewModel: CalcViewModel by viewModels()
    private lateinit var binding: CalculatorMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = CalculatorMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeStates()

        setupOnClickListeners()
    }

    private fun observeStates() {
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                if (Locale.getDefault().language == "ar") {
                    binding.textLastOperation.text = state.lastLine.toArabicDigits()
                    binding.textResult.text = state.currentLine.toArabicDigits()
                } else {
                    binding.textLastOperation.text = state.lastLine
                    binding.textResult.text = state.currentLine
                }
            }
        }
    }


    private fun setupOnClickListeners() {
        setupOperationOnClickListeners()
        setupNumberOnClickListeners()
        binding.buttonOperationAc.setOnClickListener {
            viewModel.onClearClick()
        }
        binding.buttonOperationBack.setOnClickListener {
            viewModel.onDeleteClick()
        }
        binding.buttonOperationEqual.setOnClickListener {
            viewModel.onEqualClick()
        }
        binding.buttonPositiveNegative.setOnClickListener {
            viewModel.onToggleSignClick()
        }
    }

    private fun setupNumberOnClickListeners() {
        binding.buttonDigit0.setOnClickListener {
            viewModel.onDigitClick("0")
        }
        binding.buttonDigit1.setOnClickListener {
            viewModel.onDigitClick("1")
        }
        binding.buttonDigit2.setOnClickListener {
            viewModel.onDigitClick("2")
        }
        binding.buttonDigit3.setOnClickListener {
            viewModel.onDigitClick("3")
        }
        binding.buttonDigit4.setOnClickListener {
            viewModel.onDigitClick("4")
        }
        binding.buttonDigit5.setOnClickListener {
            viewModel.onDigitClick("5")
        }
        binding.buttonDigit6.setOnClickListener {
            viewModel.onDigitClick("6")
        }
        binding.buttonDigit7.setOnClickListener {
            viewModel.onDigitClick("7")
        }
        binding.buttonDigit8.setOnClickListener {
            viewModel.onDigitClick("8")
        }
        binding.buttonDigit9.setOnClickListener {
            viewModel.onDigitClick("9")
        }
        binding.buttonOperationDot.setOnClickListener {
            viewModel.onDecimalClick()
        }
    }

    private fun setupOperationOnClickListeners() {
        binding.buttonOperationReminder.setOnClickListener {
            viewModel.onOperatorClick(Operation.REMINDER)
        }
        binding.buttonOperationDivision.setOnClickListener {
            viewModel.onOperatorClick(Operation.DIVISION)
        }
        binding.buttonOperationMultiplication.setOnClickListener {
            viewModel.onOperatorClick(Operation.MULTIPLICATION)
        }
        binding.buttonOperationAddition.setOnClickListener {
            viewModel.onOperatorClick(Operation.ADDITION)
        }
        binding.buttonOperationSubtraction.setOnClickListener {
            viewModel.onOperatorClick(Operation.SUBTRACTION)
        }
    }
}