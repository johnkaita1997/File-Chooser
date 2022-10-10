package paita.stream_app_final.Tafa.Adapters

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_freeto_watch.view.*
import kotlinx.android.synthetic.main.custom_subject_freetowatch.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import paita.stream_app_final.Extensions.myViewModel
import paita.stream_app_final.Extensions.playVideos
import paita.stream_app_final.R
import paita.stream_app_final.Tafa.Activities.FreeToWatchActivity
import paita.stream_app_final.Tafa.Activities.VideoViewerActivity


class FreeToWatchAdapter(var activity: Activity, val videoList: List<Detail_FreeVideos>?) : RecyclerView.Adapter<FreeToWatchAdapter.SubjectHolder>() {

    lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        view = layoutInflater.inflate(R.layout.custom_freeto_watch, parent, false)
        return SubjectHolder(view)
    }

    override fun getItemCount(): Int {
        return videoList!!.size
    }

    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {

        val videoObject = videoList!!.get(position);

        holder.itemView.freetowatchLinearlayout.setOnClickListener {
            val videoid = videoObject.videoid
            activity.playVideos(videoid)
        }

    }


    class SubjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

}