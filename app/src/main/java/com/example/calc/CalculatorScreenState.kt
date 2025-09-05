package com.example.calc

data class CalculatorState(
    val lastLine: String = "",
    val currentLine: String = "0",
)

fun String.toArabicDigits(): String {
    return this
        .replace('0', '٠')
        .replace('1', '١')
        .replace('2', '٢')
        .replace('3', '٣')
        .replace('4', '٤')
        .replace('5', '٥')
        .replace('6', '٦')
        .replace('7', '٧')
        .replace('8', '٨')
        .replace('9', '٩')
}