package id.sch.smktelkommlg.xir3.bahanaalana.volumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate){
            var inputLength: String = edtLength.text.toString().trim()
            var inputWidth: String = edtWidth.text.toString().trim()
            var inputHeight: String = edtHeight.text.toString().trim()

            var isEmptyFields = false
            var isInvalidDouble = false
            if(TextUtils.isEmpty(inputLength)){
                isEmptyFields = true
                edtLength.error = "Field Ini Tidak Boleh Kososng"
            }
            if(TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true
                edtWidth.error = "Field Ini Tidak Boleh Kososng"
            }
            if(TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true
                edtHeight.error = "Field Ini Tidak Boleh Kososng"
            }
            var length: Double? = toDouble(inputLength)
            var width: Double? = toDouble(inputWidth)
            var height: Double? = toDouble(inputHeight)

            if(length == null){
                isInvalidDouble = true
                edtLength.error = "Field ini harus berupa nomor yang valid"
            }
            if(width== null){
                isInvalidDouble = true
                edtWidth.error = "Field ini harus berupa nomor yang valid"
            }
            if(height == null){
                isInvalidDouble = true
                edtHeight.error = "Field ini harus berupa nomor yang valid"
            }
            if(!isEmptyFields && !isInvalidDouble){
                var volume: Double = length!! * width!! * height!!
                tvResult.text = volume.toString()
            }
        }
    }

    private fun toDouble(str: String): Double? {
        return try{
            str.toDouble()
        }catch (e: NumberFormatException){
            null
        }
    }
}