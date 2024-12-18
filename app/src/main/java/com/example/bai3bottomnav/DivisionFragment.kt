package com.example.bai3bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import com.example.bai3bottomnav.databinding.FragmentDivisionBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DivisionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DivisionFragment : Fragment() {

    val myViewModel: MyViewModel by activityViewModels()
    private lateinit var binding: FragmentDivisionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDivisionBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val number = myViewModel.number
        if(number.trim().isNotEmpty())
        {
            var result:Float = 0f
            result = number.toFloat() / 2
            binding.tvResult.text = result.toString()
            binding.tvResult.addTextChangedListener {
                binding.tvResult.text = it.toString()
            }
        }

        return binding.root
    }

}