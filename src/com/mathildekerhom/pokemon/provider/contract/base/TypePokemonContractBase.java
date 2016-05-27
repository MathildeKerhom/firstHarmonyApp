/**************************************************************************
 * TypePokemonContractBase.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.provider.contract.base;

import android.content.ContentValues;


import java.util.ArrayList;

import com.mathildekerhom.pokemon.entity.TypePokemon;



import com.mathildekerhom.pokemon.provider.contract.TypePokemonContract;

/** Pokemon contract base.
 *
 * This class is regenerated. DO NOT MODIFY.
 */
public abstract class TypePokemonContractBase {


        /** id. */
    public static final String COL_ID =
            "id";
    /** Alias. */
    public static final String ALIASED_COL_ID =
            TypePokemonContract.TABLE_NAME + "." + COL_ID;

    /** name. */
    public static final String COL_NAME =
            "name";
    /** Alias. */
    public static final String ALIASED_COL_NAME =
            TypePokemonContract.TABLE_NAME + "." + COL_NAME;

    /** attaque. */
    public static final String COL_ATTAQUE =
            "attaque";
    /** Alias. */
    public static final String ALIASED_COL_ATTAQUE =
            TypePokemonContract.TABLE_NAME + "." + COL_ATTAQUE;

    /** attaque_spe. */
    public static final String COL_ATTAQUE_SPE =
            "attaque_spe";
    /** Alias. */
    public static final String ALIASED_COL_ATTAQUE_SPE =
            TypePokemonContract.TABLE_NAME + "." + COL_ATTAQUE_SPE;

    /** defense. */
    public static final String COL_DEFENSE =
            "defense";
    /** Alias. */
    public static final String ALIASED_COL_DEFENSE =
            TypePokemonContract.TABLE_NAME + "." + COL_DEFENSE;

    /** defense_spe. */
    public static final String COL_DEFENSE_SPE =
            "defense_spe";
    /** Alias. */
    public static final String ALIASED_COL_DEFENSE_SPE =
            TypePokemonContract.TABLE_NAME + "." + COL_DEFENSE_SPE;

    /** vitesse. */
    public static final String COL_VITESSE =
            "vitesse";
    /** Alias. */
    public static final String ALIASED_COL_VITESSE =
            TypePokemonContract.TABLE_NAME + "." + COL_VITESSE;

    /** pv. */
    public static final String COL_PV =
            "pv";
    /** Alias. */
    public static final String ALIASED_COL_PV =
            TypePokemonContract.TABLE_NAME + "." + COL_PV;




    /** Constant for parcelisation/serialization. */
    public static final String PARCEL = "TypePokemon";
    /** Table name of SQLite database. */
    public static final String TABLE_NAME = "TypePokemon";
    /** Global Fields. */
    public static final String[] COLS = new String[] {

        
        TypePokemonContract.COL_ID,
        
        TypePokemonContract.COL_NAME,
        
        TypePokemonContract.COL_ATTAQUE,
        
        TypePokemonContract.COL_ATTAQUE_SPE,
        
        TypePokemonContract.COL_DEFENSE,
        
        TypePokemonContract.COL_DEFENSE_SPE,
        
        TypePokemonContract.COL_VITESSE,
        
        TypePokemonContract.COL_PV
    };

    /** Global Fields. */
    public static final String[] ALIASED_COLS = new String[] {
        
        TypePokemonContract.ALIASED_COL_ID,
        
        TypePokemonContract.ALIASED_COL_NAME,
        
        TypePokemonContract.ALIASED_COL_ATTAQUE,
        
        TypePokemonContract.ALIASED_COL_ATTAQUE_SPE,
        
        TypePokemonContract.ALIASED_COL_DEFENSE,
        
        TypePokemonContract.ALIASED_COL_DEFENSE_SPE,
        
        TypePokemonContract.ALIASED_COL_VITESSE,
        
        TypePokemonContract.ALIASED_COL_PV
    };


    /**
     * Converts a TypePokemon into a content values.
     *
     * @param item The TypePokemon to convert
     *
     * @return The content values
     */
    public static ContentValues itemToContentValues(final TypePokemon item) {
        final ContentValues result = new ContentValues();

             result.put(TypePokemonContract.COL_ID,
                String.valueOf(item.getId()));

             if (item.getName() != null) {
                result.put(TypePokemonContract.COL_NAME,
                    item.getName());
            }

             result.put(TypePokemonContract.COL_ATTAQUE,
                String.valueOf(item.getAttaque()));

             result.put(TypePokemonContract.COL_ATTAQUE_SPE,
                String.valueOf(item.getAttaque_spe()));

             result.put(TypePokemonContract.COL_DEFENSE,
                String.valueOf(item.getDefense()));

             result.put(TypePokemonContract.COL_DEFENSE_SPE,
                String.valueOf(item.getDefense_spe()));

             result.put(TypePokemonContract.COL_VITESSE,
                String.valueOf(item.getVitesse()));

             result.put(TypePokemonContract.COL_PV,
                String.valueOf(item.getPv()));


        return result;
    }

    /**
     * Converts a Cursor into a TypePokemon.
     *
     * @param cursor The cursor to convert
     *
     * @return The extracted TypePokemon
     */
    public static TypePokemon cursorToItem(final android.database.Cursor cursor) {
        TypePokemon result = new TypePokemon();
        TypePokemonContract.cursorToItem(cursor, result);
        return result;
    }

    /**
     * Convert Cursor of database to TypePokemon entity.
     * @param cursor Cursor object
     * @param result TypePokemon entity
     */
    public static void cursorToItem(final android.database.Cursor cursor, final TypePokemon result) {
        if (cursor.getCount() != 0) {
            int index;

            index = cursor.getColumnIndex(TypePokemonContract.COL_ID);

            if (index > -1) {
                result.setId(cursor.getLong(index));
            }
            index = cursor.getColumnIndex(TypePokemonContract.COL_NAME);

            if (index > -1) {
                result.setName(cursor.getString(index));
            }
            index = cursor.getColumnIndex(TypePokemonContract.COL_ATTAQUE);

            if (index > -1) {
                result.setAttaque(cursor.getInt(index));
            }
            index = cursor.getColumnIndex(TypePokemonContract.COL_ATTAQUE_SPE);

            if (index > -1) {
                result.setAttaque_spe(cursor.getInt(index));
            }
            index = cursor.getColumnIndex(TypePokemonContract.COL_DEFENSE);

            if (index > -1) {
                result.setDefense(cursor.getInt(index));
            }
            index = cursor.getColumnIndex(TypePokemonContract.COL_DEFENSE_SPE);

            if (index > -1) {
                result.setDefense_spe(cursor.getInt(index));
            }
            index = cursor.getColumnIndex(TypePokemonContract.COL_VITESSE);

            if (index > -1) {
                result.setVitesse(cursor.getInt(index));
            }
            index = cursor.getColumnIndex(TypePokemonContract.COL_PV);

            if (index > -1) {
                result.setPv(cursor.getInt(index));
            }

        }
    }

    /**
     * Convert Cursor of database to Array of TypePokemon entity.
     * @param cursor Cursor object
     * @return Array of TypePokemon entity
     */
    public static ArrayList<TypePokemon> cursorToItems(final android.database.Cursor cursor) {
        final ArrayList<TypePokemon> result = new ArrayList<TypePokemon>(cursor.getCount());

        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

            TypePokemon item;
            do {
                item = TypePokemonContract.cursorToItem(cursor);
                result.add(item);
            } while (cursor.moveToNext());
        }

        return result;
    }
}
