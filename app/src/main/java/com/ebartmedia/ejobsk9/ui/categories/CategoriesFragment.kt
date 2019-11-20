package com.ebartmedia.ejobsk9.ui.categories

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer

import com.ebartmedia.ejobsk9.R
import com.ebartmedia.ejobsk9.ui.gallery.GalleryViewModel

//class CategoriesFragment : Fragment() {
//
//    companion object {
//        fun newInstance() = CategoriesFragment()
//    }
//
//    private lateinit var viewModel: CategoriesViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_categories, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(CategoriesViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
//
//}

class CategoriesFragment : Fragment() {

    private lateinit var categoriesViewModel: CategoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoriesViewModel =
            ViewModelProviders.of(this).get(CategoriesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_categories, container, false)
        val textView: TextView = root.findViewById(R.id.text_categories)
        categoriesViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}
