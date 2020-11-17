package by.khryshchanovich.androidapplication.light_sensor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.khryshchanovich.androidapplication.R

class LightSensorAdapter(private val lightSensorList: ArrayList<LightSensor>) :
    RecyclerView.Adapter<LightSensorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sensor, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return lightSensorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(lightSensorList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(lightSensor: LightSensor) {
            val name = itemView.findViewById<TextView>(R.id.name_text_view)
            val value = itemView.findViewById<TextView>(R.id.value_text_view)
            name.text = lightSensor.name
            value.text = lightSensor.value
        }
    }
}