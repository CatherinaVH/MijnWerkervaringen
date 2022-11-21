package com.example.mijnwerkervaringen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.mijnwerkervaringen.databinding.FragmentAddErvaringBinding
import com.example.mijnwerkervaringen.databinding.FragmentGebruikerBinding

class AddErvaringFragment : Fragment() {

    private lateinit var viewModel: AddErvaringViewModel
    private lateinit var binding: FragmentAddErvaringBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_ervaring, container, false)

        viewModel = ViewModelProvider(this).get(AddErvaringViewModel::class.java)

        setHasOptionsMenu(true)

        binding.myModel = viewModel

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}