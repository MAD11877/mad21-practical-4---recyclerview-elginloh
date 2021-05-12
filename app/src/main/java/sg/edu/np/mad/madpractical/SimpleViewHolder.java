package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder{
    TextView txt, txtx;
    ImageView imgview, bigImg;
    public SimpleViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.textView);
        txtx = itemView.findViewById(R.id.textView3);
        imgview = itemView.findViewById(R.id.imageView3);
        bigImg = itemView.findViewById(R.id.bigImg);
    }

}
