package com.example.lab5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultsActivity : AppCompatActivity() {

    private var mes:String? = ""
    private var adr:String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        button4.setOnClickListener { emailSend()}
        getResult()
    }

    private fun getResult(){
        val message = intent.getStringExtra("text")
        val address = intent.getStringExtra("Email")
        mes=message
        adr=address
        textView9.text = message
    }

    private fun emailSend(){


        val email = Intent(Intent.ACTION_SEND)
        //Указываем получателя
        //Указываем получателя
        email.putExtra(Intent.EXTRA_EMAIL, arrayOf(adr))
        //Устанавливаем Тему сообщения
        //Устанавливаем Тему сообщения
        email.putExtra(Intent.EXTRA_SUBJECT,"Соответствие цветов")
        //Устанавливаем само сообщение
        //Устанавливаем само сообщение
        email.putExtra(Intent.EXTRA_TEXT, mes)
        //тип отправляемого сообщения
        //тип отправляемого сообщения
        email.type = "message/rfc822"
        //Вызываем intent выбора клиента для отправки сообщения
        //Вызываем intent выбора клиента для отправки сообщения
        startActivity(Intent.createChooser(email, "Выберите email клиент :"))
    }
}