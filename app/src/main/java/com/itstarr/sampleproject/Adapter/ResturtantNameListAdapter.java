package com.itstarr.sampleproject.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itstarr.sampleproject.R;

public class ResturtantNameListAdapter extends RecyclerView.Adapter<ResturtantNameListAdapter.SingleItemRowHolder> {
    int[] ProductName;

    private Context mContext;
Activity activity;
    int[] icon;
    String[]name;
    String[]address;

    public ResturtantNameListAdapter(Context context, int [] icon,String[]name,String[]address,Activity activity) {
        this.icon = icon;
        this.name = name;
        this.address = address;
        this.activity =activity;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activities_product_layout, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, final int i) {

        int singleItem = icon[i];

        holder.ProductImage.setImageResource(singleItem);
        holder.ResturantName.setText(name[i]);
        holder.ResturtantAddress.setText(address[i]);


        System.out.println("ResturantName " + name[i]);
        holder.MainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity,ResturtantDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  intent.putExtra("res_name",name[i]);
                  intent.putExtra("res_address",address[i]);
                // intent.putExtra("licNumber",LicNum);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });

       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != icon ? icon.length : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected ImageView ProductImage;
         TextView ResturantName,ResturtantAddress;
LinearLayout MainLayout;


        public SingleItemRowHolder(View view) {
            super(view);

            this.ProductImage = (ImageView) view.findViewById(R.id.product_image);
            this.ResturantName = (TextView)view.findViewById(R.id.rest_name);
            this.ResturtantAddress = (TextView)view.findViewById(R.id.short_address);
this.MainLayout = (LinearLayout)view.findViewById(R.id.main_layout);




        }

    }
}
