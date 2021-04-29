package com.decagon.anietie.justlogin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.decagon.anietie.justlogin.Validator.validateEmail
import com.decagon.anietie.justlogin.Validator.validateGender
import com.decagon.anietie.justlogin.Validator.verifyPhoneNum
import java.util.regex.Pattern


class RegisterFragment : Fragment() {


    lateinit var phone: EditText
    lateinit var fullName: EditText
    lateinit var email: EditText
    lateinit var spinner: Spinner
    lateinit var submit: Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        phone = view.findViewById(R.id.et_phone_number)
        fullName = view.findViewById<EditText>(R.id.et_full_name)
        email = view.findViewById<EditText>(R.id.et_email)
        spinner = view.findViewById<Spinner>(R.id.spinner_gender)
        submit = view.findViewById<Button>(R.id.btn_register)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit.setOnClickListener{
            val phoneNumber = phone.text.toString()
            val name = fullName.text.toString()
            val emailAddress = email.text.toString()
            val gender = spinner.selectedItem.toString()


            if(name.isEmpty() || phoneNumber.isEmpty() || emailAddress.isEmpty() || gender.isEmpty()) {
                Toast.makeText(requireContext(), "Some Fields are Empty", Toast.LENGTH_SHORT).show()
            }
            else if (!verifyPhoneNum(phoneNumber)) {
                Toast.makeText(requireContext(), "Invalid Phone Number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if(!validateGender(gender)) {
                Toast.makeText(requireContext(), "Select a valid Gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if(!validateEmail(emailAddress)) {
                Toast.makeText(requireContext(), "Invalid Email address", Toast.LENGTH_SHORT).show()
            }


            else {

                val intent = Intent(context, DisplayActivity::class.java)
                intent.putExtra("name", "Full Name: $name")
                intent.putExtra("email", "Email: $emailAddress")
                intent.putExtra("phone", "Phone Number: $phoneNumber")
                intent.putExtra("gender", "Gender: $gender")

                startActivity(intent)
            }


        }

    }


}