package com.example.bai3bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import com.example.bai3bottomnav.databinding.FragmentSquareBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SquareFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SquareFragment : Fragment() {

    val myViewModel: MyViewModel by activityViewModels()
    private lateinit var binding : FragmentSquareBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSquareBinding.inflate(inflater, container, false)
        val number = myViewModel.number
        if(number.trim().isNotEmpty())
        {
            var result:Float = 0f
            result = number.toFloat() * number.toFloat()
            binding.tvResult.text = result.toString()
            binding.tvResult.addTextChangedListener {
                binding.tvResult.text = it.toString()
            }
        }

        return binding.root
    }

}