package com.chionger.yahoo.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.chionger.yahoo.myapplication.models.BoardSize
import kotlin.math.min

class MemoryBoardAdapter(
        private val context: Context,
        private val boardSize: BoardSize,
        private val cardImages: List<Int>
):
        RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {
        //MemoryBoardAdapter is a class which is a subclass of the RecyclerView.Adpater class
        // due to ":" at in the definiation
        // The RecyclerView.Adapter class is an abstract class which means need to override methods
        // when create
        //parametized by <RecyclerView.ViewHolder> - A
        //Viewholder provides access to all the views of one recycler view element - 1 memory piece in this game
        // create inner class ViewGolder which inherit from RecyclerView.ViewHolder - A
        // replace RecyclerView.Adapter to be parametized by the newly created inner class instead of the base class

        companion object{
                private const val MARGIN_SIZE = 10
                private const val TAG = "Memory Board Adapter"
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                //how to create 1 view
                val cardWidth = parent.width/boardSize.getWidth()-(2* MARGIN_SIZE)
                val cardHeight = parent.height/boardSize.getHeight() - (2* MARGIN_SIZE)
                val cardSideLength = min(cardWidth,cardHeight)
                val view = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
                val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.width = cardSideLength
                layoutParams.height = cardSideLength
                layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
                return ViewHolder(view)
                //return view wrapped inside ViewHolder
        }

        override fun getItemCount() = boardSize.numCards
                //how many elements in the recycler view

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.bind(position)
        }

        // inner class
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)

                fun bind(position: Int) {
                        imageButton.setImageResource(cardImages[position])

                        imageButton.setOnClickListener{
                                Log.i(TAG, "Clicked on position $position")

                        }
                }
        }

}
