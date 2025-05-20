package vcmsa.daniel.quizcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Creating Variables for later use
        var btStartFirstScreen = findViewById<Button>(R.id.btStartFirstScreen)

        // On Click Listener for the Button so that it will go to the next screen (Flash Card Screen)
        btStartFirstScreen.setOnClickListener {
            val intent = Intent(this, FlashCardQuestionActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}