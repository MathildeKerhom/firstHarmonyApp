/**************************************************************************
 * ProviderAdapter.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.provider;

import com.mathildekerhom.pokemon.provider.base.ProviderAdapterBase;
import com.mathildekerhom.pokemon.provider.base.PokemonProviderBase;
import com.mathildekerhom.pokemon.data.base.SQLiteAdapterBase;

/**
 * ProviderAdapter<T>. 
 *
 * Feel free to add your custom generic methods here.
 *
 * @param <T> must extends Serializable
 */
public abstract class ProviderAdapter<T> extends ProviderAdapterBase<T> {

    /**
     * Provider Adapter Base constructor.
     *
     * @param context The context.
     */
    public ProviderAdapter(
                final PokemonProviderBase provider,
                final SQLiteAdapterBase<T> adapter) {
        super(provider, adapter);
    }
}
