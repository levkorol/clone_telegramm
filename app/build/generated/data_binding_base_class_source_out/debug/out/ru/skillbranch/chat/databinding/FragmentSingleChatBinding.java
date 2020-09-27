// Generated by view binder compiler. Do not edit!
package ru.skillbranch.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.skillbranch.chat.R;

public final class FragmentSingleChatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView chatBtnAttach;

  @NonNull
  public final ImageView chatBtnSendMessage;

  @NonNull
  public final ImageView chatBtnVoice;

  @NonNull
  public final EditText chatInputMessage;

  @NonNull
  public final RecyclerView chatRecyclerView;

  @NonNull
  public final SwipeRefreshLayout chatSwipeRefresh;

  private FragmentSingleChatBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView chatBtnAttach, @NonNull ImageView chatBtnSendMessage,
      @NonNull ImageView chatBtnVoice, @NonNull EditText chatInputMessage,
      @NonNull RecyclerView chatRecyclerView, @NonNull SwipeRefreshLayout chatSwipeRefresh) {
    this.rootView = rootView;
    this.chatBtnAttach = chatBtnAttach;
    this.chatBtnSendMessage = chatBtnSendMessage;
    this.chatBtnVoice = chatBtnVoice;
    this.chatInputMessage = chatInputMessage;
    this.chatRecyclerView = chatRecyclerView;
    this.chatSwipeRefresh = chatSwipeRefresh;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSingleChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSingleChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_single_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSingleChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.chat_btn_attach;
      ImageView chatBtnAttach = rootView.findViewById(id);
      if (chatBtnAttach == null) {
        break missingId;
      }

      id = R.id.chat_btn_send_message;
      ImageView chatBtnSendMessage = rootView.findViewById(id);
      if (chatBtnSendMessage == null) {
        break missingId;
      }

      id = R.id.chat_btn_voice;
      ImageView chatBtnVoice = rootView.findViewById(id);
      if (chatBtnVoice == null) {
        break missingId;
      }

      id = R.id.chat_input_message;
      EditText chatInputMessage = rootView.findViewById(id);
      if (chatInputMessage == null) {
        break missingId;
      }

      id = R.id.chat_recycler_view;
      RecyclerView chatRecyclerView = rootView.findViewById(id);
      if (chatRecyclerView == null) {
        break missingId;
      }

      id = R.id.chat_swipe_refresh;
      SwipeRefreshLayout chatSwipeRefresh = rootView.findViewById(id);
      if (chatSwipeRefresh == null) {
        break missingId;
      }

      return new FragmentSingleChatBinding((ConstraintLayout) rootView, chatBtnAttach,
          chatBtnSendMessage, chatBtnVoice, chatInputMessage, chatRecyclerView, chatSwipeRefresh);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
