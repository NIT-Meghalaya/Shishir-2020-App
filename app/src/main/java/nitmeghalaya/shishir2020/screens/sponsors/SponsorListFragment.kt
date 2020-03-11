package nitmeghalaya.shishir2020.screens.sponsors

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.SponsorItem
import nitmeghalaya.shishir2020.screens.getJsonFromList
import nitmeghalaya.shishir2020.screens.getListFromJson
import nitmeghalaya.shishir2020.screens.makeShortToast

class SponsorListFragment : Fragment() {

    private var sponsorList = ArrayList<SponsorItem>()
//    private var animationController: LoadingAnimationController? = null

    val db = FirebaseFirestore.getInstance()
    companion object {
        @JvmStatic
        fun newInstance() = SponsorListFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View {
        val view = inflater.inflate(R.layout.fragment_sponsor_list, container, false)
//        animationController?.showLoadingAnimation()
        getSponsors(view)

        return view
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (activity is LoadingAnimationController)
//            animationController = activity as LoadingAnimationController
//        else
//            throw RuntimeException("Activity not a LoadingAnimationController")
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        animationController = null
//    }

    private fun getSponsors(view: View) {
        db.collection("newSponsors").document("sponsors").get()
            .addOnSuccessListener {documentSnapshot ->
                documentSnapshot.data?.forEach {
                    sponsorList = makeList(it.value as ArrayList<SponsorItem>)
                }

                if (sponsorList.size > 0) {
                    view as RecyclerView
                    view.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = SponsorListAdapter(sponsorList)
                        addItemDecoration(VerticalItemDecoration())
                    }
                }
//                if (!isDetached)
//                    animationController?.hideLoadingAnimation()

            }.addOnFailureListener {
                makeShortToast(context!!,"error")
            }
    }


    private fun reorganiseSponsors(sponsorsList: ArrayList<SponsorItem>) {
        val printingPartners = arrayListOf<SponsorItem>()
        val radioPartners = arrayListOf<SponsorItem>()
        val decoratingPartners = arrayListOf<SponsorItem>()
        val foodPartners = arrayListOf<SponsorItem>()
        val hospitalityPartners = arrayListOf<SponsorItem>()
        val mediaPartners = arrayListOf<SponsorItem>()
        val fashionSponsors = arrayListOf<SponsorItem>()
        val otherSponsors = arrayListOf<SponsorItem>()
        val inAssociationWith = arrayListOf<SponsorItem>()

        sponsorsList.forEach {
            when(it.type) {
                "printing" -> printingPartners.add(it)
                "radio" -> radioPartners.add(it)
                "decorating" -> decoratingPartners.add(it)
                "food" -> foodPartners.add(it)
                "hospitality" -> hospitalityPartners.add(it)
                "media" -> mediaPartners.add(it)
                "fashion" -> fashionSponsors.add(it)
                "others" -> otherSponsors.add(it)
                "inAssociationWith" -> inAssociationWith.add(it)
            }
        }

        val newList = arrayListOf<SponsorItem>()
        newList.add(0, SponsorItem("In Association With", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(inAssociationWith)
        newList.add(SponsorItem("Printing Partner", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(printingPartners)
        newList.add(SponsorItem("Radio Partner", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(radioPartners)
        newList.add(SponsorItem("Decoration Partner", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(decoratingPartners)
        newList.add(SponsorItem("Food Partner", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(foodPartners)
        newList.add(SponsorItem("Hospitality Partner", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(hospitalityPartners)
        newList.add(SponsorItem("Media Partner", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(mediaPartners)
        newList.add(SponsorItem("Fashion Sponsors", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(fashionSponsors)
        newList.add(SponsorItem("Other Sponsors", type = SponsorListAdapter.TYPE_HEADING))
        newList.addAll(otherSponsors)


        val map = mutableMapOf<String, ArrayList<SponsorItem>>()
        map["sponsors"] = newList
        db.collection("newSponsors").document("sponsors").set(map)
            .addOnSuccessListener {
                Log.v("data added", newList.toString())
            }
    }

    private fun makeList(listMap: ArrayList<SponsorItem>): ArrayList<SponsorItem> {
        val json = Gson().getJsonFromList<ArrayList<SponsorItem>>(listMap)
        return Gson().getListFromJson(json)
    }
}
