/**************************************************************************
 * TypePokemonEditActivity.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.view.typepokemon;

import com.mathildekerhom.pokemon.R;

import com.mathildekerhom.pokemon.harmony.view.HarmonyFragmentActivity;

import android.os.Bundle;

/** TypePokemon edit Activity.
 *
 * This only contains a TypePokemonEditFragment.
 *
 * @see android.app.Activity
 */
public class TypePokemonEditActivity extends HarmonyFragmentActivity {

    @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setNavigationBack(true);
    }
    
    @Override
    protected int getContentView() {
        return R.layout.activity_typepokemon_edit;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
