package kz.bcc.school.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import bcc.school.app.R
import bcc.school.app.databinding.CartoonCharacterListRowBinding
import kz.bcc.school.data.models.CartoonCharacter
import kz.bcc.school.ui_common.callbacks.RecyclerViewItemClickCallback


class CharacterAdapter (
    var recyclerViewItemClickCallback: RecyclerViewItemClickCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Any>() {

        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return when {
                oldItem is CartoonCharacter && newItem is CartoonCharacter -> {
                    oldItem.name == newItem.name
                }
                else -> {
                    false
                }
            }
        }

        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return when {
                oldItem is CartoonCharacter && newItem is CartoonCharacter -> {
                    oldItem as CartoonCharacter == newItem as CartoonCharacter
                }
                else -> {
                    false
                }
            }
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(list: List<Any>) {
        differ.submitList(list)
    }

    companion object {
        private const val VIEW_TYPE_MENU = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_MENU -> {
                val binding: CartoonCharacterListRowBinding =
                    DataBindingUtil.inflate(
                        inflater,
                        R.layout.cartoon_character_list_row,
                        parent,
                        false
                    )
                CartoonCharacterViewHolder(binding)
            }
            else -> {
                throw IllegalStateException("Incorrect ViewType found")
            }
        }
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
        when (holder.itemViewType) {
            VIEW_TYPE_MENU -> {
                val viewHolder = holder as CartoonCharacterViewHolder
                viewHolder.initContent(differ.currentList[position] as CartoonCharacter)
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (differ.currentList[position]) {
            is CartoonCharacter -> VIEW_TYPE_MENU
            else -> throw IllegalStateException("Incorrect ViewType found")
        }

}