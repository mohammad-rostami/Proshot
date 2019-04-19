package com.waycreon.pip;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


//*************************************************************** THIS CLASS IS THE ADAPTER OF RECYCLERVIEWS
public class Adapter_Recycler extends RecyclerView.Adapter<Adapter_Recycler.ViewHolder> {
    public static boolean checked;
    private OnItemListener onItemListener;
    private Context context;
    private ArrayList<Struct> structs;
    private boolean isGrid;
    private int Tab;
    private Struct selectedGroupPosition;
    private Boolean x;
    private Boolean m;
    private RadioButton lastCheckedRadio;
    private LinearLayout LastSelected;
    private LinearLayout LastFontSelected;

    public Adapter_Recycler(Context context, ArrayList<Struct> structs, OnItemListener onItemListener, int Tab, boolean isGrid) {
        this.onItemListener = onItemListener;
        this.context = context;
        this.structs = structs;
        this.isGrid = isGrid;
        this.Tab = Tab;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //CHOOSE WITCH XML (CARD LAYOUT) TO SHOW (INFLATE) FOR EATCH RECYCLERVIEW
        View view = null;

        if (Tab == 1) {
            view = inflater.inflate(R.layout.list_item_font, parent, false);
        }
        if (Tab == 2) {
            view = inflater.inflate(R.layout.list_item_cat, parent, false);
        }
        if (Tab == 3) {
            view = inflater.inflate(R.layout.list_item_fram, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

//        //DEFINING VIEWS FOR EATCH RECYCLER VIEW
        Typeface typeFace_Regular = Typeface.createFromAsset(MainActivity.context.getAssets(), "iran_sans_regular.ttf");
//        Typeface typeFace_Medium = Typeface.createFromAsset(ActivityHome.sContext.getAssets(), "iran_sans_medium.ttf");
//        Typeface typeFace_Light = Typeface.createFromAsset(ActivityHome.sContext.getAssets(), "iran_sans_light.ttf");


        if (Tab == 1) {
            Typeface face = Typeface.createFromAsset(context.getAssets(), structs.get(position).strTitle);
            holder.TextViewFontItem.setTypeface(face);
            String state = structs.get(position).strValue;
            holder.frame.setVisibility(View.GONE);

            if (Global.isLimited) {
                if (state.equals("lock")) {
                    holder.lock.setVisibility(View.VISIBLE);
                    holder.LLViewHouseItem.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemListener.onItemSelect(position);
                        }
                    });
                } else {
                    holder.lock.setVisibility(View.GONE);
                    holder.LLViewHouseItem.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemListener.onItemClick(position);
                            try {
                                LastFontSelected.setVisibility(View.GONE);
                            } catch (Exception e) {

                            }
                            LastFontSelected = holder.frame;
                            holder.frame.setVisibility(View.VISIBLE);
                        }
                    });
                }
            } else {
                holder.lock.setVisibility(View.GONE);
                holder.LLViewHouseItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemListener.onItemClick(position);
                        try {
                            LastFontSelected.setVisibility(View.GONE);
                        } catch (Exception e) {

                        }
                        LastFontSelected = holder.frame;
                        holder.frame.setVisibility(View.VISIBLE);
                    }
                });
            }
            holder.TextViewFontItem.setText(structs.get(position).strKEY);

        }
        if (Tab == 2) {
            holder.IMGViewHouseItem.setImageResource(structs.get(position).intSource);
            Picasso.with(context).load(structs.get(position).intSource).into(holder.IMGViewHouseItem);
            holder.IMGViewHouseItem.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            holder.TextViewFontItem.setText(structs.get(position).strTitle);
            holder.TextViewFontItem.setTypeface(typeFace_Regular);

            holder.TextViewFontItem.setTextColor(structs.get(position).intColor);
            holder.IMGViewHouseItem.setColorFilter(structs.get(position).intColor);


            holder.LLViewHouseItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemListener.onItemClick(position);

                }
            });

        }
        if (Tab == 3) {
            holder.IMGViewHouseItem.setImageResource(structs.get(position).intSource);
            Picasso.with(context).load(structs.get(position).intSource).into(holder.IMGViewHouseItem);
            holder.IMGViewHouseItem.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            holder.frame.setVisibility(View.GONE);
//            holder.TextViewFontItem.setText(structs.get(position).strTitle);

            String state = structs.get(position).strValue;
            if (Global.isLimited) {
                if (state.equals("lock")) {
                    holder.lock.setVisibility(View.VISIBLE);
                    holder.LLViewHouseItem.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemListener.onItemSelect(position);
                        }
                    });
                } else {
                    holder.lock.setVisibility(View.GONE);
                    holder.LLViewHouseItem.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemListener.onItemClick(position);
                            try {
                                LastSelected.setVisibility(View.GONE);
                            } catch (Exception e) {

                            }
                            LastSelected = holder.frame;
                            holder.frame.setVisibility(View.VISIBLE);
                        }
                    });
                }
            } else {
                holder.lock.setVisibility(View.GONE);
                holder.LLViewHouseItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemListener.onItemClick(position);
                        try {
                            LastSelected.setVisibility(View.GONE);
                        } catch (Exception e) {

                        }
                        LastSelected = holder.frame;
                        holder.frame.setVisibility(View.VISIBLE);
                    }
                });
            }

        }
    }


    @Override
    public int getItemCount() {
        return structs.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout LLViewHouseItem;
        ImageView IMGViewHouseItem;
        TextView TextViewFontItem;
        ImageView lock;
        LinearLayout frame;

        public ViewHolder(View itemView) {
            super(itemView);
            LLViewHouseItem = (RelativeLayout) itemView.findViewById(R.id.list_item_frame_ll_item);
            IMGViewHouseItem = (ImageView) itemView.findViewById(R.id.list_item_frame_img_item);
            lock = (ImageView) itemView.findViewById(R.id.lock);
            TextViewFontItem = (TextView) itemView.findViewById(R.id.list_item_font_tv_item);
            frame = (LinearLayout) itemView.findViewById(R.id.frame);


        }
    }

}
