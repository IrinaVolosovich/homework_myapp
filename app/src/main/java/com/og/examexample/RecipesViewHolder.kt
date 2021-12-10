package com.og.examexample

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecipesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val recipesTitleTextView: TextView = itemView.findViewById(R.id.recipes_title_text_view)
    private val difficultyLevelTextView: TextView = itemView.findViewById(R.id.difficulty_level_text_view)


    fun bind(recipes: Recipe) {

        recipesTitleTextView.text = "Dish - ${recipes.title}"
        difficultyLevelTextView.text = "Difficulty level - ${recipes.difficultyLevel}"
        val recipesUri:String = "${recipes.uri}"


        itemView.setOnClickListener {
            val link = Uri.parse(recipesUri)
            val intent = Intent(Intent.ACTION_VIEW, link)
            itemView.context.startActivity(intent)
        }
    }

}