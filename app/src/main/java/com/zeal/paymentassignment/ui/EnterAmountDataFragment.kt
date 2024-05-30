package com.zeal.paymentassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zeal.paymentassignment.R
import com.zeal.paymentassignment.core.FlowDataObject
import com.zeal.paymentassignment.databinding.FragmentEnterAmount2Binding

class EnterAmountDataFragment : Fragment() {
    val binding by lazy {
        FragmentEnterAmount2Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            val amount = binding.tvEnterAmount.text.toString()
            if (amount.isNotBlank()) {
                try {
                    val amountF = amount.toFloat()
                    if (amountF == 0.0f)
                        Toast.makeText(context, "cant be zero", Toast.LENGTH_SHORT).show()
                    else {
                        FlowDataObject.getInstance().amount = amountF;

                        findNavController().navigate(R.id.action_enterAmountDataFragment_to_swipeCardFragment)
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "please add valid number", Toast.LENGTH_SHORT).show()
                }
            } else
                Toast.makeText(context, "cant be empty", Toast.LENGTH_SHORT).show()

        }


    }
}