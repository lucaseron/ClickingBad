package com.example.clickingbad.ui.scenes.manufacturing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clickingbad.R
import com.example.clickingbad.business_logic.models.ManufacturingItem
import com.example.clickingbad.ui.adapters.ManufacturingListAdapter
import com.example.clickingbad.ui.adapters.OnObjectClickedListener
import kotlinx.android.synthetic.main.fragment_manufacturing.rv_manufacturing

class ManufacturingFragment : Fragment(), OnObjectClickedListener<ManufacturingItem> {

//    same shizzle
//    private val viewModel2 = ViewModelProvider(this).get(ManufacturingViewModel::class.java)
//    private val viewModelAct2 = ViewModelProvider(requireActivity()).get(ManufacturingViewModel::class.java)
//    private val viewModelAct: ManufacturingViewModel by activityViewModels()

    private val viewModel: ManufacturingViewModel by viewModels()
    private val manufacturingAdapter = ManufacturingListAdapter(this) // é o seu madruga

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_manufacturing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // primeiro
        rv_manufacturing.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = manufacturingAdapter
        }

        // asynchronous
        viewModel.liveManufacturingDb.observe(viewLifecycleOwner, Observer {
            manufacturingAdapter.submitList(it)
        })
    }

    override fun onObjectClicked(dataObj: ManufacturingItem) {
        super.onObjectClicked(dataObj)
        viewModel.updateManufacturingList(dataObj)
    }

}
