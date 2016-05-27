/**************************************************************************
 * TypePokemonProviderAdapterBase.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.provider.base;

import android.content.ContentUris;
import android.content.ContentValues;


import com.google.common.collect.ObjectArrays;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;



import com.mathildekerhom.pokemon.entity.TypePokemon;
import com.mathildekerhom.pokemon.provider.ProviderAdapter;
import com.mathildekerhom.pokemon.provider.PokemonProvider;
import com.mathildekerhom.pokemon.provider.contract.TypePokemonContract;
import com.mathildekerhom.pokemon.data.TypePokemonSQLiteAdapter;

/**
 * TypePokemonProviderAdapterBase.
 */
public abstract class TypePokemonProviderAdapterBase
                extends ProviderAdapter<TypePokemon> {

    /** TAG for debug purpose. */
    protected static final String TAG = "TypePokemonProviderAdapter";

    /** TYPEPOKEMON_URI. */
    public      static Uri TYPEPOKEMON_URI;

    /** typePokemon type. */
    protected static final String typePokemonType =
            "typepokemon";

    /** TYPEPOKEMON_ALL. */
    protected static final int TYPEPOKEMON_ALL =
            1995978777;
    /** TYPEPOKEMON_ONE. */
    protected static final int TYPEPOKEMON_ONE =
            1995978778;


    /**
     * Static constructor.
     */
    static {
        TYPEPOKEMON_URI =
                PokemonProvider.generateUri(
                        typePokemonType);
        PokemonProvider.getUriMatcher().addURI(
                PokemonProvider.authority,
                typePokemonType,
                TYPEPOKEMON_ALL);
        PokemonProvider.getUriMatcher().addURI(
                PokemonProvider.authority,
                typePokemonType + "/*",
                TYPEPOKEMON_ONE);
    }

    /**
     * Constructor.
     * @param ctx context
     * @param db database
     */
    public TypePokemonProviderAdapterBase(
            PokemonProviderBase provider) {
        super(
            provider,
            new TypePokemonSQLiteAdapter(provider.getContext()));

        this.uriIds.add(TYPEPOKEMON_ALL);
        this.uriIds.add(TYPEPOKEMON_ONE);
    }

    @Override
    public String getType(final Uri uri) {
        String result;
        final String single =
                "vnc.android.cursor.item/"
                    + PokemonProvider.authority + ".";
        final String collection =
                "vnc.android.cursor.collection/"
                    + PokemonProvider.authority + ".";

        int matchedUri = PokemonProviderBase
                .getUriMatcher().match(uri);

        switch (matchedUri) {
            case TYPEPOKEMON_ALL:
                result = collection + "typepokemon";
                break;
            case TYPEPOKEMON_ONE:
                result = single + "typepokemon";
                break;
            default:
                result = null;
                break;
        }

        return result;
    }

    @Override
    public int delete(
            final Uri uri,
            String selection,
            String[] selectionArgs) {
        int matchedUri = PokemonProviderBase
                    .getUriMatcher().match(uri);
        int result = -1;
        switch (matchedUri) {
            case TYPEPOKEMON_ONE:
                String id = uri.getPathSegments().get(1);
                selection = TypePokemonContract.COL_ID
                        + " = ?";
                selectionArgs = new String[1];
                selectionArgs[0] = id;
                result = this.adapter.delete(
                        selection,
                        selectionArgs);
                break;
            case TYPEPOKEMON_ALL:
                result = this.adapter.delete(
                            selection,
                            selectionArgs);
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }

    @Override
    public Uri insert(final Uri uri, final ContentValues values) {
        int matchedUri = PokemonProviderBase
                .getUriMatcher().match(uri);
                Uri result = null;
        int id = 0;
        switch (matchedUri) {
            case TYPEPOKEMON_ALL:
                if (values.size() > 0) {
                    id = (int) this.adapter.insert(null, values);
                } else {
                    id = (int) this.adapter.insert(TypePokemonContract.COL_ID, values);
                }
                if (id > 0) {
                    result = Uri.withAppendedPath(
                            TYPEPOKEMON_URI,
                            String.valueOf(id));
                }
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    @Override
    public android.database.Cursor query(final Uri uri,
                        String[] projection,
                        String selection,
                        String[] selectionArgs,
                        final String sortOrder) {

        int matchedUri = PokemonProviderBase.getUriMatcher()
                .match(uri);
        android.database.Cursor result = null;

        switch (matchedUri) {

            case TYPEPOKEMON_ALL:
                result = this.adapter.query(
                            projection,
                            selection,
                            selectionArgs,
                            null,
                            null,
                            sortOrder);
                break;
            case TYPEPOKEMON_ONE:
                result = this.queryById(uri.getPathSegments().get(1));
                break;

            default:
                result = null;
                break;
        }

        return result;
    }

    @Override
    public int update(
            final Uri uri,
            final ContentValues values,
            String selection,
            String[] selectionArgs) {

        
        int matchedUri = PokemonProviderBase.getUriMatcher()
                .match(uri);
        int result = -1;
        switch (matchedUri) {
            case TYPEPOKEMON_ONE:
                selectionArgs = new String[1];
                selection = TypePokemonContract.COL_ID + " = ?";
                selectionArgs[0] = uri.getPathSegments().get(1);
                result = this.adapter.update(
                        values,
                        selection,
                        selectionArgs);
                break;
            case TYPEPOKEMON_ALL:
                result = this.adapter.update(
                            values,
                            selection,
                            selectionArgs);
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }



    /**
     * Get the entity URI.
     * @return The URI
     */
    @Override
    public Uri getUri() {
        return TYPEPOKEMON_URI;
    }

    /**
     * Query by ID.
     *
     * @param id The id of the entity to retrieve
     * @return The cursor
     */
    private android.database.Cursor queryById(String id) {
        android.database.Cursor result = null;
        String selection = TypePokemonContract.ALIASED_COL_ID
                        + " = ?";

        String[] selectionArgs = new String[1];
        selectionArgs[0] = id;
        
        

        result = this.adapter.query(
                    TypePokemonContract.ALIASED_COLS,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null);
        return result;
    }
}

