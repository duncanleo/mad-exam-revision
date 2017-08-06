package me.duncanleo.examrevision.adapter;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import me.duncanleo.examrevision.R;
import me.duncanleo.examrevision.model.App;

/**
 * Created by duncanleo on 6/8/17.
 */

public class ListViewAdapter extends BaseAdapter {
    private List<App> data;

    public ListViewAdapter(List<App> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Not using ViewHolder pattern because I usually use RecyclerView and not ListView
        // and will have no time to write the ListView ViewHolder implementation in the exams
        ConstraintLayout itemView = (ConstraintLayout)LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_listview, viewGroup, false);
        TextView name = itemView.findViewById(R.id.appNameTextView);
        TextView type = itemView.findViewById(R.id.appTypeTextView);

        App item = data.get(i);
        name.setText(String.format(
                Locale.getDefault(),
                "%s CPU: %d%%",
                item.getTitle(),
                item.getProcUsage()
        ));
        type.setText(item.getType());
        return itemView;
    }
}
