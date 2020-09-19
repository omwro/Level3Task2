package nl.omererdem.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add.*

const val PORTAL_TITLE = "portal_title"
const val PORTAL_URL = "portal_url"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddPortal.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal() {
        val titleTxt = etTitle.text.toString()
        val urlTxt = etUrl.text.toString()
        if (titleTxt.isNotBlank() && urlTxt.isNotBlank()) {
            val bundle = Bundle()
            bundle.putString(PORTAL_TITLE, titleTxt)
            bundle.putString(PORTAL_URL, urlTxt)
            findNavController().navigate(R.id.action_addFragment_to_homeFragment, bundle)
        } else {
            Snackbar.make(etTitle, getString(R.string.invalid_field), Snackbar.LENGTH_LONG).show()
        }
    }
}