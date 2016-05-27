/**************************************************************************
 * TypePokemonTestProviderBase.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.test.base;

import android.test.suitebuilder.annotation.SmallTest;

import com.mathildekerhom.pokemon.provider.TypePokemonProviderAdapter;
import com.mathildekerhom.pokemon.provider.utils.TypePokemonProviderUtils;
import com.mathildekerhom.pokemon.provider.contract.TypePokemonContract;

import com.mathildekerhom.pokemon.data.TypePokemonSQLiteAdapter;

import com.mathildekerhom.pokemon.entity.TypePokemon;


import java.util.ArrayList;
import com.mathildekerhom.pokemon.test.utils.*;


import android.content.ContentResolver;
import android.content.ContentValues;


import android.net.Uri;

import junit.framework.Assert;

/** TypePokemon database test abstract class <br/>
 * <b><i>This class will be overwrited whenever you regenerate the project with Harmony.
 * You should edit TypePokemonTestDB class instead of this one or you will lose all your modifications.</i></b>
 */
public abstract class TypePokemonTestProviderBase extends TestDBBase {
    protected android.content.Context ctx;

    protected TypePokemonSQLiteAdapter adapter;

    protected TypePokemon entity;
    protected ContentResolver provider;
    protected TypePokemonProviderUtils providerUtils;

    protected ArrayList<TypePokemon> entities;

    protected int nbEntities = 0;
    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        this.ctx = this.getContext();

        this.adapter = new TypePokemonSQLiteAdapter(this.ctx);

        this.provider = this.getContext().getContentResolver();
        this.providerUtils = new TypePokemonProviderUtils(this.getContext());
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /********** Direct Provider calls. *******/

    /** Test case Create Entity */
    @SmallTest
    public void testCreate() {
        Uri result = null;
        if (this.entity != null) {
            TypePokemon typePokemon = TypePokemonUtils.generateRandom(this.ctx);

            try {
                ContentValues values = TypePokemonContract.itemToContentValues(typePokemon);
                values.remove(TypePokemonContract.COL_ID);
                result = this.provider.insert(TypePokemonProviderAdapter.TYPEPOKEMON_URI, values);

            } catch (Exception e) {
                e.printStackTrace();
            }

            Assert.assertNotNull(result);
            Assert.assertTrue(Long.parseLong(result.getPathSegments().get(1)) > 0);        
            
        }
    }

    /** Test case Read Entity */
    @SmallTest
    public void testRead() {
        TypePokemon result = null;

        if (this.entity != null) {
            try {
                android.database.Cursor c = this.provider.query(Uri.parse(
                        TypePokemonProviderAdapter.TYPEPOKEMON_URI
                                + "/" 
                                + this.entity.getId()),
                        this.adapter.getCols(),
                        null,
                        null,
                        null);
                c.moveToFirst();
                result = TypePokemonContract.cursorToItem(c);
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            TypePokemonUtils.equals(this.entity, result);
        }
    }

    /** Test case ReadAll Entity */
    @SmallTest
    public void testReadAll() {
        ArrayList<TypePokemon> result = null;
        try {
            android.database.Cursor c = this.provider.query(TypePokemonProviderAdapter.TYPEPOKEMON_URI, this.adapter.getCols(), null, null, null);
            result = TypePokemonContract.cursorToItems(c);
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(result);
        if (result != null) {
            Assert.assertEquals(result.size(), this.nbEntities);
        }
    }

    /** Test case Update Entity */
    @SmallTest
    public void testUpdate() {
        int result = -1;
        if (this.entity != null) {
            TypePokemon typePokemon = TypePokemonUtils.generateRandom(this.ctx);

            try {
                typePokemon.setId(this.entity.getId());

                ContentValues values = TypePokemonContract.itemToContentValues(typePokemon);
                result = this.provider.update(
                    Uri.parse(TypePokemonProviderAdapter.TYPEPOKEMON_URI
                        + "/"
                        + typePokemon.getId()),
                    values,
                    null,
                    null);

            } catch (Exception e) {
                e.printStackTrace();
            }

            Assert.assertTrue(result > 0);
        }
    }

    /** Test case UpdateAll Entity */
    @SmallTest
    public void testUpdateAll() {
        int result = -1;
        if (this.entities != null) {
            if (this.entities.size() > 0) {
                TypePokemon typePokemon = TypePokemonUtils.generateRandom(this.ctx);
    
                try {
                    ContentValues values = TypePokemonContract.itemToContentValues(typePokemon);
                    values.remove(TypePokemonContract.COL_ID);
    
                    result = this.provider.update(TypePokemonProviderAdapter.TYPEPOKEMON_URI, values, null, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    
                Assert.assertEquals(result, this.nbEntities);
            }
        }
    }

    /** Test case Delete Entity */
    @SmallTest
    public void testDelete() {
        int result = -1;
        if (this.entity != null) {
            try {
                result = this.provider.delete(
                        Uri.parse(TypePokemonProviderAdapter.TYPEPOKEMON_URI
                            + "/" 
                            + this.entity.getId()),
                        null,
                        null);

            } catch (Exception e) {
                e.printStackTrace();
            }
            Assert.assertTrue(result >= 0);
        }

    }

    /** Test case DeleteAll Entity */
    @SmallTest
    public void testDeleteAll() {
        int result = -1;
        if (this.entities != null) {
            if (this.entities.size() > 0) {
    
                try {
                    result = this.provider.delete(TypePokemonProviderAdapter.TYPEPOKEMON_URI, null, null);
    
                } catch (Exception e) {
                    e.printStackTrace();
                }
    
                Assert.assertEquals(result, this.nbEntities);
            }
        }
    }

    /****** Provider Utils calls ********/

    /** Test case Read Entity by provider utils. */
    @SmallTest
    public void testUtilsRead() {
        TypePokemon result = null;

        if (this.entity != null) {
            result = this.providerUtils.query(this.entity);

            TypePokemonUtils.equals(this.entity, result);
        }
    }

    /** Test case ReadAll Entity by provider utils. */
    @SmallTest
    public void testUtilsReadAll() {
        ArrayList<TypePokemon> result = null;
        result = this.providerUtils.queryAll();

        Assert.assertNotNull(result);
        if (result != null) {
            Assert.assertEquals(result.size(), this.nbEntities);
        }
    }

    /** Test case Update Entity by provider utils. */
    @SmallTest
    public void testUtilsUpdate() {
        int result = -1;
        if (this.entity != null) {
            TypePokemon typePokemon = TypePokemonUtils.generateRandom(this.ctx);

            typePokemon.setId(this.entity.getId());
            result = this.providerUtils.update(typePokemon);

            Assert.assertTrue(result > 0);
        }
    }


    /** Test case Delete Entity by provider utils. */
    @SmallTest
    public void testUtilsDelete() {
        int result = -1;
        if (this.entity != null) {
            result = this.providerUtils.delete(this.entity);
            Assert.assertTrue(result >= 0);
        }

    }
}
