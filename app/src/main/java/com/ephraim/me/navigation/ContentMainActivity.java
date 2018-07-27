package com.ephraim.me.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ephraim.me.navigation.recipe.Recipe;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContentMainActivity extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseReference mdatabase;

    //CustomItemClickListener listener;
    Context context;


    FirebaseRecyclerAdapter<Recipe,RecipeViewHolder> firebaseRecyclerAdapter;


    public ContentMainActivity() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        //return inflater.inflate(R.layout.content_main, container, false);
        View rootView = inflater.inflate(R.layout.fragment_content,container,false);

      recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<Recipe> options = new FirebaseRecyclerOptions.Builder<Recipe>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Recipes"), Recipe.class)
                .build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Recipe, RecipeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final RecipeViewHolder holder, int position, @NonNull Recipe model) {
                final  String mRecipe = getRef(position).toString();
                holder.setImageName(model.getTittle());
                holder.setImageUrl(holder.mView.getContext(), model.getImage());

                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getActivity(), "This is my Toast message!",
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getActivity(), RecipeActivity.class);
                        intent.putExtra("recipe_id", mRecipe);

                        startActivity(intent);
                    }
                });



            }

            @NonNull
            @Override
            public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_row, parent, false);
                return new RecipeViewHolder(view);
            }

        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);






        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
        // Start listening to get recipes from firebase
        firebaseRecyclerAdapter.startListening();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop listening when the user gets out of the app.
        firebaseRecyclerAdapter.stopListening();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Home");
    }







}
