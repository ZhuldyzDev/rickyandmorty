package kz.test.rickandmorty.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kz.test.rickandmorty.R
import kz.test.rickandmorty.data.models.CartoonCharacter
import kz.test.rickandmorty.databinding.CartoonCharacterListRowBinding
import kz.test.rickandmorty.ui_common.callbacks.RecyclerViewItemClickCallback


class CharacterAdapter(
    var recyclerViewItemClickCallback: RecyclerViewItemClickCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<CartoonCharacter>() {

        override fun areItemsTheSame(
            oldItem: CartoonCharacter,
            newItem: CartoonCharacter
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: CartoonCharacter,
            newItem: CartoonCharacter
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(list: List<CartoonCharacter>) {
        differ.submitList(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CartoonCharacterListRowBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.cartoon_character_list_row,
                parent,
                false
            )
        return CartoonCharacterViewHolder(binding)
    }

    inner class CartoonCharacterViewHolder(var binding: CartoonCharacterListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun initContent(character: CartoonCharacter) {
            binding.cartoonCharacterItem = character
            binding.recyclerViewItemClickCallback = recyclerViewItemClickCallback
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as CartoonCharacterViewHolder
        viewHolder.initContent(differ.currentList[position] as CartoonCharacter)
    }

}