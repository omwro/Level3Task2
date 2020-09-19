package nl.omererdem.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter (private val portals: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun databind(portal: Portal) {
            itemView.rvPortals.tvTitle.text = portal.title
            itemView.rvPortals.tvUrl.text = portal.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {
        holder.databind(portals[position])
    }

    override fun getItemCount(): Int {
        return portals.size
    }

}