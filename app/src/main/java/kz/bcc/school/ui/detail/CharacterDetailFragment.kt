package kz.bcc.school.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import bcc.school.app.R
import bcc.school.app.databinding.FragmentCartoonCharacterBinding
import bcc.school.app.databinding.FragmentCartoonCharacterDetailBinding
import kz.bcc.school.ui.character.CharacterViewModel
import kz.bcc.school.ui_common.base.BaseFragment

class CharacterDetailFragment : BaseFragment() {
    private val args: CharacterDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentCartoonCharacterDetailBinding
    private lateinit var viewModel: CharacterDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cartoon_character_detail, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = getViewModel(CharacterDetailViewModel::class.java!!)
        binding.viewModel = viewModel
        binding.cartoonCharacter =args.character
    }

}