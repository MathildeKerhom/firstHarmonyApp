/**************************************************************************
 * TypePokemonCreateFragment.java, pokemon Android
 *
 * Copyright 2016
 * Description : 
 * Author(s)   : Harmony
 * Licence     : 
 * Last update : May 26, 2016
 *
 **************************************************************************/
package com.mathildekerhom.pokemon.view.typepokemon;



import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.common.base.Strings;
import com.mathildekerhom.pokemon.R;
import com.mathildekerhom.pokemon.entity.TypePokemon;

import com.mathildekerhom.pokemon.harmony.view.HarmonyFragmentActivity;
import com.mathildekerhom.pokemon.harmony.view.HarmonyFragment;

import com.mathildekerhom.pokemon.menu.SaveMenuWrapper.SaveMenuInterface;
import com.mathildekerhom.pokemon.provider.utils.TypePokemonProviderUtils;

/**
 * TypePokemon create fragment.
 *
 * This fragment gives you an interface to create a TypePokemon.
 */
public class TypePokemonCreateFragment extends HarmonyFragment
            implements SaveMenuInterface {
    /** Model data. */
    protected TypePokemon model = new TypePokemon();

    /** Fields View. */
    /** name View. */
    protected EditText nameView;
    /** attaque View. */
    protected EditText attaqueView;
    /** attaque_spe View. */
    protected EditText attaque_speView;
    /** defense View. */
    protected EditText defenseView;
    /** defense_spe View. */
    protected EditText defense_speView;
    /** vitesse View. */
    protected EditText vitesseView;
    /** pv View. */
    protected EditText pvView;

    /** Initialize view of fields.
     *
     * @param view The layout inflating
     */
    protected void initializeComponent(final View view) {
        this.nameView =
            (EditText) view.findViewById(R.id.typepokemon_name);
        this.attaqueView =
            (EditText) view.findViewById(R.id.typepokemon_attaque);
        this.attaque_speView =
            (EditText) view.findViewById(R.id.typepokemon_attaque_spe);
        this.defenseView =
            (EditText) view.findViewById(R.id.typepokemon_defense);
        this.defense_speView =
            (EditText) view.findViewById(R.id.typepokemon_defense_spe);
        this.vitesseView =
            (EditText) view.findViewById(R.id.typepokemon_vitesse);
        this.pvView =
            (EditText) view.findViewById(R.id.typepokemon_pv);
    }

    /** Load data from model to fields view. */
    public void loadData() {

        if (this.model.getName() != null) {
            this.nameView.setText(this.model.getName());
        }
        this.attaqueView.setText(String.valueOf(this.model.getAttaque()));
        this.attaque_speView.setText(String.valueOf(this.model.getAttaque_spe()));
        this.defenseView.setText(String.valueOf(this.model.getDefense()));
        this.defense_speView.setText(String.valueOf(this.model.getDefense_spe()));
        this.vitesseView.setText(String.valueOf(this.model.getVitesse()));
        this.pvView.setText(String.valueOf(this.model.getPv()));


    }

    /** Save data from fields view to model. */
    public void saveData() {

        this.model.setName(this.nameView.getEditableText().toString());

        this.model.setAttaque(Integer.parseInt(
                    this.attaqueView.getEditableText().toString()));

        this.model.setAttaque_spe(Integer.parseInt(
                    this.attaque_speView.getEditableText().toString()));

        this.model.setDefense(Integer.parseInt(
                    this.defenseView.getEditableText().toString()));

        this.model.setDefense_spe(Integer.parseInt(
                    this.defense_speView.getEditableText().toString()));

        this.model.setVitesse(Integer.parseInt(
                    this.vitesseView.getEditableText().toString()));

        this.model.setPv(Integer.parseInt(
                    this.pvView.getEditableText().toString()));

    }

    /** Check data is valid.
     *
     * @return true if valid
     */
    public boolean validateData() {
        int error = 0;

        if (Strings.isNullOrEmpty(
                    this.nameView.getText().toString().trim())) {
            error = R.string.typepokemon_name_invalid_field_error;
        }
        if (Strings.isNullOrEmpty(
                    this.attaqueView.getText().toString().trim())) {
            error = R.string.typepokemon_attaque_invalid_field_error;
        }
        if (Strings.isNullOrEmpty(
                    this.attaque_speView.getText().toString().trim())) {
            error = R.string.typepokemon_attaque_spe_invalid_field_error;
        }
        if (Strings.isNullOrEmpty(
                    this.defenseView.getText().toString().trim())) {
            error = R.string.typepokemon_defense_invalid_field_error;
        }
        if (Strings.isNullOrEmpty(
                    this.defense_speView.getText().toString().trim())) {
            error = R.string.typepokemon_defense_spe_invalid_field_error;
        }
        if (Strings.isNullOrEmpty(
                    this.vitesseView.getText().toString().trim())) {
            error = R.string.typepokemon_vitesse_invalid_field_error;
        }
        if (Strings.isNullOrEmpty(
                    this.pvView.getText().toString().trim())) {
            error = R.string.typepokemon_pv_invalid_field_error;
        }
    
        if (error > 0) {
            Toast.makeText(this.getActivity(),
                this.getActivity().getString(error),
                Toast.LENGTH_SHORT).show();
        }
        return error == 0;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(
                R.layout.fragment_typepokemon_create,
                container,
                false);

        this.initializeComponent(view);
        this.loadData();
        return view;
    }

    /**
     * This class will save the entity into the DB.
     * It runs asynchronously and shows a progressDialog
     */
    public static class CreateTask extends AsyncTask<Void, Void, Uri> {
        /** AsyncTask's context. */
        private final android.content.Context ctx;
        /** Entity to persist. */
        private final TypePokemon entity;
        /** Progress Dialog. */
        private ProgressDialog progress;

        /**
         * Constructor of the task.
         * @param entity The entity to insert in the DB
         * @param fragment The parent fragment from where the aSyncTask is
         * called
         */
        public CreateTask(final TypePokemonCreateFragment fragment,
                final TypePokemon entity) {
            super();
            this.ctx = fragment.getActivity();
            this.entity = entity;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            this.progress = ProgressDialog.show(this.ctx,
                    this.ctx.getString(
                            R.string.typepokemon_progress_save_title),
                    this.ctx.getString(
                            R.string.typepokemon_progress_save_message));
        }

        @Override
        protected Uri doInBackground(Void... params) {
            Uri result = null;

            result = new TypePokemonProviderUtils(this.ctx).insert(
                        this.entity);

            return result;
        }

        @Override
        protected void onPostExecute(Uri result) {
            super.onPostExecute(result);
            if (result != null) {
                final HarmonyFragmentActivity activity =
                                         (HarmonyFragmentActivity) this.ctx;
                activity.finish();
            } else {
                final AlertDialog.Builder builder =
                        new AlertDialog.Builder(this.ctx);
                builder.setIcon(0);
                builder.setMessage(
                        this.ctx.getString(
                                R.string.typepokemon_error_create));
                builder.setPositiveButton(
                        this.ctx.getString(android.R.string.yes),
                        new Dialog.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                    int which) {

                            }
                        });
                builder.show();
            }

            this.progress.dismiss();
        }
    }


    @Override
    public void onClickSave() {
        if (this.validateData()) {
            this.saveData();
            new CreateTask(this, this.model).execute();
        }
    }
}
