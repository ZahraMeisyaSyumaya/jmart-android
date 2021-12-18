package zahraJmartRK.jmart_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zahraJmartRK.jmart_android.model.Product;

public class RecycleActivity extends RecyclerView.Adapter<RecycleActivity.ViewHolder> {

    private List<Product> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    RecycleActivity(Context context, List<Product> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_recycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product productName = mData.get(position);
        holder.myTextView.setText(productName.toString());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void refresh(List<Product> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tv_productName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    String getItem(int id) {
        return mData.get(id).toString();
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }
}
