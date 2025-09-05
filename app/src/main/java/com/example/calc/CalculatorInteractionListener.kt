package com.example.calc

interface CalculatorInteractionListener {
    fun onClearClick()
    fun onDeleteClick()
    fun onDigitClick(digit: String)
    fun onOperatorClick(operation: Operation)
    fun onDecimalClick()
    fun onToggleSignClick()
    fun onEqualClick()
}