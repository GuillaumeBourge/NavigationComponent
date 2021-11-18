package com.android.app.ui.dashboard

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentDashboardDetailsBinding

class DashboardDetailsFragment : Fragment() {

    private lateinit var notificationsViewModel: DashboardViewModel
    private var _binding: FragmentDashboardDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardDetailsBinding.inflate(inflater, container, false)

        binding.buttonDashboard.setOnClickListener {
            findNavController().navigate(R.id.home_navigation)
        }

        binding.buttonDashboard1.setOnClickListener {
            findNavController().navigate(R.id.home_dest)
        }

        binding.buttonDashboard2.setOnClickListener {
            findNavController().navigate(R.id.home_details_dest)
        }

        binding.buttonDashboard3.setOnClickListener {
            val uri = Uri.parse("android-app://com.android.app/home")
            findNavController().navigate(uri)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}