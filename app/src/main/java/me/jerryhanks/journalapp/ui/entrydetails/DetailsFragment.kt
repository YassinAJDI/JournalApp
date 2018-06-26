package me.jerryhanks.journalapp.ui.entrydetails

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import kotlinx.android.synthetic.main.fragment_details.*

import me.jerryhanks.journalapp.R
import org.koin.android.ext.android.inject

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appCompatActivity = requireActivity() as AppCompatActivity
        appCompatActivity.setSupportActionBar(toolbar)
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        @JvmStatic
        fun newInstance(diaryId: String) =
                DetailsFragment().apply {
                    arguments = Bundle().apply {
                        putString(EXTRA_DIARY_ID, diaryId)
                    }
                }
    }
}
