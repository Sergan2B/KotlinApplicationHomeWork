package kg.geektech.kotlinapplicationhomework

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.kotlinapplicationhomework.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var user: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getEditText()
        buttonClicker()
    }

    private fun buttonClicker() {
        binding.btnClicker.setOnClickListener {
            if (binding.etUser.text?.isEmpty() == true) {
                Toast.makeText(this, "Редатируемая строка не может быть пустой", Toast.LENGTH_SHORT)
                    .show()
            } else {
                user = binding.etUser.text.toString()
                setResult(RESULT_OK, intent.putExtra("User", user))
                finish()
            }
        }
    }

    private fun getEditText() {
        user = intent.getStringExtra("User")
        binding.etUser.setText(user)
    }
}