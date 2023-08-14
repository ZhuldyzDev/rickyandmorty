package kz.bcc.school.ui.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import bcc.school.app.R
import bcc.school.app.databinding.FragmentCartoonCharacterBinding
import kz.bcc.school.data.models.network.Status
import kz.bcc.school.ui_common.base.BaseFragment

class CharactersFragment : BaseFragment() {

    private lateinit var binding: FragmentCartoonCharacterBinding
    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cartoon_character, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = getViewModel(CharacterViewModel::class.java!!)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = CharacterAdapter(
            viewModel.recyclerViewItemClickCallback
        )

        observeViewModel()
    }
    private fun observeViewModel() {
        viewModel.getCharactersResource.observe(
            viewLifecycleOwner,
            Observer {
                when (it.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {
                        viewModel.onCharactersSuccess(it.data!!)
                    }
                    Status.ERROR -> {
                    }
                }
            }
        )
        viewModel.searchResource.observe(
            viewLifecycleOwner,
            Observer {
                when (it.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {
                        viewModel.onCharactersSuccess(it.data!!)
                    }
                    Status.ERROR -> {
                        error(it)
                    }
                }
            }
        )
        viewModel.getAllCharacterFromDB.observe(
            viewLifecycleOwner,
            Observer {
                (binding.recyclerView.adapter as CharacterAdapter).submitList(it)
                (binding.recyclerView.adapter as CharacterAdapter).notifyDataSetChanged()
            }
        )
        viewModel.listCharacterLD.observe(
            viewLifecycleOwner,
            Observer {
                (binding.recyclerView.adapter as CharacterAdapter).submitList(it.cartoonCharacters)
                (binding.recyclerView.adapter as CharacterAdapter).notifyDataSetChanged()
            }
        )
        viewModel.btnClick.observe(
            viewLifecycleOwner,
            Observer {
                it.getContentIfNotHandled()?.let {
                    val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(it)
                    findNavController().navigate(
                        action
                    )
                }
            }
        )
    }
}