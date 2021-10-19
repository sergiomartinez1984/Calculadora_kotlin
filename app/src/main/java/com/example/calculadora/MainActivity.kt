package com.example.calculadora


import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    var num1 = 0.0
    var num2: Double = 0.0
    var resultado: Double = 0.0
    var operacion: Int = 0
    var coma: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Crea botones
        buttons()

        //Operaciones
        operations()

        //binario/Decimal
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            decimal()
            buttonBin.setOnClickListener {
                bin()
            }
            buttonHex.setOnClickListener {
                hexadecimal()
            }
            buttonDec.setOnClickListener {
                decimal()
            }
        }
    }

    fun buttons() {
        button0.setOnClickListener { result.text = result.text.toString() + "0" }
        button1.setOnClickListener { result.text = result.text.toString() + "1" }
        button2.setOnClickListener { result.text = result.text.toString() + "2" }
        button3.setOnClickListener { result.text = result.text.toString() + "3" }
        button4.setOnClickListener { result.text = result.text.toString() + "4" }
        button5.setOnClickListener { result.text = result.text.toString() + "5" }
        button6.setOnClickListener { result.text = result.text.toString() + "6" }
        button7.setOnClickListener { result.text = result.text.toString() + "7" }
        button8.setOnClickListener { result.text = result.text.toString() + "8" }
        button9.setOnClickListener { result.text = result.text.toString() + "9" }
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            A.setOnClickListener { result.text = result.text.toString() + "A" }
            B.setOnClickListener { result.text = result.text.toString() + "B" }
            C.setOnClickListener { result.text = result.text.toString() + "C" }
            D.setOnClickListener { result.text = result.text.toString() + "D" }
            E.setOnClickListener { result.text = result.text.toString() + "E" }
            F.setOnClickListener { result.text = result.text.toString() + "F" }
        }
        comma.setOnClickListener {
            if (coma && result.text.toString() != "") {
                var a: String = "."
                var x: Int
                x = result.text.toString().indexOf(a)
                if (x == -1) {
                    result.text = result.text.toString() + "."
                }
            }
        }
        clear_text.setOnClickListener {
            result.text = ""
            num1 = 0.0
            num2 = 0.0
            coma = true
        }
        delete.setOnClickListener {
            if (result.text.isNotEmpty()) {
                result.text = result.text.substring(0, result.length() - 1)
            }
        }
    }
    fun operations() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            add.setOnClickListener {
                if (result.text != "" && result.text != ".") {
                    if (button5.isEnabled and !A.isEnabled) {
                        num1 = result.text.toString().toDouble()
                        result.text = ""
                        operacion = 1
                        coma = true
                    } else if (A.isEnabled) {
                        num1 = convertHexa(result.text.toString()).toDouble()
                        result.text = ""
                        operacion = 1
                    } else {
                        num1 = convertBin(result.text.toString())
                        result.text = ""
                        operacion = 1
                    }
                } else {
                    result.text = ""
                }
            }
            subtract.setOnClickListener {
                if (result.text != "" && result.text != ".") {
                    if (button5.isEnabled and !A.isEnabled) {
                        num1 = result.text.toString().toDouble()
                        result.text = ""
                        operacion = 2
                        coma = true
                    } else if (A.isEnabled) {
                        num1 = convertHexa(result.text.toString()).toDouble()
                        result.text = ""
                        operacion = 2
                    } else {
                        num1 = convertBin(result.text.toString())
                        result.text = ""
                        operacion = 2
                    }
                } else {
                    result.text = ""
                }
            }
            multiply.setOnClickListener {
                if (result.text != "" && result.text != ".") {
                    if (button5.isEnabled and !A.isEnabled) {
                        num1 = result.text.toString().toDouble()
                        result.text = ""
                        operacion = 3
                        coma = true
                    } else if (A.isEnabled) {
                        num1 = convertHexa(result.text.toString()).toDouble()
                        result.text = ""
                        operacion = 3
                    } else {
                        num1 = convertBin(result.text.toString())
                        result.text = ""
                        operacion = 3
                    }
                } else {
                    result.text = ""
                }

            }
            divide.setOnClickListener {
                if (result.text != "" && result.text != ".") {
                    if (button5.isEnabled and !A.isEnabled) {
                        num1 = result.text.toString().toDouble()
                        result.text = ""
                        operacion = 4
                        coma = true
                    } else if (A.isEnabled) {
                        num1 = convertHexa(result.text.toString()).toDouble()
                        result.text = ""
                        operacion = 4
                    } else {
                        num1 = convertBin(result.text.toString())
                        result.text = ""
                        operacion = 4
                    }
                } else {
                    result.text = ""
                }
            }
            equal.setOnClickListener {
                if (result.text != "") {
                    if (button5.isEnabled and !A.isEnabled) {
                        num2 = result.text.toString().toDouble()
                        if (operacion == 1) {
                            resultado = num1 + num2
                            result.text = resultado.toString()
                            !coma
                        } else if (operacion == 2) {
                            resultado = num1 - num2
                            result.text = resultado.toString()
                            !coma


                        } else if (operacion == 3) {
                            resultado = num1 * num2
                            result.text = resultado.toString()
                            !coma


                        } else if (operacion == 4) {
                            if (num2 != 0.0) {
                                resultado = num1 / num2
                                result.text = resultado.toString()
                                !coma


                            } else {
                                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    } else if (A.isEnabled) {
                        num2 = convertHexa(result.text.toString()).toDouble()
                        if (operacion == 1) {
                            resultado = num1 + num2
                            result.text = convertDecimal(resultado).uppercase()
                            !coma
                        } else if (operacion == 2) {
                            resultado = num1 - num2
                            result.text = convertDecimal(resultado).uppercase()
                            !coma
                        } else if (operacion == 3) {
                            resultado = num1 * num2
                            result.text = convertDecimal(resultado).uppercase()
                            !coma


                        } else if (operacion == 4) {
                            if (num2 != 0.0) {
                                resultado = num1 / num2
                                result.text = convertDecimal(resultado).uppercase()
                                !coma


                            } else {
                                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    } else {
                        num2 = convertBin(result.text.toString())
                        if (operacion == 1) {
                            resultado = num1 + num2
                            result.text = convertDecimal(resultado)


                        } else if (operacion == 2) {
                            resultado = num1 - num2
                            result.text = convertDecimal(resultado)


                        } else if (operacion == 3) {
                            resultado = num1 * num2
                            result.text = convertDecimal(resultado)


                        } else if (operacion == 4) {
                            if (num2 != 0.0) {
                                resultado = num1 / num2
                                result.text = convertDecimal(resultado)


                            } else {
                                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }

                } else {
                    result.text = ""
                }
            }
        } else {
            add.setOnClickListener {
                if (result.text != "" && result.text != ".") {
                    num1 = result.text.toString().toDouble()
                    result.text = ""
                    operacion = 1
                    coma = true
                }
            }
            subtract.setOnClickListener {
                if (result.text != "" && result.text != ".") {
                    num1 = result.text.toString().toDouble()
                    result.text = ""
                    operacion = 2
                    coma = true
                }
            }
            multiply.setOnClickListener {
                if (result.text != "" && result.text != ".") {

                    num1 = result.text.toString().toDouble()
                    result.text = ""
                    operacion = 3
                    coma = true

                }
            }
            divide.setOnClickListener {
                if (result.text != "" && result.text != ".") {
                    num1 = result.text.toString().toDouble()
                    result.text = ""
                    operacion = 4
                    coma = true
                }
            }
            equal.setOnClickListener {
                if (result.text != "") {
                    num2 = result.text.toString().toDouble()
                    if (operacion == 1) {
                        resultado = num1 + num2
                        result.text = resultado.toString()
                        !coma
                    } else if (operacion == 2) {
                        resultado = num1 - num2
                        result.text = resultado.toString()
                        !coma


                    } else if (operacion == 3) {
                        resultado = num1 * num2
                        result.text = resultado.toString()
                        !coma


                    } else if (operacion == 4) {
                        if (num2 != 0.0) {
                            resultado = num1 / num2
                            result.text = resultado.toString()
                            !coma


                        } else {
                            Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }
    private fun bin() {
        result.text = ""
        num1 = 0.0
        num2 = 0.0
        coma = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
        A.isEnabled = false
        B.isEnabled = false
        C.isEnabled = false
        D.isEnabled = false
        E.isEnabled = false
        F.isEnabled = false
    }

    private fun decimal() {
        result.text = ""
        num1 = 0.0
        num2 = 0.0
        coma = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        A.isEnabled = false
        B.isEnabled = false
        C.isEnabled = false
        D.isEnabled = false
        E.isEnabled = false
        F.isEnabled = false
    }

    private fun hexadecimal() {
        result.text = ""
        num1 = 0.0
        num2 = 0.0
        coma = false
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        A.isEnabled = true
        B.isEnabled = true
        C.isEnabled = true
        D.isEnabled = true
        E.isEnabled = true
        F.isEnabled = true
    }

    fun convertBin(binary: String): Double {
        var sum = 0.00
        binary.reversed().forEachIndexed { k, v ->
            sum += v.toString().toDouble() * 2.0.pow(k.toDouble())
        }
        return sum
    }

    fun convertDecimal(decimal: Double): String {
        if (A.isEnabled) {
            var x = Integer.toHexString(decimal.toInt())
            return x
        } else {
            return Integer.toBinaryString(decimal.toInt()).toString()
        }

    }

    fun convertHexa(hexa: String): Int {
        return Integer.parseInt(hexa, 16)
    }
}


//errores: Toast.makeText(this, "Don't can divide 0", Toast.LENGTH_SHORT).show()


