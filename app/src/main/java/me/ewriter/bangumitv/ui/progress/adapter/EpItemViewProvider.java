package me.ewriter.bangumitv.ui.progress.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.drakeet.multitype.ItemViewProvider;
import me.ewriter.bangumitv.R;
import me.ewriter.bangumitv.api.entity.AnimeEpEntity;
import me.ewriter.bangumitv.ui.bangumidetail.adapter.DetailEpAdapter;
import me.ewriter.bangumitv.ui.bangumidetail.adapter.DetailEpList;

/**
 * Created by Zubin on 2016/9/28.
 */

public class EpItemViewProvider extends ItemViewProvider<EpList, EpItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected EpItemViewProvider.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);
        return new EpItemViewProvider.ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull EpItemViewProvider.ViewHolder holder, @NonNull EpList epList) {
        holder.setList(epList.mList);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;
        private EpAdapter adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerview);
            GridLayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(), 6);
            adapter = new EpAdapter();
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        private void setList(List<AnimeEpEntity> list) {
            adapter.setList(list);
            adapter.notifyDataSetChanged();
        }
    }
}
