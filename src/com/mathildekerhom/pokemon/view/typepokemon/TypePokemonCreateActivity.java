/**************************************************************************
 * TypePokemonCreateActivity.java, pokemon Android
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

/** 
 * TypePokemon create Activity.
 *
 * This only contains a TypePokemonCreateFragment.
 *
 * @see android.app.Activity
 */
public class TypePokemonCreateActivity extends HarmonyFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setNavigationBack(true);
    }
    
    @Override
    protected int getContentView() {
        return R.layout.activity_typepokemon_create;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
