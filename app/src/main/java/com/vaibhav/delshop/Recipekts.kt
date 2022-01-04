package com.vaibhav.delshop

import Dataclasses.Hit
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.vaibhav.delshop.databinding.FragmentRecipeBinding
import java.util.*


class Recipes : Fragment(),Rvlisten{
    private  val sharedViewModel: FoodViewModel by activityViewModels()
    lateinit var ans:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentRecipeBinding.inflate(inflater)
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = sharedViewModel

        // Sets the adapter of the photosGrid RecyclerView
        binding.recyclerView.adapter = RecipeAdapter(this)

        return binding.root
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txt =view.findViewById<EditText>(R.id.foods)
        val bst =view.findViewById<ImageButton>(R.id.imageButton)
        sharedViewModel.img.observe(viewLifecycleOwner,{
            if(it.isEmpty())
            {
                Toast.makeText(context,"Invalid Search Results",Toast.LENGTH_SHORT).show()
            }
        })
        bst.setOnClickListener {
            ans=txt.text.toString()
            ans=ans.lowercase()
            var ansAdd:String =""
            Log.d("msd",ans)
                for(cn in ans)
                {
                    ansAdd += if(cn==' ') {
                        '+'
                    } else {
                        cn
                    }
                }
            Log.d("msd",ansAdd)
            if(ansAdd.isEmpty())
            {
                Toast.makeText(context,"Enter Something",Toast.LENGTH_SHORT).show()
            }
             sharedViewModel.getPhoto(ansAdd)
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Recipes().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onclicked(hit: Hit) {
        val bundle = Bundle().apply {
            putSerializable("hit",hit);
        }
        findNavController().navigate(R.id.action_recipe2_to_details2,bundle)
    }
}