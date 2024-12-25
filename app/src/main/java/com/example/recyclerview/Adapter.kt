import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.ColorData
import com.example.recyclerview.R

class Adapter(
    private val context: Context,
    private val list: ArrayList<ColorData>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // ViewHolder для управления элементами rview_item.xml
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val colorView: View = view.findViewById(R.id.view)
        val colorName: TextView = view.findViewById(R.id.textView)
    }

    // Создание нового ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item, parent, false)
        return ViewHolder(view)
    }

    // Получение количества элементов в списке
    override fun getItemCount(): Int {
        return list.size
    }

    // Привязка данных к ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.colorView.setBackgroundColor(data.colorHex) // Устанавливаем цвет
        holder.colorName.text = data.colorName // Устанавливаем имя цвета
    }
}
