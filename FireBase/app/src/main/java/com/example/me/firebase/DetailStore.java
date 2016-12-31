package com.example.me.firebase;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.StackView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.me.firebase.Store.Menu;
import com.example.me.firebase.Store.Store;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.widget.LikeView;
import com.squareup.picasso.Picasso;
import com.facebook.FacebookSdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DetailStore extends AppCompatActivity {
    //thong
    ListView lv;
    ImageView img, imgmap, imgcall;
    TextView txtTen, txtDiaChi, txtThoiGian, txtSDT;
    RecyclerView rv;
    List<Menu> mMenus = new ArrayList<Menu>();
    ArrayAdapter adapter = null;
    MenuAdapter menuAdapter ;
    AdapterStackMenu adapterStackMenu;
    List<String> lit = new ArrayList<String>();
    private LinearLayoutManager mLinearLayoutManager;
    ImageView imgstore;
    Toolbar toolbar;
    TextView title;
    ImageView imgdirect;

    //thong
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_detail_store);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("Chi Tiết Cửa Hàng");
        imgdirect= (ImageView) toolbar.findViewById(R.id.imgdirect);
        imgdirect.setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AnhXa();
        //LikeView
        LikeView likeView = (LikeView) findViewById(R.id.likeView);
        likeView.setLikeViewStyle(LikeView.Style.BOX_COUNT);
        likeView.setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition.INLINE);
        likeView.setObjectIdAndType(
                "https://www.foody.vn/", LikeView.ObjectType.OPEN_GRAPH);

        Intent intent = getIntent();
        final Store storeposition = (Store) intent.getSerializableExtra("storeposition");
        final String diachi = storeposition.getDiachi().toString();
        txtTen.setText(storeposition.getTenStore().toString());
        txtThoiGian.setText(storeposition.getTime().toString());
        txtDiaChi.setText(storeposition.getDiachi().toString());
        txtSDT.setText(storeposition.getSdt().toString());
        /*Picasso.with(DetailStore.this)
                .load(storeposition.getLinkHinh().toString())
                .into(img);*/
        imgmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(DetailStore.this, MapsActivity.class);
                    i.putExtra("DiaChi", diachi);
                    startActivity(i);
                } catch (Exception e) {
                    Log.v("Failed", e.getMessage());
                }
            }
        });
        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallClicked(storeposition);
            }
        });
        FloatingActionButton fabbun = (FloatingActionButton) findViewById(R.id.fabdetail);
        fabbun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mMenus = storeposition.getMenuList();
        /*if (mMenus.size()==0){
            rv.setVisibility(View.GONE);

            Picasso.with(DetailStore.this)
                    .load(storeposition.getLinkHinh().toString())
                    .into(imgstore);
        }else {*/
            imgstore.setVisibility(View.GONE);
            menuAdapter = new MenuAdapter(DetailStore.this, mMenus);
            rv.setAdapter(menuAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            rv.setLayoutManager(linearLayoutManager);
        //}
    }


    //tien
    public void onCallClicked(Store store) {
        Uri uri = Uri.parse("tel:" + store.getSdt());
        Intent intent = new Intent(Intent.ACTION_DIAL).setData(uri);
        startActivity(intent);
    }
    //FloatingActionButton fabDetail = (FloatingActionButton) findViewById(R.id.fabdetail);


    private void AnhXa() {
        imgstore= (ImageView) findViewById(R.id.imgstore);
        rv = (RecyclerView) findViewById(R.id.rv);
        lv = (ListView) findViewById(R.id.lv);
        txtTen = (TextView) findViewById(R.id.txtDetailStore);
        txtDiaChi = (TextView) findViewById(R.id.txtDetailAddress);
        txtThoiGian = (TextView) findViewById(R.id.txtDetailOpen);
        txtSDT = (TextView) findViewById(R.id.txtDetailPhone);
        imgmap = (ImageView) findViewById(R.id.imgmap);
        imgcall = (ImageView) findViewById(R.id.imgcall);

    }
}
