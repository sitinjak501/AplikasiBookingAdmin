package BuktiTransfer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appbookadmin.R;
import com.squareup.picasso.Picasso;


import org.jetbrains.annotations.NotNull;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private final Context mContext;
    private final List<Images> mImages;

    public ImageAdapter(Context context, List<Images> Images) {
        mContext = context;
        mImages = Images;
    }
    @NotNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.itemtransferbukti, parent, false);
        return new ImageViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Images images = mImages.get(position);
        holder.textViewName.setText(images.getimageName());
//        Picasso.with(mContext)
//                .load(images.getimageURL())
//                .placeholder(R.mipmap.ic_launcher)
//                .fit()
//                .centerCrop()
//                .into(holder.imageViewTransfer);
    }
    @Override
    public int getItemCount() {
        return mImages.size();
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
//        public ImageView imageViewTransfer;
        public ImageViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
//            imageViewTransfer = itemView.findViewById(R.id.image_view_upload);
        }
    }
}