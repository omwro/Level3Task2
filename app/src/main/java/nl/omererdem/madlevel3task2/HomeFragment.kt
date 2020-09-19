package nl.omererdem.madlevel3task2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeAddPortalResult()
    }

    private fun initViews() {
        rvPortals.layoutManager = GridLayoutManager(context, 2)
        rvPortals.adapter = portalAdapter

        createItemTouchHelper().attachToRecyclerView(rvPortals)
    }

    private fun observeAddPortalResult() {
        val portalTitle = arguments?.getString(PORTAL_TITLE)
        val portalUrl = arguments?.getString(PORTAL_URL)
        if (portalTitle != null && portalUrl != null) {
            Log.i("1", portals.toString())
            Log.i("2", Portal(portalTitle, portalUrl).toString())
            portals.add(Portal(portalTitle, portalUrl))
            portalAdapter.notifyDataSetChanged()
            Log.i("3", portals.toString())
        }
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                portals.removeAt(position)
                portalAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }
}