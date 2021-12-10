package com.og.examexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_CHOOSEN_IMAGE = "image"

class DishMenuFragment : Fragment() {

    lateinit var dishImageView: ImageView
    lateinit var menuChooserButton: Button

    private val dishImageList: List<Int> = listOf(
        R.drawable.baked_chiken,
        R.drawable.pasta_boloneze,
        R.drawable.red_fried_fish,
        R.drawable.salad_with_tuna,
        R.drawable.uzbekskij_plov,
    )

    private var lastChosenImageRes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dish_menu, container, false)

        dishImageView = view.findViewById(R.id.dish_image_view)
        menuChooserButton = view.findViewById(R.id.menu_chooser_button)

        if (savedInstanceState != null)
            dishImageView.setImageResource(savedInstanceState.getInt(LAST_CHOOSEN_IMAGE))

        menuChooserButton.setOnClickListener {
            lastChosenImageRes = dishImageList.random()
            dishImageView.setImageResource(lastChosenImageRes)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_CHOOSEN_IMAGE, lastChosenImageRes)
    }

}