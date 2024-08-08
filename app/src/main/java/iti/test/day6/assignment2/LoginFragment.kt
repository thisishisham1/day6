package iti.test.day6.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import iti.test.day6.R


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.submit_button).setOnClickListener {
            val firstName = view.findViewById<EditText>(R.id.first_name).text
            val lastName = view.findViewById<EditText>(R.id.last_name).text

            if (firstName.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(requireContext(), "some filed empty", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToRetriveFragment(
                        firstName.toString(),
                        lastName.toString()
                    )
                )
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

}