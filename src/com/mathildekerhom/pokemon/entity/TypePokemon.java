package com.mathildekerhom.pokemon.entity;

import com.tactfactory.harmony.annotation.Column;
import com.tactfactory.harmony.annotation.GeneratedValue;
import com.tactfactory.harmony.annotation.Id;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;

public class TypePokemon {
    @Id
    @Column(type = Type.LONG, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private long id;
    @Column(type = Type.STRING)
	private String name;
    @Column(type = Type.INTEGER)
	private int attaque;
    @Column(type = Type.INTEGER)
	private int attaque_spe;
    @Column(type = Type.INTEGER)
	private int defense;
    @Column(type = Type.INTEGER)
	private int defense_spe;
    @Column(type = Type.INTEGER)
	private int vitesse;
    @Column(type = Type.INTEGER)
	private int pv;
}
