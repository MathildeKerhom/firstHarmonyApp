/**************************************************************************
 * EntityResourceBase.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/

package com.mathildekerhom.pokemon.entity.base;

import com.mathildekerhom.pokemon.entity.base.Resource;

public class EntityResourceBase implements Resource {

    protected String path;

    private int id;


    @Override
    public int getId() {
         return this.id;
    }

    @Override
    public void setId(final int value) {
         this.id = value;
    }


    @Override
    public String getPath() {
         return this.path;
    }

    @Override
    public void setPath(final String value) {
         this.path = value;
    }

}