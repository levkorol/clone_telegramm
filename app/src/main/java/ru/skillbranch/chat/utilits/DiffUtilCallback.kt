package ru.skillbranch.chat.utilits

import androidx.recyclerview.widget.DiffUtil
import ru.skillbranch.chat.models.CommonModel

class DiffUtilCallback(
    private val oldList: List<CommonModel>,
    private val newList: List<CommonModel>
): DiffUtil.Callback() {
    //проверяет по айди
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
       oldList[oldItemPosition].timeStamp == newList[newItemPosition].timeStamp

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    //проверяет по значениям если айди одинаковое
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}