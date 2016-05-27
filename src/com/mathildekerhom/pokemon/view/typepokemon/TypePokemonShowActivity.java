/**************************************************************************
 * TypePokemonShowActivity.java, pokemon Android
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
import com.mathildekerhom.pokemon.view.typepokemon.TypePokemonShowFragment.DeleteCallback;
import android.os.Bundle;

/** TypePokemon show Activity.
 *
 * This only contains a TypePokemonShowFragment.
 *
 * @see android.app.Activity
 */
public class TypePokemonShowActivity 
        extends HarmonyFragmentActivity 
        implements DeleteCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setNavigationBack(true);
    }
    
    @Override
    protected int getContentView() {
        return R.layout.activity_typepokemon_show;
    }

    @Override
    public void onItemDeleted() {
        this.finish();
    }
}
