package ru.skillbranch.chat.ui.fragments.single_chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item.view.*
import ru.skillbranch.chat.R
import ru.skillbranch.chat.models.CommonModel
import ru.skillbranch.chat.database.CURRENT_UID
import ru.skillbranch.chat.utilits.DiffUtilCallback
import ru.skillbranch.chat.utilits.asTime

class SingleChatAdapter : RecyclerView.Adapter<SingleChatAdapter.SingleChatHolder>() {

    private var mListMessagesCache = mutableListOf<CommonModel>()
    private lateinit var mDiffResult: DiffUtil.DiffResult

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return SingleChatHolder(view)
    }

    override fun getItemCount(): Int = mListMessagesCache.size

    override fun onBindViewHolder(holder: SingleChatHolder, position: Int) {
        if (mListMessagesCache[position].from == CURRENT_UID) {
            holder.blockUserMessage.visibility = View.VISIBLE
            holder.blockReceivedMessage.visibility = View.GONE
            holder.chatUserMessage.text = mListMessagesCache[position].text
            holder.chatUserMessageTime.text =
                mListMessagesCache[position].timeStamp.toString().asTime()
        } else {
            holder.blockUserMessage.visibility = View.GONE
            holder.blockReceivedMessage.visibility = View.VISIBLE
            holder.chatReceivedMessage.text = mListMessagesCache[position].text
            holder.chatReceivaedMessageTime.text =
                mListMessagesCache[position].timeStamp.toString().asTime()
        }
    }

    fun addItemToBottom(item: CommonModel, onSuccess: () -> Unit) {
        if (!mListMessagesCache.contains(item)) {
            mListMessagesCache.add(item)
            notifyItemInserted(mListMessagesCache.size)
        }

        onSuccess()
    }

    fun addItemToTop(item: CommonModel, onSuccess: () -> Unit) {

        if (!mListMessagesCache.contains(item)) {
            mListMessagesCache.add(item)
            mListMessagesCache.sortBy { it.timeStamp.toString() }
            notifyItemInserted(0)
        }
        onSuccess()
    }

//        val newList = mutableListOf<CommonModel>()
//        newList.addAll(mListMessagesCache)
//
//        if(!newList.contains(item))newList.add(item)
//        newList.sortBy { it.timeStamp.toString() }
//        mDiffResult = DiffUtil.calculateDiff(DiffUtilCallback(mListMessagesCache, newList))
//        mDiffResult.dispatchUpdatesTo(this)
//        mListMessagesCache = newList


    class SingleChatHolder(view: View) : RecyclerView.ViewHolder(view) {
        val blockUserMessage: ConstraintLayout = view.block_user_message
        val chatUserMessage: TextView = view.chat_user_message
        val chatUserMessageTime: TextView = view.chat_user_time

        val blockReceivedMessage: ConstraintLayout = view.block_received_message
        val chatReceivedMessage: TextView = view.chat_received_message
        val chatReceivaedMessageTime: TextView = view.chat_received_time
    }
}

