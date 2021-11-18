package com.android.app.ui.notifications

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentNotificationsDetailsBinding

class NotificationsDetailsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsDetailsBinding.inflate(inflater, container, false)

        binding.buttonNotifications.setOnClickListener {
            findNavController().navigate(R.id.home_navigation)
        }

        binding.buttonNotifications1.setOnClickListener {
            findNavController().navigate(R.id.home_dest)
        }

        binding.buttonNotifications2.setOnClickListener {
            findNavController().navigate(R.id.home_details_dest)
        }

        binding.buttonNotifications3.setOnClickListener {
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