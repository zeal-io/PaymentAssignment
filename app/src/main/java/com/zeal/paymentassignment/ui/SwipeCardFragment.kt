package com.zeal.paymentassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zeal.paymentassignment.R
import com.zeal.paymentassignment.core.DialogHelper
import com.zeal.paymentassignment.databinding.FragmentSwipeFragment2Binding

class SwipeCardFragment : Fragment() {
    private val binding by lazy {
        FragmentSwipeFragment2Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        DialogHelper.showPanDialog(requireContext(), {
            Thread {
                DialogHelper.showLoadingDialog(requireActivity(), "Sending Transaction to The Bank")
                Thread.sleep(2000)
                DialogHelper.showLoadingDialog(requireActivity(), "Receiving Bank Response")
                Thread.sleep(1000)
                DialogHelper.hideLoading(requireActivity())

                requireActivity().runOnUiThread {
                    findNavController().navigate(R.id.action_swipeCardFragment_to_printReceiptFragment)
                }
            }.start()
        }) {
            findNavController().popBackStack()
        }


        return binding.root
    }


}