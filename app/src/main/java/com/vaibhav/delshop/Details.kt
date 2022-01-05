package com.vaibhav.delshop

import Dataclasses.Hit
import Dataclasses.Recipe
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import coil.load

class Details : Fragment() {
lateinit var currhit:Hit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currhit=it.getSerializable("hit")as Hit
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val im1=view.findViewById<ImageView>(R.id.imageView2)
        val tax1=view.findViewById<TextView>(R.id.textView)
        val tax2=view.findViewById<TextView>(R.id.textView2)
        im1.load(currhit.recipe.image)
        {
            placeholder(R.drawable.img_1)
            error(R.drawable.img)
        }
        tax1.text=currhit.recipe.label
        val resultsIng:String=currhit.recipe.ingredientLines.toString()
        tax2.text= resultsIng.subSequence(2,resultsIng.length-1)
        val b1=view.findViewById<Button>(R.id.button)
        b1.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("cont", currhit.recipe.url)
            }
            findNavController().navigate(R.id.action_details2_to_webview2, bundle)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }
}