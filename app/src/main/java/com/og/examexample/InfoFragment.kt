package com.og.examexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfoFragment : Fragment() {

    private lateinit var recipesRecyclerView: RecyclerView
    private lateinit var helpButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val recipeList:List<Recipe> = listOf(
            Recipe ("baked chiken", "easy", "https://1000.menu/catalog/kurica-v-duxovke"),
            Recipe ("pasta boloneze", "easy","https://www.gastronom.ru/recipe/22114/spagetti-boloneze"),
            Recipe ("red fried fish", "easy","https://1000.menu/cooking/41664-krasnaya-ryba-na-skovorode-jarenaya"),
            Recipe ("salad with tuna","easy", "https://www.gastronom.ru/recipe/5038/uzbekskij-plov"),
            Recipe ("uzbekskij plov","medium", "https://www.gastronom.ru/recipe/5038/uzbekskij-plov")
        )

        helpButton=view.findViewById(R.id.help_button)
        recipesRecyclerView = view.findViewById(R.id.recipes_recycler_view)
        recipesRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recipesRecyclerView.adapter = RecipesAdapter(recipeList)
        recipesRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))

        helpButton.setOnClickListener {
            val link = Uri.parse("https://eda.yandex.ru/krasnoyarsk?shippingType=delivery/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }
        return view
    }


}