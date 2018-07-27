package com.ephraim.me.navigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.ephraim.me.navigation.recipe.Recipe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class RecipeActivity extends AppCompatActivity {

    private ImageView recipeImage;
    private DatabaseReference mDatabase;
    private String mRecipe = null;
    private Recipe recipe;

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

//        mRecipe = getIntent().getStringExtra("recipe_id");
//
//        mDatabase= FirebaseDatabase.getInstance().getReference().child("Recipes");
//        recipeImage = (ImageView) findViewById(R.id.recipeImage);
//
//     mDatabase.child(mRecipe).addValueEventListener(new ValueEventListener() {
//
//
//
//
//         @Override
//          public void onDataChange(DataSnapshot dataSnapshot) {
//
//             for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//
//
//
//                 Recipe recipe = snapshot.getValue(Recipe.class);
//
//                 String post_image = (String) dataSnapshot.child("image").getValue();
//                 Picasso.with(RecipeActivity.this).load(post_image)
//                         .into(recipeImage);
//
//             }
//
//
//            }
//
//           @Override
//           public void onCancelled(DatabaseError databaseError) {
//
//            }
//       });
//
//
//
//        }

    }
}




