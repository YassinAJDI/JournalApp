package me.jerryhanks.journalapp.ui.entrydetails

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import me.jerryhanks.journalapp.R

private const val EXTRA_DIARY_ID = "diary_id"

class DetailsFragment : Fragment() {

    private var diaryId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            diaryId = it.getString(EXTRA_DIARY_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }


//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }
//

    companion object {
        @JvmStatic
        fun newInstance(param1: String, diaryId: String) =
                DetailsFragment().apply {
                    arguments = Bundle().apply {
                        putString(EXTRA_DIARY_ID, diaryId)
                    }
                }
    }
}
