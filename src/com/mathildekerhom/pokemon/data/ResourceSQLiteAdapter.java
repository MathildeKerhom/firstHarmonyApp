/**************************************************************************
 * ResourceSQLiteAdapter.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.data;

import com.mathildekerhom.pokemon.data.base.ResourceSQLiteAdapterBase;


/**
 *  Resource adapter database class.
 * This class will help you access your database to do any basic operation you
 * need.
 * Feel free to modify it, override, add more methods etc.
 */
public class ResourceSQLiteAdapter extends ResourceSQLiteAdapterBase {

    /**
     * Constructor.
     * @param ctx context
     */
    public ResourceSQLiteAdapter(final android.content.Context ctx) {
        super(ctx);
    }
}
