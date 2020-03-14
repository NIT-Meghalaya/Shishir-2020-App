package nitmeghalaya.shishir2020.screens.teammembers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.android.synthetic.main.fragment_team_members.view.*
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.TeamMember
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamMembersFragment : Fragment() {

    private val viewModel: TeamMembersViewModel by viewModel()
    private val args: TeamMembersFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_team_members, container, false)
        val teamMembers = viewModel.getTeamMembersList(args.teamJson)

        view.apply {
            discreteScrollView.apply {
                setHasFixedSize(true)
                adapter = TeamMemberRecyclerViewAdapter(teamMembers)
                setOverScrollEnabled(true)

                setItemTransformer(
                    ScaleTransformer.Builder()
                        .setMaxScale(1.05f)
                        .setMinScale(0.8f)
                        .setPivotX(Pivot.X.CENTER)
                        .setPivotY(Pivot.Y.BOTTOM)
                        .build()
                )

                addScrollStateChangeListener(TeamMembersScrollStateChangedListener(
                    view.nameTV, view.postTV, view.emailTV))
            }
        }

        addDataForFirstMemberItem(view, teamMembers[0])

        return view
    }

    private fun addDataForFirstMemberItem(view: View, memberData: TeamMember) {
        view.apply {
            nameTV.text = memberData.name
            postTV.text = memberData.position
            emailTV.text = memberData.email
        }
    }
}
