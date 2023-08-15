package kz.test.rickandmorty.ui.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kz.test.rickandmorty.R
import kz.test.rickandmorty.data.models.network.Status
import kz.test.rickandmorty.databinding.FragmentCartoonCharacterBinding
import kz.test.rickandmorty.ui_common.base.BaseFragment


class CharactersFragment : BaseFragment() {

    private lateinit var binding: FragmentCartoonCharacterBinding
    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cartoon_character, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(CharacterViewModel::class.java)
        binding.viewModel = viewModel
        setupUi()
        observeViewModel()
    }

    private fun setupUi() {
        binding.recyclerView.adapter = CharacterAdapter(
            viewModel.recyclerViewItemClickCallback
        )
    }

    private fun observeViewModel() = with(viewModel) {
        getCharactersResource.observe(
            viewLifecycleOwner
        ) {
            when (it.status) {
                Status.LOADING ->{
                    showProgressDialog()
                }
                Status.SUCCESS -> {
                    dismissProgressDialog()
                    onCharactersSuccess(it.data!!)
                }
                Status.ERROR -> {
                    dismissProgressDialog()
                    handleExceptionDialog(it.exception)
                }
            }
        }
        searchResource.observe(
            viewLifecycleOwner
        ) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { it1 -> onCharactersSuccess(it1) }
                }
            }
        }
        getAllCharacterFromDB.observe(
            viewLifecycleOwner
        ) {
            setAllCharacterFromDB(it)
        }
        charactersList.observe(
            viewLifecycleOwner
        ) {
            (binding.recyclerView.adapter as CharacterAdapter).submitList(it)
        }
        listCharacterLD.observe(
            viewLifecycleOwner
        ) {
            (binding.recyclerView.adapter as CharacterAdapter).submitList(it.cartoonCharacters)
        }
        itemClick.observe(
            viewLifecycleOwner
        ) {
            it.getContentIfNotHandled()?.let {
                val action =
                    CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(
                        it
                    )
                findNavController().navigate(
                    action
                )
            }
        }
    }
}