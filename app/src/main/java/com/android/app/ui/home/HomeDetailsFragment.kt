package com.android.app.ui.home

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentHomeDetailsBinding

class HomeDetailsFragment : Fragment() {

    private lateinit var notificationsViewModel: HomeViewModel
    private var _binding: FragmentHomeDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeDetailsBinding.inflate(inflater, container, false)

        binding.buttonHome.setOnClickListener {
            findNavController().navigate(R.id.notifications_navigation)
        }

        binding.buttonHome1.setOnClickListener {
            findNavController().navigate(R.id.notifications_dest)
        }

        binding.buttonHome2.setOnClickListener {
            findNavController().navigate(R.id.notifications_details_dest)
        }

        binding.buttonHome3.setOnClickListener {
            val uri = Uri.parse("android-app://com.android.app/notifications")
            findNavController().navigate(uri)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}