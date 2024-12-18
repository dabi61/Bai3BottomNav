package com.example.bai3bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import com.example.bai3bottomnav.databinding.FragmentMultiplicationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MultiplicationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MultiplicationFragment : Fragment() {
    val myViewModel : MyViewModel by activityViewModels()
    private lateinit var binding: FragmentMultiplicationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMultiplicationBinding.inflate(inflater, container, false)
        val number = myViewModel.number
        if(number.trim().isNotEmpty())
        {
            var result:Float = 0f
            result = number.toFloat() * 2
            binding.tvResult.text = result.toString()
            binding.tvResult.addTextChangedListener {
                binding.tvResult.text = it.toString()
            }
        }

        return binding.root
    }


}