/**************************************************************************
 * TypePokemonUtilsBase.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.test.utils.base;


import junit.framework.Assert;
import com.mathildekerhom.pokemon.entity.TypePokemon;



import com.mathildekerhom.pokemon.test.utils.TestUtils;


public abstract class TypePokemonUtilsBase {

    // If you have enums, you may have to override this method to generate the random enums values
    /**
     * Generate a random entity
     *
     * @return The randomly generated entity
     */
    public static TypePokemon generateRandom(android.content.Context ctx){
        TypePokemon typePokemon = new TypePokemon();

        //TODO : Manage field type : long / long
        typePokemon.setName("name_"+TestUtils.generateRandomString(10));
        typePokemon.setAttaque(TestUtils.generateRandomInt(0,100));
        typePokemon.setAttaque_spe(TestUtils.generateRandomInt(0,100));
        typePokemon.setDefense(TestUtils.generateRandomInt(0,100));
        typePokemon.setDefense_spe(TestUtils.generateRandomInt(0,100));
        typePokemon.setVitesse(TestUtils.generateRandomInt(0,100));
        typePokemon.setPv(TestUtils.generateRandomInt(0,100));

        return typePokemon;
    }

    public static boolean equals(TypePokemon typePokemon1,
            TypePokemon typePokemon2){
        return equals(typePokemon1, typePokemon2, true);
    }
    
    public static boolean equals(TypePokemon typePokemon1,
            TypePokemon typePokemon2,
            boolean checkRecursiveId){
        boolean ret = true;
        Assert.assertNotNull(typePokemon1);
        Assert.assertNotNull(typePokemon2);
        if (typePokemon1!=null && typePokemon2 !=null){
            Assert.assertEquals(typePokemon1.getId(), typePokemon2.getId());
            Assert.assertEquals(typePokemon1.getName(), typePokemon2.getName());
            Assert.assertEquals(typePokemon1.getAttaque(), typePokemon2.getAttaque());
            Assert.assertEquals(typePokemon1.getAttaque_spe(), typePokemon2.getAttaque_spe());
            Assert.assertEquals(typePokemon1.getDefense(), typePokemon2.getDefense());
            Assert.assertEquals(typePokemon1.getDefense_spe(), typePokemon2.getDefense_spe());
            Assert.assertEquals(typePokemon1.getVitesse(), typePokemon2.getVitesse());
            Assert.assertEquals(typePokemon1.getPv(), typePokemon2.getPv());
        }

        return ret;
    }
}

