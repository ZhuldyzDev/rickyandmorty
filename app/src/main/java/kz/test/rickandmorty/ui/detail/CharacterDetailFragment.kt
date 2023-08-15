package kz.test.rickandmorty.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.test.rickandmorty.R
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import kz.test.rickandmorty.databinding.FragmentCartoonCharacterDetailBinding
import kz.test.rickandmorty.ui_common.base.BaseFragment


class CharacterDetailFragment : BaseFragment() {
    private val args: CharacterDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentCartoonCharacterDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cartoon_character_detail, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cartoonCharacter =args.character
    }

}