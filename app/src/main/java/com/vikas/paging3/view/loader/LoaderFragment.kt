package com.vikas.paging3.view.loader

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vikas.paging3.R
import com.vikas.paging3.view.loader.adapter.LoaderDoggoImageAdapter
import com.vikas.paging3.view.loader.adapter.LoaderStateAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@ExperimentalPagingApi
class LoaderFragment : Fragment(R.layout.fragment_loader) {

    lateinit var rvDoggoLoader: RecyclerView
    lateinit var loaderViewModel: LoaderViewModel
    lateinit var adapter: LoaderDoggoImageAdapter
    lateinit var loaderStateAdapter: LoaderStateAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMembers()
        setUpViews(view)
        fetchDoggoImages()
    }

    private fun fetchDoggoImages() {
        lifecycleScope.launch {
            loaderViewModel.fetchDoggoImages().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun initMembers() {
        loaderViewModel = defaultViewModelProviderFactory.create(LoaderViewModel::class.java)
        adapter = LoaderDoggoImageAdapter()
        loaderStateAdapter = LoaderStateAdapter { adapter.retry() }
    }

    private fun setUpViews(view: View) {
        rvDoggoLoader = view.findViewById(R.id.rvDoggoLoader)
        rvDoggoLoader.layoutManager = GridLayoutManager(context, 2)
        rvDoggoLoader.adapter = adapter.withLoadStateFooter(loaderStateAdapter)
    }
}