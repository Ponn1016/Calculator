package app.uemura.ponn.calculator

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.uemura.ponn.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //バインディングクラスの変数
    private lateinit var binding: ActivityMainBinding

    //1番目に入力される変数を作る
    var firstNumber = 0

    //2番目に入力される変数を作る
    var secondNumber = 0

    //合計を入れる変数を作る
    var totalNumber = 0

    //符号の入力状態を持つ変数⇒最初は空
    var operator = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //画面起動時は符号と等号ボタンは灰色に設定
        binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        //画面起動時は符号と等号ボタンは使用不可にする
        binding.plusButton.isEnabled = false
        binding.minusButton.isEnabled = false
        binding.multiplyButton.isEnabled = false
        binding.equalButton.isEnabled = false

        //1番目に入力される変数を、TextViewに反映する
        binding.numberText.text = firstNumber.toString()

        //ボタン0がタップされたら
        binding.numberButton0.setOnClickListener() {
            inputNumber(0)
        }
        //ボタン1がタップされたら
        binding.numberButton1.setOnClickListener() {
            inputNumber(1)
        }

        //ボタン2がタップされたら
        binding.numberButton2.setOnClickListener() {
            inputNumber(2)
        }

        //ボタン3がタップされたら
        binding.numberButton3.setOnClickListener() {
            inputNumber(3)
        }

        //ボタン4がタップされたら
        binding.numberButton1.setOnClickListener() {
            inputNumber(4)
        }

        //ボタン5がタップされたら
        binding.numberButton1.setOnClickListener() {
            inputNumber(5)
        }

        //ボタン6がタップされたら
        binding.numberButton1.setOnClickListener() {
            inputNumber(6)
        }

        //ボタン7がタップされたら
        binding.numberButton1.setOnClickListener() {
            inputNumber(7)
        }

        //ボタン8がタップされたら
        binding.numberButton1.setOnClickListener() {
            inputNumber(8)
        }

        //ボタン9がタップされたら
        binding.numberButton1.setOnClickListener() {
            inputNumber(9)
        }
        //+ボタンをタップしたとき
        binding.plusButton.setOnClickListener() {
            //+ボタンを赤色にする
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(220, 0, 100))
            //他の符号ボタンを灰色にする
            binding.minusButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            //符号を入れる変数に、+を表す「plus」という文字を入れる
            operator = "plus"
            //2番目に入力された数字をTextViewに反映する
            binding.numberText.text = secondNumber.toString()
        }

        //-ボタンをタップしたとき
        binding.minusButton.setOnClickListener() {
            //-ボタンを赤色にする
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(220, 0, 100))
            //他の符号ボタンを灰色にする
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            //符号を入れる変数に、+を表す「plus」という文字を入れる
            operator = "minus"
            //2番目に入力された数字をTextViewに反映する
            binding.numberText.text = secondNumber.toString()
        }

        //×ボタンをタップしたとき
        binding.multiplyButton.setOnClickListener() {
            //+ボタンを赤色にする
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(220, 0, 100))
            //他の符号ボタンを灰色にする
            binding.minusButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            //符号を入れる変数に、+を表す「plus」という文字を入れる
            operator = "multiply"
            //2番目に入力された数字をTextViewに反映する
            binding.numberText.text = secondNumber.toString()
        }

        //=ボタンをタップしたとき
        binding.equalButton.setOnClickListener() {
            if (operator == "plus") {
                //plusの時足し算を行う
                totalNumber = firstNumber + secondNumber
            } else if (operator == "minus") {
                //minusの時引き算を行う
                totalNumber = firstNumber - secondNumber
            } else if (operator == "multiply") {
                //multiplyの時掛け算を行う
                totalNumber = firstNumber * secondNumber
            }
        }

        //符号と等号ボタンを灰色にする
        binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        //入力される数字に入れる変数を初期化
        firstNumber = 0
        secondNumber = 0
        //符号の入力状態を持つ変数を初期化
        operator = "empty"

        //合計をTextViewに表示
        binding.numberText.text = totalNumber.toString()

        //クリアボタンがタップされたとき
        binding.clearButton.setOnClickListener() {
            //符号と等号ボタンを灰色にする
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

            //1番目・2番目に入力される数字と、合計を初期化
            firstNumber = 0
            secondNumber = 0
            totalNumber = 0
            //符号の入力状態を持つ変数を初期化
            operator = "empty"
            //初期化した値をTextViewに表示
            binding.numberText.text = totalNumber.toString()
        }

    }

    private fun inputNumber (number: Int) {
        //符号の入力状態を持つ変数が空かどうかで処理を分ける
        if (operator == "empty") {
            //1番目に入力される変数を上の位に移行
            firstNumber = firstNumber * 10 + number
            //数字をTextViewに反映する
            binding.numberText.text = firstNumber.toString()

            // 符号ボタンを緑色に変更、有効にする
            binding.plusButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(240, 240, 0))
            binding.minusButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(240, 240, 0))
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(240, 240, 0))

            binding.plusButton.isEnabled = true
            binding.minusButton.isEnabled = true
            binding.multiplyButton.isEnabled = true
            binding.equalButton.isEnabled = true
        } else {
            //2番目に入力された数字を上の位に移行する
            secondNumber = secondNumber * 10 + 9
            //数字を表示するTextViewに反映する
            binding.numberText.text = secondNumber.toString()
            //等号ボタンを黄色に戻す
            binding.equalButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(240, 240, 0))
        }
    }
}