package com.example.currencyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.currencyapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = this.findNavController(R.id.nav_host)
        NavigationUI.setupActionBarWithNavController(this, navController)
        
        setContentView(R.layout.fragment_currencies)
        val amount: AutoCompleteTextView = findViewById(R.id.amount)
        val convert: Button = findViewById(R.id.convertButton)
        convert.setOnClickListener{
            val toast = Toast.makeText(this,"The Conversion is: ${amount.text}", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host)
        return navController.navigateUp()
    }
}
