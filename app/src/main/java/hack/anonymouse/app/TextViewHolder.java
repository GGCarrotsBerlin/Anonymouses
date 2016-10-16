package hack.anonymouse.app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class TextViewHolder extends RecyclerView.ViewHolder {

    final TextView text;

    TextViewHolder(View view) {
        super(view);
        text = (TextView) view.findViewById(android.R.id.text1);
    }
}
