package com.itstarr.sampleproject.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.itstarr.sampleproject.R;
import com.itstarr.sampleproject.utils.RecyclerViewMargin;

import static android.R.attr.numColumns;

public class ResturtantSectionedAdapter extends RecyclerView.Adapter<ResturtantSectionedAdapter.ItemRowHolder> {
    String [] ProductSectioned;
    private Context mContext;
Activity activity;
    public ResturtantSectionedAdapter(Context context, String [] ProductSectioned,Activity activity) {
        this.ProductSectioned = ProductSectioned;
        this.mContext = context;
        this.activity = activity;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_view_list, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = ProductSectioned[i];
        int itemMargin =20;
        // ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();
       int[] icon = {R.drawable.rutba, R.drawable.munchkins,R.drawable.kb3,R.drawable.image4,R.drawable.image5,R.drawable.image6};
        String[] ResturtantList = {"Kumaran Dosa", "Food Drive","Wok Singh","Urbanbird Cafe","Milkshake and Co.","Tikka Times"};
        String[] ResturtantAddress = {"Civil Lines", "Sarabha Nagar","Pakhowal Road","Dugri","Gill Chowk","Model Town"};

        itemRowHolder.itemTitle.setText(sectionName);

        System.out.println("abcd");
        RecyclerViewMargin decoration = new RecyclerViewMargin(itemMargin, numColumns);
        itemRowHolder.recycler_view_list.addItemDecoration(decoration);
        ResturtantNameListAdapter resturtantNameListAdapter = new ResturtantNameListAdapter(mContext, icon,ResturtantList,ResturtantAddress,activity);

        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.recycler_view_list.setAdapter(resturtantNameListAdapter);


        itemRowHolder.recycler_view_list.setNestedScrollingEnabled(true);


    }

    @Override
    public int getItemCount() {
        return (null != ProductSectioned ? ProductSectioned.length : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;

        protected Button btnMore;



        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            //this.btnMore= (Button) view.findViewById(R.id.go);


        }

    }
}
