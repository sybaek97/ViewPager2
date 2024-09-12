package com.crepass.viewpagertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.crepass.viewpagertest.databinding.FragmentSecondBinding
import com.crepass.viewpagertest.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {


    private lateinit var binding : FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_third,container,false)
        return binding.root
    }


}
