package com.example.clickingbad.ui.scenes.distribution

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clickingbad.R
import com.example.clickingbad.ui.adapters.DistributionListAdapter
import com.example.clickingbad.utils.fetchJson
import kotlinx.android.synthetic.main.fragment_distribution.*

class DistributionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_distribution, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonFileString = fetchJson(activity?.applicationContext)

        rv_distribution.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = DistributionListAdapter(
                jsonFileString.distribution
            )
        }
    }
}
