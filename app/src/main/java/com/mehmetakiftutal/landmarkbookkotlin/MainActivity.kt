package com.mehmetakiftutal.landmarkbookkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehmetakiftutal.landmarkbookkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var landmarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        val eiffel = Landmark("Eyfel","France",R.drawable.eyfel)
        val pisaa = Landmark("Pisa","Italy",R.drawable.pisa)
        val colesseumm = Landmark("Colezyum","Italy",R.drawable.colesseum)
        val londonBridgee = Landmark("London Bridge","UK",R.drawable.london)


        landmarkList.add(eiffel)
        landmarkList.add(pisaa)
        landmarkList.add(colesseumm)
        landmarkList.add(londonBridgee)

        binding.recyclerView.layoutManager = LinearLayoutManager(this )
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}