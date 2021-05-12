package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> UserInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
//        ImageView imgView = (ImageView) findViewById(R.id.imageView3);
//        imgView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
//                builder.setTitle("Profile");
//                builder.setMessage(UserInfoList.indexOf());
//                builder.setNegativeButton("Close", null);
//                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent randomInt = new Intent(ListActivity.this, MainActivity.class);
//                        randomInt.putExtra("randInt", new Random().nextInt());
//                        startActivity(randomInt);
//                    }
//                });
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
//        });
        for(int i = 0; i < 19; i ++){
            int r = new Random().nextInt();
            int z = new Random().nextInt();
            boolean bool = true;
            if(r%2 == 0)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            User user = new User("Elgin"+r, "Description: "+z, i, bool);
            UserInfoList.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        SimpleAdapter sAdapter = new SimpleAdapter(UserInfoList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);
    }


}