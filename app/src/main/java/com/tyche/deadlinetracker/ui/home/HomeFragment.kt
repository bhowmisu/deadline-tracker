package com.tyche.deadlinetracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.tyche.deadlinetracker.R
import com.tyche.deadlinetracker.ui.adapter.PersonalDocumentPageAdapter

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

//        viewpager.setPageTransformer(MarginPageTransformer(50))


        with(viewpager) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
        viewpager.setPageTransformer { page, position ->
            val viewPager = page.parent.parent as ViewPager2
            val offset = position * -(2 * offsetPx + pageMarginPx)
            if (viewPager.orientation == ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }
        }


        val adapter = PersonalDocumentPageAdapter()

        viewpager.adapter = adapter

        homeViewModel?.modelLiveData?.observe(viewLifecycleOwner, Observer {
            adapter.setItem(it)
        })

        return root
    }
}