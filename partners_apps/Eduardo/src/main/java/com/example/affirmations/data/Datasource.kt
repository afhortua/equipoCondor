package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class Datasource() {

    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.PointOfInterest1, R.drawable.descarga__1_),
            Affirmation(R.string.PointOfInterest2, R.drawable.descarga),
            Affirmation(R.string.PointOfInterest3, R.drawable.descarga__2_),
            Affirmation(R.string.PointOfInterest4, R.drawable.descarga__4_),
            Affirmation(R.string.PointOfInterest5, R.drawable.images)

        )
    }
}
