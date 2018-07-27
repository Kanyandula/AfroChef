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

import com.ephraim.me.navigation.recipe.Market;
import com.ephraim.me.navigation.recipe.Recipe;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Belal on 18/09/16.
 */


public class Menu1 extends Fragment  {

    private RecyclerView recyclerView;
    private DatabaseReference mdatabase;

    //CustomItemClickListener listener;
    Context context;


    FirebaseRecyclerAdapter<Market,MarketViewHolder> firebaseRecyclerAdapter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View rootView = inflater.inflate(R.layout.fragement_menu_1, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<Market> options = new FirebaseRecyclerOptions.Builder<Market>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Markets"), Market.class)
                .build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Market, MarketViewHolder>(options){



            @NonNull
            @Override
            public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_row1, parent, false);
                return new MarketViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull MarketViewHolder holder, int position, @NonNull Market model) {
                holder.setImageName(model.getTittle());
                holder.setImageUrl(holder.mView.getContext(), model.getImage());
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getActivity(), "This is my Toast message!",
                                Toast.LENGTH_LONG).show();

//                        Intent intent = new Intent(getActivity(), RecipeActivity.class);
//                        intent.putExtra("recipe_id", mRecipe);
//
//                        startActivity(intent);
                    }
                });

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
        getActivity().setTitle("African Markets");
    }
}