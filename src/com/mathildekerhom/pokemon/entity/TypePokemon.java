package com.mathildekerhom.pokemon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;


import com.tactfactory.harmony.annotation.Column;
import com.tactfactory.harmony.annotation.GeneratedValue;
import com.tactfactory.harmony.annotation.Id;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;

public class TypePokemon  implements Serializable , Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;

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

    /**
     * Default constructor.
     */
    public TypePokemon() {

    }

     /**
     * Get the Id.
     * @return the id
     */
    public long getId() {
         return this.id;
    }
     /**
     * Set the Id.
     * @param value the id to set
     */
    public void setId(final long value) {
         this.id = value;
    }
     /**
     * Get the Name.
     * @return the name
     */
    public String getName() {
         return this.name;
    }
     /**
     * Set the Name.
     * @param value the name to set
     */
    public void setName(final String value) {
         this.name = value;
    }
     /**
     * Get the Attaque.
     * @return the attaque
     */
    public int getAttaque() {
         return this.attaque;
    }
     /**
     * Set the Attaque.
     * @param value the attaque to set
     */
    public void setAttaque(final int value) {
         this.attaque = value;
    }
     /**
     * Get the Attaque_spe.
     * @return the attaque_spe
     */
    public int getAttaque_spe() {
         return this.attaque_spe;
    }
     /**
     * Set the Attaque_spe.
     * @param value the attaque_spe to set
     */
    public void setAttaque_spe(final int value) {
         this.attaque_spe = value;
    }
     /**
     * Get the Defense.
     * @return the defense
     */
    public int getDefense() {
         return this.defense;
    }
     /**
     * Set the Defense.
     * @param value the defense to set
     */
    public void setDefense(final int value) {
         this.defense = value;
    }
     /**
     * Get the Defense_spe.
     * @return the defense_spe
     */
    public int getDefense_spe() {
         return this.defense_spe;
    }
     /**
     * Set the Defense_spe.
     * @param value the defense_spe to set
     */
    public void setDefense_spe(final int value) {
         this.defense_spe = value;
    }
     /**
     * Get the Vitesse.
     * @return the vitesse
     */
    public int getVitesse() {
         return this.vitesse;
    }
     /**
     * Set the Vitesse.
     * @param value the vitesse to set
     */
    public void setVitesse(final int value) {
         this.vitesse = value;
    }
     /**
     * Get the Pv.
     * @return the pv
     */
    public int getPv() {
         return this.pv;
    }
     /**
     * Set the Pv.
     * @param value the pv to set
     */
    public void setPv(final int value) {
         this.pv = value;
    }
    /**
     * This stub of code is regenerated. DO NOT MODIFY.
     * 
     * @param dest Destination parcel
     * @param flags flags
     */
    public void writeToParcelRegen(Parcel dest, int flags) {
        if (this.parcelableParents == null) {
            this.parcelableParents = new ArrayList<Parcelable>();
        }
        if (!this.parcelableParents.contains(this)) {
            this.parcelableParents.add(this);
        }
        dest.writeLong(this.getId());
        if (this.getName() != null) {
            dest.writeInt(1);
            dest.writeString(this.getName());
        } else {
            dest.writeInt(0);
        }
        dest.writeInt(this.getAttaque());
        dest.writeInt(this.getAttaque_spe());
        dest.writeInt(this.getDefense());
        dest.writeInt(this.getDefense_spe());
        dest.writeInt(this.getVitesse());
        dest.writeInt(this.getPv());
    }

    /**
     * Regenerated Parcel Constructor. 
     *
     * This stub of code is regenerated. DO NOT MODIFY THIS METHOD.
     *
     * @param parc The parcel to read from
     */
    public void readFromParcel(Parcel parc) {
        this.setId(parc.readLong());
        int nameBool = parc.readInt();
        if (nameBool == 1) {
            this.setName(parc.readString());
        }
        this.setAttaque(parc.readInt());
        this.setAttaque_spe(parc.readInt());
        this.setDefense(parc.readInt());
        this.setDefense_spe(parc.readInt());
        this.setVitesse(parc.readInt());
        this.setPv(parc.readInt());
    }

    /**
     * Parcel Constructor.
     *
     * @param parc The parcel to read from
     */
    public TypePokemon(Parcel parc) {
        // You can chose not to use harmony's generated parcel.
        // To do this, remove this line.
        this.readFromParcel(parc);

        // You can  implement your own parcel mechanics here.

    }

    /* This method is not regenerated. You can implement your own parcel mechanics here. */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // You can chose not to use harmony's generated parcel.
        // To do this, remove this line.
        this.writeToParcelRegen(dest, flags);
        // You can  implement your own parcel mechanics here.
    }

    /**
     * Use this method to write this entity to a parcel from another entity.
     * (Useful for relations)
     *
     * @param parent The entity being parcelled that need to parcel this one
     * @param dest The destination parcel
     * @param flags The flags
     */
    public synchronized void writeToParcel(List<Parcelable> parents, Parcel dest, int flags) {
        this.parcelableParents = new ArrayList<Parcelable>(parents);
        dest.writeParcelable(this, flags);
        this.parcelableParents = null;
    }

    @Override
    public int describeContents() {
        // This should return 0 
        // or CONTENTS_FILE_DESCRIPTOR if your entity is a FileDescriptor.
        return 0;
    }

    /**
     * Parcelable creator.
     */
    public static final Parcelable.Creator<TypePokemon> CREATOR
        = new Parcelable.Creator<TypePokemon>() {
        public TypePokemon createFromParcel(Parcel in) {
            return new TypePokemon(in);
        }
        
        public TypePokemon[] newArray(int size) {
            return new TypePokemon[size];
        }
    };

}
