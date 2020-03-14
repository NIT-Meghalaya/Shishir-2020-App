package nitmeghalaya.shishir2020.screens.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_team_list.view.*
import nitmeghalaya.shishir2020.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamsListFragment : Fragment() {

    private val viewModel: TeamsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_team_list, container, false)


//        showLoadingAnimation()
        viewModel.getTeams().observe(this, Observer {
            view.recyclerView.adapter = TeamListRecyclerViewAdapter(it)

//            hideLoadingAnimation()
        })

        return view
    }


}
