package cl.cutiko.pendingsrealm.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import cl.cutiko.pendingsrealm.R;
import cl.cutiko.pendingsrealm.models.Pending;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by cutiko on 13-03-17.
 */

public class PendingsAdapter extends RealmRecyclerViewAdapter<Pending, PendingsAdapter.ViewHolder> {

    public PendingsAdapter(@Nullable OrderedRealmCollection<Pending> data) {
        super(data, true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pending pending = getData().get(position);
        holder.name.setText(pending.getName());
        holder.status.setChecked(pending.isDone());
        holder.status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    int auxPosition = holder.getAdapterPosition();
                    Pending auxPending = getData().get(auxPosition);
                    auxPending.setDone(true);
                    getData().remove(auxPosition);
                }
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CheckBox status;

        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.pendingTv);
            status = (CheckBox) view.findViewById(R.id.pendingCb);
        }

    }

}
