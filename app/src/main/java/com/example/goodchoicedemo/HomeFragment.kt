package com.example.goodchoicedemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.goodchoicedemo.adapter.HomeAdapter
import com.example.goodchoicedemo.architecture.HomeViewModel
import com.example.goodchoicedemo.listeners.RecyclerViewLoadMoreListener
import com.example.goodchoicedemo.model.MainListResponse
import com.example.goodchoicedemo.model.ResProductListModel
import com.example.goodchoicedemo.util.AlertUtil
import com.example.goodchoicedemo.util.WLog
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.widget.Toast.makeText as makeText1

class HomeFragment : Fragment() {

    private val mainListViewModel: HomeViewModel by viewModel()

    private var isLoading = false
    private var isLoadMore = true
    private var page = 1
    private val items = ArrayList<ResProductListModel>()

    private val onScrollListener = RecyclerViewLoadMoreListener {
        if (isLoadMore && !isLoading) requestMainList(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity ?: return

        recycler_view.adapter = HomeAdapter(activity)

        mainListViewModel.homeListLiveData.observe(activity, Observer {
            it.let { resProductModel ->
                (recycler_view.adapter as HomeAdapter).run {
                    items.add(resProductModel)
                    putItems(items)
                }
            }
            isLoading = false
            AlertUtil.hideProgress()
        })

        requestMainList()
    }

    override fun onResume() {
        super.onResume()
        recycler_view.addOnScrollListener(onScrollListener)
    }

    override fun onPause() {
        recycler_view.removeOnScrollListener(onScrollListener)
        super.onPause()
    }

    private fun requestMainList(isClear: Boolean = true) {
        val activity = activity ?: return
        if (isLoading) return

        if (isClear) {
            page = 1
            isLoadMore = true
            (recycler_view.adapter as HomeAdapter).clearAdapter()
        } else {
            page += 1
        }
        if (page == 4){
            return
        }

        isLoading = true
        AlertUtil.showProgress(activity)
        mainListViewModel.requestMainList(page)
    }
}