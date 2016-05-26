package com.mathildekerhom.pokemon.entity;

import org.joda.time.DateTime;

import com.tactfactory.harmony.annotation.Column;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;
import com.tactfactory.harmony.annotation.Id;
import com.tactfactory.harmony.annotation.OneToOne;

public class Pokemon {
    @Id
    @Column(type = Type.LONG, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private long id;
    @Column(type = Type.STRING)
	private String surnom;
    @Column(type = Type.INTEGER)
    private int niveau;
    @Column(type = Type.DATETIME)
	private DateTime capture;
    @OneToOne()
    @Column()
	private TypePokemon type;
}
