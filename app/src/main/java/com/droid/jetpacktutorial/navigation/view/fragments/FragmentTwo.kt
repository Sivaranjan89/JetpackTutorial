package com.droid.jetpacktutorial.navigation.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.droid.jetpacktutorial.R
import kotlinx.android.synthetic.main.fragment_two.*


class FragmentTwo : Fragment() {

    private var message: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            message = FragmentTwoArgs.fromBundle(it).text
        }

        fragment_two_button.setOnClickListener{
            val action = FragmentTwoDirections.action_fragmentOne()
            Navigation.findNavController(it).navigate(action)
        }

        label.text = message
    }


}
