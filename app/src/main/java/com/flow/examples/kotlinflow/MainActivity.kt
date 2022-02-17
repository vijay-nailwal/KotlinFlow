package com.flow.examples.kotlinflow

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.flow.examples.kotlinflow.adapter.PostAdapter
import com.flow.examples.kotlinflow.databinding.ActivityMainBinding
import com.flow.examples.kotlinflow.model.PostModel
import com.flow.examples.kotlinflow.repository.PostRepository
import com.flow.examples.kotlinflow.viemodel.PostViewModel
import com.flow.examples.kotlinflow.viemodel.PostViewModelFactory
import com.flow.examples.util.LogUtil


class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initUi()
        val postViewModelFactory = PostViewModelFactory(PostRepository())
        postViewModel = ViewModelProvider(this, postViewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postData.observe(this, Observer {
            LogUtil.d(" ${it[0].body}")
            postAdapter.setPostData(it as ArrayList<PostModel>)
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        })
    }

    private fun initUi() {
        postAdapter = PostAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}