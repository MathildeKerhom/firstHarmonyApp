/**************************************************************************
 * TypePokemonListAdapter.java, pokemon Android
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

import android.database.Cursor;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mathildekerhom.pokemon.entity.TypePokemon;
import com.mathildekerhom.pokemon.harmony.view.HarmonyCursorAdapter;
import com.mathildekerhom.pokemon.harmony.view.HarmonyViewHolder;
import com.mathildekerhom.pokemon.provider.contract.TypePokemonContract;

/**
 * List adapter for TypePokemon entity.
 */
public class TypePokemonListAdapter extends HarmonyCursorAdapter<TypePokemon> {
    
    /**
     * Constructor.
     * @param ctx context
     */
    public TypePokemonListAdapter(android.content.Context context) {
        super(context);
    }
    
    /**
     * Constructor.
     * @param ctx context
     * @param cursor cursor
     */
    public TypePokemonListAdapter(android.content.Context context, Cursor cursor) {
        super(context, cursor);
    }
    
    @Override
    protected TypePokemon cursorToItem(Cursor cursor) {
        return TypePokemonContract.cursorToItem(cursor);
    }

    @Override
    protected String getColId() {
        return TypePokemonContract.COL_ID;
    }
    
    @Override
    protected HarmonyViewHolder<TypePokemon> getNewViewHolder(
            android.content.Context context,
            Cursor cursor, ViewGroup group) {
        return new ViewHolder(context, group);
    }
    
    /** Holder row. */
    private class ViewHolder extends HarmonyViewHolder<TypePokemon> {
    
        /**
         * Constructor.
         *
         * @param context The context
         * @param parent Optional view to be the parent of the generated hierarchy
         */
        public ViewHolder(android.content.Context context, ViewGroup parent) {
            super(context, parent, R.layout.row_typepokemon);
        }

        /**
         * Populate row with a {@link TypePokemon}.
         *
         * @param model {@link TypePokemon} data
         */
        public void populate(final TypePokemon model) {
            TextView nameView = (TextView) this.getView().findViewById(
                    R.id.row_typepokemon_name);
                    
            TextView attaqueView = (TextView) this.getView().findViewById(
                    R.id.row_typepokemon_attaque);
                    
            TextView attaque_speView = (TextView) this.getView().findViewById(
                    R.id.row_typepokemon_attaque_spe);
                    
            TextView defenseView = (TextView) this.getView().findViewById(
                    R.id.row_typepokemon_defense);
                    
            TextView defense_speView = (TextView) this.getView().findViewById(
                    R.id.row_typepokemon_defense_spe);
                    
            TextView vitesseView = (TextView) this.getView().findViewById(
                    R.id.row_typepokemon_vitesse);
                    
            TextView pvView = (TextView) this.getView().findViewById(
                    R.id.row_typepokemon_pv);
                    

            if (model.getName() != null) {
                nameView.setText(model.getName());
            }
            attaqueView.setText(String.valueOf(model.getAttaque()));
            attaque_speView.setText(String.valueOf(model.getAttaque_spe()));
            defenseView.setText(String.valueOf(model.getDefense()));
            defense_speView.setText(String.valueOf(model.getDefense_spe()));
            vitesseView.setText(String.valueOf(model.getVitesse()));
            pvView.setText(String.valueOf(model.getPv()));
        }
    }
}
