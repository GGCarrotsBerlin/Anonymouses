package hack.anonymouse.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class ListAdapter extends RecyclerView.Adapter {

    private final List<CharSequence> data;
    private final int id;

    ListAdapter(List<CharSequence> data, int id) {
        this.data = data;
        this.id = id;
    }

    private int getLayout(int viewType) {
        switch (viewType) {
            case 0:
                return R.layout.item_story;
            case 1:
                return R.layout.item_header;
            case 2:
                return R.layout.item_conversation;
            default:
                return 0;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(getLayout(viewType), parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        ((TextViewHolder) holder).text.setText(data.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (id == 1 && position == 0) {
            return 2;
        }
        if (id == 0 && position == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
