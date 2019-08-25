package com.example.homepagedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class HomeProductAdapter extends RecyclerView.Adapter<HomeProductAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context ctx;
    private List<Datum> mProducts;
    private String price;

    public HomeProductAdapter(Context ctx, List<Datum> imageModelArrayList){
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
        this.mProducts = imageModelArrayList;
    }

    @Override
    public HomeProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.homepage_single_prod, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(HomeProductAdapter.MyViewHolder holder, int position) {
        final Datum currentProduct = mProducts.get(position);
        
            MyViewHolder productHolder = (MyViewHolder) holder;
            //bind products information with view
            Glide.with(ctx).load(currentProduct.getUrl() + "/" + currentProduct.getFileName()).placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder).into(productHolder.imageViewProductThumb);
            productHolder.textViewProductName.setText(currentProduct.getName());
            if(currentProduct.getVariants()>0) {
                price = currentProduct.getPrice();
            }
            else {
                if( Float.parseFloat(currentProduct.getSellPrice()) != 0) {
                    price = currentProduct.getSellPrice();
                    productHolder.strikethrough.setVisibility(View.VISIBLE);
                }
                else {
                    price = currentProduct.getRegularPrice();
                }
            }
            productHolder.textViewProductPrice.setText(currentProduct.getRegularPrice());
            if (currentProduct.getBadge()!=null) {
                if(currentProduct.getBadge().toString().length()>1) {
                    productHolder.textViewNew.setVisibility(View.VISIBLE);
                    productHolder.textViewNew.setText(currentProduct.getBadge().toString());
                }

            }
            else
                productHolder.textViewNew.setVisibility(View.GONE);

            productHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // user selected product now you can show details of that product
                    Toast.makeText(ctx, currentProduct.getProductSlug(), Toast.LENGTH_SHORT).show();
                }
            });
        
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewProductThumb;
        TextView textViewProductName, textViewProductPrice, textViewNew,strikethrough;


        public MyViewHolder(View itemView) {
            super(itemView);
            imageViewProductThumb = itemView.findViewById(R.id.imageViewProductThumb);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewProductPrice = itemView.findViewById(R.id.textViewProductPrice);
            strikethrough = itemView.findViewById(R.id.textViewSellProductPrice);
            textViewNew = itemView.findViewById(R.id.textViewNew);
        }

    }
}