package com.example.me.firebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.me.firebase.Store.Menu;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Me on 10/27/2016.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<Menu> mMenus;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MenuAdapter(Context context, List<Menu> datas) {
        mContext = context;
        mMenus = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.itemmenu, parent, false);
        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MenuViewHolder holder, int position) {
        Menu menu=mMenus.get(position);

        holder.tvtitle.setText(menu.getTenmon().toString());
        holder.tvprice.setText(String.valueOf(menu.getGia()));
        Picasso.with(mContext).setIndicatorsEnabled(true);

        Picasso.with(mContext)
                .load(menu.getLinkhinh())
                .into(holder.imgmenu);
    }

    @Override
    public int getItemCount() {
        return mMenus.size();
    }


    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgmenu;
        TextView tvtitle,tvprice;
        public MenuViewHolder(View itemView) {
            super(itemView);
            imgmenu= (ImageView) itemView.findViewById(R.id.imgmenu);
            tvtitle= (TextView) itemView.findViewById(R.id.tvtitle);
            tvprice= (TextView) itemView.findViewById(R.id.tvprice);
        }
    }
}

