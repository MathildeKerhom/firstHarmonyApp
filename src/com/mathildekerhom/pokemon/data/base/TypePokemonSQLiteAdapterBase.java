
/**************************************************************************
 * TypePokemonSQLiteAdapterBase.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.data.base;

import java.util.ArrayList;
import android.content.ContentValues;


import android.database.sqlite.SQLiteDatabase;


import com.mathildekerhom.pokemon.data.SQLiteAdapter;
import com.mathildekerhom.pokemon.data.TypePokemonSQLiteAdapter;
import com.mathildekerhom.pokemon.provider.contract.TypePokemonContract;
import com.mathildekerhom.pokemon.entity.TypePokemon;


import com.mathildekerhom.pokemon.PokemonApplication;



/** TypePokemon adapter database abstract class. <br/>
 * <b><i>This class will be overwrited whenever you regenerate the project<br/>
 * with Harmony.<br />
 * You should edit TypePokemonAdapter class instead of this<br/>
 * one or you will lose all your modifications.</i></b>
 */
public abstract class TypePokemonSQLiteAdapterBase
                        extends SQLiteAdapter<TypePokemon> {

    /** TAG for debug purpose. */
    protected static final String TAG = "TypePokemonDBAdapter";


    /**
     * Get the table name used in DB for your TypePokemon entity.
     * @return A String showing the table name
     */
    public String getTableName() {
        return TypePokemonContract.TABLE_NAME;
    }

    /**
     * Get the joined table name used in DB for your TypePokemon entity
     * and its parents.
     * @return A String showing the joined table name
     */
    public String getJoinedTableName() {
        String result = TypePokemonContract.TABLE_NAME;
        return result;
    }

    /**
     * Get the column names from the TypePokemon entity table.
     * @return An array of String representing the columns
     */
    public String[] getCols() {
        return TypePokemonContract.ALIASED_COLS;
    }

    /**
     * Generate Entity Table Schema.
     * @return "SQL query : CREATE TABLE..."
     */
    public static String getSchema() {
        return "CREATE TABLE "
        + TypePokemonContract.TABLE_NAME    + " ("
        
         + TypePokemonContract.COL_ID    + " LONG PRIMARY KEY AUTOINCREMENT,"
         + TypePokemonContract.COL_NAME    + " VARCHAR NOT NULL,"
         + TypePokemonContract.COL_ATTAQUE    + " INTEGER NOT NULL,"
         + TypePokemonContract.COL_ATTAQUE_SPE    + " INTEGER NOT NULL,"
         + TypePokemonContract.COL_DEFENSE    + " INTEGER NOT NULL,"
         + TypePokemonContract.COL_DEFENSE_SPE    + " INTEGER NOT NULL,"
         + TypePokemonContract.COL_VITESSE    + " INTEGER NOT NULL,"
         + TypePokemonContract.COL_PV    + " INTEGER NOT NULL"

        
        + ");"
;
    }

    /**
     * Constructor.
     * @param ctx context
     */
    public TypePokemonSQLiteAdapterBase(final android.content.Context ctx) {
        super(ctx);
    }

    // Converters

    /**
     * Convert TypePokemon entity to Content Values for database.
     * @param item TypePokemon entity object
     * @return ContentValues object
     */
    public ContentValues itemToContentValues(final TypePokemon item) {
        return TypePokemonContract.itemToContentValues(item);
    }

    /**
     * Convert android.database.Cursor of database to TypePokemon entity.
     * @param cursor android.database.Cursor object
     * @return TypePokemon entity
     */
    public TypePokemon cursorToItem(final android.database.Cursor cursor) {
        return TypePokemonContract.cursorToItem(cursor);
    }

    /**
     * Convert android.database.Cursor of database to TypePokemon entity.
     * @param cursor android.database.Cursor object
     * @param result TypePokemon entity
     */
    public void cursorToItem(final android.database.Cursor cursor, final TypePokemon result) {
        TypePokemonContract.cursorToItem(cursor, result);
    }

    //// CRUD Entity ////
    /**
     * Find & read TypePokemon by id in database.
     *
     * @param id Identify of TypePokemon
     * @return TypePokemon entity
     */
    public TypePokemon getByID(final long id) {
        final android.database.Cursor cursor = this.getSingleCursor(id);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
        }

        final TypePokemon result = this.cursorToItem(cursor);
        cursor.close();

        return result;
    }


    /**
     * Read All TypePokemons entities.
     *
     * @return List of TypePokemon entities
     */
    public ArrayList<TypePokemon> getAll() {
        final android.database.Cursor cursor = this.getAllCursor();
        final ArrayList<TypePokemon> result = this.cursorToItems(cursor);
        cursor.close();

        return result;
    }



    /**
     * Insert a TypePokemon entity into database.
     *
     * @param item The TypePokemon entity to persist
     * @return Id of the TypePokemon entity
     */
    public long insert(final TypePokemon item) {
        if (PokemonApplication.DEBUG) {
            android.util.Log.d(TAG, "Insert DB(" + TypePokemonContract.TABLE_NAME + ")");
        }

        final ContentValues values =
                TypePokemonContract.itemToContentValues(item);
        values.remove(TypePokemonContract.COL_ID);
        int insertResult;
        if (values.size() != 0) {
            insertResult = (int) this.insert(
                    null,
                    values);
        } else {
            insertResult = (int) this.insert(
                    TypePokemonContract.COL_ID,
                    values);
        }
        item.setId(insertResult);
        return insertResult;
    }

    /**
     * Either insert or update a TypePokemon entity into database whether.
     * it already exists or not.
     *
     * @param item The TypePokemon entity to persist
     * @return 1 if everything went well, 0 otherwise
     */
    public int insertOrUpdate(final TypePokemon item) {
        int result = 0;
        if (this.getByID(item.getId()) != null) {
            // Item already exists => update it
            result = this.update(item);
        } else {
            // Item doesn't exist => create it
            final long id = this.insert(item);
            if (id != 0) {
                result = 1;
            }
        }

        return result;
    }

    /**
     * Update a TypePokemon entity into database.
     *
     * @param item The TypePokemon entity to persist
     * @return count of updated entities
     */
    public int update(final TypePokemon item) {
        if (PokemonApplication.DEBUG) {
            android.util.Log.d(TAG, "Update DB(" + TypePokemonContract.TABLE_NAME + ")");
        }

        final ContentValues values =
                TypePokemonContract.itemToContentValues(item);
        final String whereClause =
                 TypePokemonContract.COL_ID
                 + " = ?";
        final String[] whereArgs =
                new String[] {String.valueOf(item.getId()) };

        return this.update(
                values,
                whereClause,
                whereArgs);
    }


    /**
     * Delete a TypePokemon entity of database.
     *
     * @param id id
     * @return count of updated entities
     */
    public int remove(final long id) {
        if (PokemonApplication.DEBUG) {
            android.util.Log.d(
                TAG,
                "Delete DB("
                    + TypePokemonContract.TABLE_NAME
                    + ")"
                    + " id : "+ id);
        }

        final String whereClause =
                TypePokemonContract.COL_ID
                + " = ?";
        final String[] whereArgs = new String[] {
                    String.valueOf(id)};

        return this.delete(
                whereClause,
                whereArgs);
    }

    /**
     * Deletes the given entity.
     * @param typePokemon The entity to delete
     * @return count of updated entities
     */
    public int delete(final TypePokemon typePokemon) {
        return this.remove(typePokemon.getId());
    }

    /**
     *  Internal android.database.Cursor.
     * @param id id
     *  @return A android.database.Cursor pointing to the TypePokemon corresponding
     *        to the given id.
     */
    protected android.database.Cursor getSingleCursor(final long id) {
        if (PokemonApplication.DEBUG) {
            android.util.Log.d(TAG, "Get entities id : " + id);
        }

        final String whereClause =
                TypePokemonContract.ALIASED_COL_ID
                + " = ?";
        final String[] whereArgs = new String[] {String.valueOf(id)};

        return this.query(
                TypePokemonContract.ALIASED_COLS,
                whereClause,
                whereArgs,
                null,
                null,
                null);
    }


    /**
     * Query the DB to find a TypePokemon entity.
     *
     * @param id The id of the entity to get from the DB
     *
     * @return The cursor pointing to the query's result
     */
    public android.database.Cursor query(final long id) {

        String selection = TypePokemonContract.ALIASED_COL_ID + " = ?";
        

        String[] selectionArgs = new String[1];
        selectionArgs[0] = String.valueOf(id);

        return this.query(
                TypePokemonContract.ALIASED_COLS,
                selection,
                selectionArgs,
                null,
                null,
                null);
    }




}

