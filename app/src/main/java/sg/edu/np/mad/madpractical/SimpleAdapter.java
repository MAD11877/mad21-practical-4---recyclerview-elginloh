package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.security.AccessController;
import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    ArrayList<User> data;

    public SimpleAdapter(ArrayList<User> input){
        data = input;
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplerecyclerview,parent, false);
        return new SimpleViewHolder(item);
    }

    public void onBindViewHolder(SimpleViewHolder holder, int position){
        User listObjects = data.get(position);
        holder.txt.setText(listObjects.getName());
        holder.txtx.setText(listObjects.getDescription());
        if (listObjects.getName().endsWith("7"))
        {
            holder.bigImg.setImageResource(R.mipmap.ic_launcher_round);
            holder.bigImg.setVisibility(View.VISIBLE);
        }
        else {
            holder.bigImg.setVisibility(View.GONE);
        }
        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.imgview.getContext());
                builder.setTitle("Profile");
                builder.setMessage(listObjects.getName());
                builder.setNegativeButton("Close", null);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                @Override
                  public void onClick(DialogInterface dialogInterface, int i) {

                    Bundle mBundle = new Bundle();
                    mBundle.putString("name", listObjects.getName());
                    mBundle.putString("desc", listObjects.getDescription());
                    Intent wassup = new Intent(holder.imgview.getContext(), MainActivity.class);
                    wassup.putExtras(mBundle);
                    holder.imgview.getContext().startActivity(wassup);
                }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public int getItemCount(){
        return data.size();
    }
}
