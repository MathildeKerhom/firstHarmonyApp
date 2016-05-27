/**************************************************************************
 * TypePokemonProviderUtilsBase.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.provider.utils.base;

import java.util.ArrayList;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;

import android.content.ContentResolver;
import android.content.ContentValues;

import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;


import com.mathildekerhom.pokemon.provider.utils.ProviderUtils;
import com.mathildekerhom.pokemon.criterias.base.CriteriaExpression;
import com.mathildekerhom.pokemon.criterias.base.CriteriaExpression.GroupType;

import com.mathildekerhom.pokemon.entity.TypePokemon;

import com.mathildekerhom.pokemon.provider.TypePokemonProviderAdapter;
import com.mathildekerhom.pokemon.provider.PokemonProvider;
import com.mathildekerhom.pokemon.provider.contract.TypePokemonContract;

/**
 * TypePokemon Provider Utils Base.
 *
 * DO NOT MODIFY THIS CLASS AS IT IS REGENERATED
 *
 * This class is a utility class helpful for complex provider calls.
 * ex : inserting an entity and its relations alltogether, etc.
 */
public abstract class TypePokemonProviderUtilsBase
            extends ProviderUtils<TypePokemon> {
    /**
     * Tag for debug messages.
     */
    public static final String TAG = "TypePokemonProviderUtilBase";

    /**
     * Constructor.
     * @param context Context
     */
    public TypePokemonProviderUtilsBase(android.content.Context context) {
        super(context);
    }

    @Override
    public Uri insert(final TypePokemon item) {
        Uri result = null;
        ArrayList<ContentProviderOperation> operations =
                new ArrayList<ContentProviderOperation>();
        ContentResolver prov = this.getContext().getContentResolver();


        ContentValues itemValues = TypePokemonContract.itemToContentValues(item);
        itemValues.remove(TypePokemonContract.COL_ID);

        operations.add(ContentProviderOperation.newInsert(
                TypePokemonProviderAdapter.TYPEPOKEMON_URI)
                        .withValues(itemValues)
                        .build());


        try {
            ContentProviderResult[] results =
                    prov.applyBatch(PokemonProvider.authority, operations);
            if (results[0] != null) {
                result = results[0].uri;
                item.setId(Long.parseLong(result.getPathSegments().get(1)));
            }
        } catch (RemoteException e) {
            android.util.Log.e(TAG, e.getMessage());
        } catch (OperationApplicationException e) {
            android.util.Log.e(TAG, e.getMessage());
        }

        return result;
    }


    /**
     * Delete from DB.
     * @param item TypePokemon
     * @return number of row affected
     */
    public int delete(final TypePokemon item) {
        int result = -1;
        ContentResolver prov = this.getContext().getContentResolver();

        Uri uri = TypePokemonProviderAdapter.TYPEPOKEMON_URI;
        uri = Uri.withAppendedPath(uri, String.valueOf(item.getId()));

        result = prov.delete(uri,
            null,
            null);

        return result;
    }


    /**
     * Query the DB.
     * @param item The item with its ids set
     * @return TypePokemon
     */
    public TypePokemon query(final TypePokemon item) {
        return this.query(item.getId());
    }

    /**
     * Query the DB.
     *
     * @param id id
     *
     * @return TypePokemon
     */
    public TypePokemon query(final long id) {
        TypePokemon result = null;
        ContentResolver prov = this.getContext().getContentResolver();

        CriteriaExpression crits = new CriteriaExpression(GroupType.AND);
        crits.add(TypePokemonContract.ALIASED_COL_ID,
                    String.valueOf(id));

        android.database.Cursor cursor = prov.query(
            TypePokemonProviderAdapter.TYPEPOKEMON_URI,
            TypePokemonContract.ALIASED_COLS,
            crits.toSQLiteSelection(),
            crits.toSQLiteSelectionArgs(),
            null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = TypePokemonContract.cursorToItem(cursor);

        }
        cursor.close();
        
        return result;
    }

    /**
     * Query the DB to get all entities.
     * @return ArrayList<TypePokemon>
     */
    public ArrayList<TypePokemon> queryAll() {
        ArrayList<TypePokemon> result =
                    new ArrayList<TypePokemon>();
        ContentResolver prov =
                    this.getContext().getContentResolver();

        android.database.Cursor cursor = prov.query(
                TypePokemonProviderAdapter.TYPEPOKEMON_URI,
                TypePokemonContract.ALIASED_COLS,
                null,
                null,
                null);

        result = TypePokemonContract.cursorToItems(cursor);

        cursor.close();

        return result;
    }

    /**
     * Query the DB to get the entities filtered by criteria.
     * @param expression The criteria expression defining the selection and selection args
     * @return ArrayList<TypePokemon>
     */
    public ArrayList<TypePokemon> query(CriteriaExpression expression) {
        ArrayList<TypePokemon> result =
                    new ArrayList<TypePokemon>();
        ContentResolver prov = this.getContext().getContentResolver();

        android.database.Cursor cursor = prov.query(
                TypePokemonProviderAdapter.TYPEPOKEMON_URI,
                TypePokemonContract.ALIASED_COLS,
                expression.toSQLiteSelection(),
                expression.toSQLiteSelectionArgs(),
                null);

        result = TypePokemonContract.cursorToItems(cursor);

        cursor.close();

        return result;
    }

    /**
     * Updates the DB.
     * @param item TypePokemon
     
     * @return number of rows updated
     */
    public int update(final TypePokemon item) {
        int result = -1;
        ArrayList<ContentProviderOperation> operations =
                new ArrayList<ContentProviderOperation>();
        ContentResolver prov = this.getContext().getContentResolver();
        ContentValues itemValues = TypePokemonContract.itemToContentValues(
                item);

        Uri uri = TypePokemonProviderAdapter.TYPEPOKEMON_URI;
        uri = Uri.withAppendedPath(uri, String.valueOf(item.getId()));


        operations.add(ContentProviderOperation.newUpdate(uri)
                .withValues(itemValues)
                .build());



        try {
            ContentProviderResult[] results = prov.applyBatch(PokemonProvider.authority, operations);
            result = results[0].count;
        } catch (RemoteException e) {
            android.util.Log.e(TAG, e.getMessage());
        } catch (OperationApplicationException e) {
            android.util.Log.e(TAG, e.getMessage());
        }

        return result;
    }

    
}
