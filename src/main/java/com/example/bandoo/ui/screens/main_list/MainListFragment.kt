package com.example.bandoo.ui.screens.main_list

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bandoo.R
import com.example.bandoo.database.*
import com.example.bandoo.models.CommonModel
import com.example.bandoo.utilits.APP_ACTIVITY
import com.example.bandoo.utilits.AppValueEventListener
import com.example.bandoo.utilits.hideKeyboard
import kotlinx.android.synthetic.main.fragment_chats.*


class MainListFragment : Fragment(R.layout.fragment_chats) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainListAdapter
    private val mRefMainList = REF_DATABASE_ROOT.child(NODE_MAIN_LIST).child(CURRENT_UID)
    private val mRefUser = REF_DATABASE_ROOT.child(NODE_USERS)
    private val mRefMessages = REF_DATABASE_ROOT.child(NODE_MESSAGES).child(CURRENT_UID)
    private var mListItems = listOf<CommonModel>()

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Bandoo"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mRecyclerView = main_list_recycle_view
        mAdapter = MainListAdapter()
        // first request
        mRefMainList.addListenerForSingleValueEvent(AppValueEventListener{ snapshot ->
            mListItems = snapshot.children.map{
                it.getCommonModel()
            }
            mListItems.forEach { model ->
                // second request
                mRefUser.child(model.id).addListenerForSingleValueEvent(AppValueEventListener{ dataSnapshot ->
                    val newModel = dataSnapshot.getCommonModel()
                    // third request
                    mRefMessages.child(model.id).limitToLast(1).addListenerForSingleValueEvent(AppValueEventListener{ modelLastMessage ->
                        val tempList = modelLastMessage.children.map {tempModel -> tempModel.getCommonModel()}

                        if (tempList.isEmpty()) {
                            newModel.lastMessage = getString(R.string.chats_clear)
                        } else {
                            newModel.lastMessage = tempList[0].text
                        }

                        if (newModel.fullname.isEmpty()) {
                            newModel.fullname = newModel.phone
                        }
                        mAdapter.updateListItems(newModel)
                    })
                })
            }
        })

        mRecyclerView.adapter = mAdapter
    }
}
