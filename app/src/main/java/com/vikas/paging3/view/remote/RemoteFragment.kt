package com.vikas.paging3.view.remote

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vikas.paging3.R
import com.vikas.paging3.view.remote.adapter.RemoteDoggoImageAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

/**
 * View to fetch the results from the remote api and directly shows in the recyclerview
 * with lazy pagination enabled
 */
class RemoteFragment : Fragment(R.layout.fragment_remote) {

    lateinit var rvDoggoRemote: RecyclerView
    lateinit var remoteViewModel: RemoteViewModel
    lateinit var adapter: RemoteDoggoImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMembers()
        setUpViews(view)
        fetchDoggoImages()
    }

    private fun fetchDoggoImages() {
        lifecycleScope.launch {
            remoteViewModel.fetchDoggoImages().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun initMembers() {
        remoteViewModel = defaultViewModelProviderFactory.create(RemoteViewModel::class.java)
        adapter = RemoteDoggoImageAdapter()
    }

    private fun setUpViews(view: View) {
        rvDoggoRemote = view.findViewById(R.id.rvDoggoRemote)
        rvDoggoRemote.layoutManager = GridLayoutManager(context, 2)
        rvDoggoRemote.adapter = adapter
    }
}