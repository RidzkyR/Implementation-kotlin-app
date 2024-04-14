package com.example.implementation_kotlin_android.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.implementation_kotlin_android.R
import com.example.implementation_kotlin_android.databinding.ActivityDataTypeAndVariableBinding
import com.example.implementation_kotlin_android.models.DataTypeAndVariableModels

class DataTypeAndVariable : AppCompatActivity() {
    private lateinit var binding: ActivityDataTypeAndVariableBinding
    private val dataTypeAndVariableModels = DataTypeAndVariableModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDataTypeAndVariableBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRun.setOnClickListener {
            //mencetak tipe data
            val input = binding.edtMenetukanTipeData.text
            val dataType = when {
                input.matches(Regex("[0-9]+")) -> "output : Int"
                input.matches(Regex("[0-9.]+")) -> "output : Float"
                input.matches(Regex("[a-zA-Z]+")) -> "output : String"
                input.matches(Regex("(true|false)")) -> "output : Boolean"
                else -> "Tipe data tidak dikenal"
            }
            binding.tvOutputMenetukanTipeData.text = dataType

            //penjumlahan
            val inputNum1 = binding.edtNum1.text.toString()
            val inputNum2 = binding.edtNum2.text.toString()

            when {
                inputNum1.isEmpty() -> binding.edtNum1.error = "Field tidak boleh kosong"
                inputNum2.isEmpty() -> binding.edtNum2.error = "Field tidak boleh kosong"
                else -> {
                    val resultNum =
                        dataTypeAndVariableModels.penjumlahan(inputNum1.toInt(), inputNum2.toInt())
                            .toString()
                    binding.tvOutputPenjumlahan.text = "output : $resultNum"
                }
            }

            //mengabungkan dua String
            val inputText1 = binding.edtText1.text.toString()
            val inputText2 = binding.edtText2.text.toString()

            when {
                inputText1.isEmpty() -> binding.edtText1.error = "Field tidak boleh kosong"
                inputText2.isEmpty() -> binding.edtText2.error = "Field tidak boleh kosong"
                else -> {
                    val resultNum = dataTypeAndVariableModels.gabungString(inputText1, inputText2)
                    binding.tvOutputGabungString.text = "output : $resultNum"
                }
            }

            //ganjil genap
            val inputNum = binding.edtMenetukanGanjilGenap.text.toString()
            if (inputNum.isEmpty()) {
                binding.edtMenetukanGanjilGenap.error = "Field tidak boleh kosong"
            } else {
                if (inputNum.toInt() % 2 == 0) {
                    binding.tvOutputGanjilGenap.text = "output : Genap"
                } else {
                    binding.tvOutputGanjilGenap.text = "output : Ganjil"
                }
            }

            //cek huruf
            val inputHuruf = binding.edtMenetukanCekHuruf.text.toString()
            if (inputHuruf.isEmpty()) {
                binding.edtMenetukanCekHuruf.error = "Field tidak boleh kosong"
            } else {
                if (inputHuruf in "uvuvwevwevwe osas") {
                    binding.tvOutputCekHuruf.text = "output : Ada"
                } else {
                    binding.tvOutputCekHuruf.text = "output : Tidak ada"
                }
            }

        }
    }
}