package com.vaibhav.delshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation


//Not in Current Use
class Defaultpage : Fragment() {
   private lateinit var navontrollers:NavController
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        return inflater.inflate(R.layout.fragment_defaultpage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val bt=view.findViewById<ImageButton>(R.id.imageButton3)
        bt.setOnClickListener {
            navontrollers=Navigation.findNavController(view)
          //  navontrollers.navigate(R.id.action_defaultpage2_to_recipe2)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Defaultpage().apply {
                arguments = Bundle().apply {

                }
            }
    }
}