package com.tyche.deadlinetracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.tyche.deadlinetracker.R
import com.tyche.deadlinetracker.data.DeadlineDatabase
import com.tyche.deadlinetracker.ui.adapter.PersonalDocumentPageAdapter
import com.tyche.deadlinetracker.ui.model.PersonalDocumentModel

class HomeFragment : Fragment() {

    private var homeViewModel: HomeViewModel? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel::class.java)

        homeViewModel =
            activity?.application?.let { ViewModelProvider.AndroidViewModelFactory.getInstance(it).create(HomeViewModel::class.java) }


        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val viewpager: ViewPager2 = root.findViewById(R.id.viewpager)
        viewpager.clipToPadding = false
        viewpager.setPadding(30, 0, 30, 0)

        val adapter = PersonalDocumentPageAdapter()

        viewpager.adapter = adapter

        homeViewModel?.modelLiveData?.observe(viewLifecycleOwner, Observer {
            adapter.setItem(it)
        })

//        homeViewModel?.addPersonalDocument(PersonalDocumentModel(4, "Drivers license"))


        return root
    }
}