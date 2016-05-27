/**************************************************************************
 * TypePokemonShowFragment.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.view.typepokemon;


import android.content.Intent;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mathildekerhom.pokemon.R;
import com.mathildekerhom.pokemon.entity.TypePokemon;
import com.mathildekerhom.pokemon.harmony.view.DeleteDialog;
import com.mathildekerhom.pokemon.harmony.view.HarmonyFragment;
import com.mathildekerhom.pokemon.harmony.view.MultiLoader;
import com.mathildekerhom.pokemon.harmony.view.MultiLoader.UriLoadedCallback;
import com.mathildekerhom.pokemon.menu.CrudDeleteMenuWrapper.CrudDeleteMenuInterface;
import com.mathildekerhom.pokemon.menu.CrudEditMenuWrapper.CrudEditMenuInterface;
import com.mathildekerhom.pokemon.provider.utils.TypePokemonProviderUtils;
import com.mathildekerhom.pokemon.provider.TypePokemonProviderAdapter;
import com.mathildekerhom.pokemon.provider.contract.TypePokemonContract;

/** TypePokemon show fragment.
 *
 * This fragment gives you an interface to show a TypePokemon.
 * 
 * @see android.app.Fragment
 */
public class TypePokemonShowFragment
        extends HarmonyFragment
        implements CrudDeleteMenuInterface,
                DeleteDialog.DeleteDialogCallback,
                CrudEditMenuInterface {
    /** Model data. */
    protected TypePokemon model;
    /** DeleteCallback. */
    protected DeleteCallback deleteCallback;

    /* This entity's fields views */
    /** name View. */
    protected TextView nameView;
    /** attaque View. */
    protected TextView attaqueView;
    /** attaque_spe View. */
    protected TextView attaque_speView;
    /** defense View. */
    protected TextView defenseView;
    /** defense_spe View. */
    protected TextView defense_speView;
    /** vitesse View. */
    protected TextView vitesseView;
    /** pv View. */
    protected TextView pvView;
    /** Data layout. */
    protected RelativeLayout dataLayout;
    /** Text view for no TypePokemon. */
    protected TextView emptyText;


    /** Initialize view of curr.fields.
     *
     * @param view The layout inflating
     */
    protected void initializeComponent(final View view) {
        this.nameView =
            (TextView) view.findViewById(
                    R.id.typepokemon_name);
        this.attaqueView =
            (TextView) view.findViewById(
                    R.id.typepokemon_attaque);
        this.attaque_speView =
            (TextView) view.findViewById(
                    R.id.typepokemon_attaque_spe);
        this.defenseView =
            (TextView) view.findViewById(
                    R.id.typepokemon_defense);
        this.defense_speView =
            (TextView) view.findViewById(
                    R.id.typepokemon_defense_spe);
        this.vitesseView =
            (TextView) view.findViewById(
                    R.id.typepokemon_vitesse);
        this.pvView =
            (TextView) view.findViewById(
                    R.id.typepokemon_pv);

        this.dataLayout =
                (RelativeLayout) view.findViewById(
                        R.id.typepokemon_data_layout);
        this.emptyText =
                (TextView) view.findViewById(
                        R.id.typepokemon_empty);
    }

    /** Load data from model to fields view. */
    public void loadData() {
        if (this.model != null) {

            this.dataLayout.setVisibility(View.VISIBLE);
            this.emptyText.setVisibility(View.GONE);


        if (this.model.getName() != null) {
            this.nameView.setText(this.model.getName());
        }
        this.attaqueView.setText(String.valueOf(this.model.getAttaque()));
        this.attaque_speView.setText(String.valueOf(this.model.getAttaque_spe()));
        this.defenseView.setText(String.valueOf(this.model.getDefense()));
        this.defense_speView.setText(String.valueOf(this.model.getDefense_spe()));
        this.vitesseView.setText(String.valueOf(this.model.getVitesse()));
        this.pvView.setText(String.valueOf(this.model.getPv()));
        } else {
            this.dataLayout.setVisibility(View.GONE);
            this.emptyText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =
                inflater.inflate(
                        R.layout.fragment_typepokemon_show,
                        container,
                        false);  
        if (this.getActivity() instanceof DeleteCallback) {
            this.deleteCallback = (DeleteCallback) this.getActivity();
        }

        this.initializeComponent(view);
        
        final Intent intent =  getActivity().getIntent();
        this.update((TypePokemon) intent.getParcelableExtra(TypePokemonContract.PARCEL));

        return view;
    }

    /**
     * Updates the view with the given data.
     *
     * @param item The TypePokemon to get the data from.
     */
    public void update(TypePokemon item) {
        this.model = item;
        
        this.loadData();
        
        if (this.model != null) {
            MultiLoader loader = new MultiLoader(this);
            String baseUri = 
                    TypePokemonProviderAdapter.TYPEPOKEMON_URI 
                    + "/" 
                    + this.model.getId();

            loader.addUri(Uri.parse(baseUri), new UriLoadedCallback() {

                @Override
                public void onLoadComplete(android.database.Cursor c) {
                    TypePokemonShowFragment.this.onTypePokemonLoaded(c);
                }

                @Override
                public void onLoaderReset() {

                }
            });
            loader.init();
        }
    }

    /**
     * Called when the entity has been loaded.
     * 
     * @param c The cursor of this entity
     */
    public void onTypePokemonLoaded(android.database.Cursor c) {
        if (c.getCount() > 0) {
            c.moveToFirst();
            
            TypePokemonContract.cursorToItem(
                        c,
                        this.model);
            this.loadData();
        }
    }

    /**
     * Calls the TypePokemonEditActivity.
     */
    @Override
    public void onClickEdit() {
        final Intent intent = new Intent(getActivity(),
                                    TypePokemonEditActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(TypePokemonContract.PARCEL, this.model);
        intent.putExtras(extras);

        this.getActivity().startActivity(intent);
    }
    /**
     * Shows a confirmation dialog.
     */
    @Override
    public void onClickDelete() {
        new DeleteDialog(this.getActivity(), this).show();
    }

    @Override
    public void onDeleteDialogClose(boolean ok) {
        if (ok) {
            new DeleteTask(this.getActivity(), this.model).execute();
        }
    }
    
    /** 
     * Called when delete task is done.
     */    
    public void onPostDelete() {
        if (this.deleteCallback != null) {
            this.deleteCallback.onItemDeleted();
        }
    }

    /**
     * This class will remove the entity into the DB.
     * It runs asynchronously.
     */
    private class DeleteTask extends AsyncTask<Void, Void, Integer> {
        /** AsyncTask's context. */
        private android.content.Context ctx;
        /** Entity to delete. */
        private TypePokemon item;

        /**
         * Constructor of the task.
         * @param item The entity to remove from DB
         * @param ctx A context to build TypePokemonSQLiteAdapter
         */
        public DeleteTask(final android.content.Context ctx,
                    final TypePokemon item) {
            super();
            this.ctx = ctx;
            this.item = item;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            int result = -1;

            result = new TypePokemonProviderUtils(this.ctx)
                    .delete(this.item);

            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            if (result >= 0) {
                TypePokemonShowFragment.this.onPostDelete();
            }
            super.onPostExecute(result);
        }
        
        

    }

    /**
     * Callback for item deletion.
     */ 
    public interface DeleteCallback {
        /** Called when current item has been deleted. */
        void onItemDeleted();
    }
}

