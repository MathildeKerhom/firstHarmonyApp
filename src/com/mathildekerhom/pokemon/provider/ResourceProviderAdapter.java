/**************************************************************************
 * ResourceProviderAdapter.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.provider;

import com.mathildekerhom.pokemon.provider.base.ResourceProviderAdapterBase;
import com.mathildekerhom.pokemon.provider.base.PokemonProviderBase;

/**
 * ResourceProviderAdapter.
 *
 * A provider adapter is used to separate your provider requests for
 * each entity of your application.
 * You will find here basic methods for database manipulation.
 * Feel free to override any method here.
 */
public class ResourceProviderAdapter
                    extends ResourceProviderAdapterBase {

    /**
     * Constructor.
     * @param ctx context
     */
    public ResourceProviderAdapter(
            final PokemonProviderBase provider) {
        super(provider);
    }
}

