package com.example.mijnwerkervaringen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mijnwerkervaringen.databinding.FragmentLijstErvaringenBinding

class LijstErvaringenFragment : Fragment() {

    private lateinit var viewModel: LijstErvaringenViewModel
    private lateinit var binding: FragmentLijstErvaringenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lijst_ervaringen, container, false)
        viewModel = ViewModelProvider(this).get(LijstErvaringenViewModel::class.java)

        binding.lijstErvaringen.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        var adapter = LijstErvaringenAdapter(ErvaringClickListener {
            viewModel.clickErvaring(it)
        })

        viewModel.ervaringen.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        } )

        viewModel.voegNieuweErvaringToe.observe(viewLifecycleOwner, Observer {
            if (it) {
                navigeerNaarNieuweErvaringToevoegen()
            }
        })

        binding.myModel = viewModel

        binding.lijstErvaringen.adapter = adapter
        val manager = LinearLayoutManager(activity)
        binding.lijstErvaringen.layoutManager = manager

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun navigeerNaarNieuweErvaringToevoegen() {
        requireView().findNavController()
            .navigate(LijstErvaringenFragmentDirections.actionLijstErvaringenFragmentToAddErvaringFragment())
        viewModel.navigateToWerkErvaringenFinished()
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