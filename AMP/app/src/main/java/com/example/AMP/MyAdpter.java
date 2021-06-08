package com.example.AMP;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;
     class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage ;
        TextView fruitName;

         public ImageView getFruitImage() {
             return fruitImage;
         }

         public TextView getFruitName() {
             return fruitName;
         }

         public View getFruitView() {
             return fruitView;
         }

         View fruitView;
        public ViewHolder (View view)
        {
            super(view);
            fruitView=view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruitname);
        }


    }

    public  FruitAdapter (List <Fruit> fruitList){
        mFruitList = fruitList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder holder = new ViewHolder(view);

//        holder.fruitName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = holder.getAdapterPosition();
//                Fruit fruit=mFruitList.get(position);
//                //Toast.makeText(view.getContext(),"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = holder.getAdapterPosition();
//                Fruit fruit=mFruitList.get(position);
//                //Toast.makeText(view.getContext(),"you clicked view "+fruit.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        Fruit fruit = mFruitList.get(position);

        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitImage.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.fruitName.setText(fruit.getName()+"\r\n"+fruit.getLastNew()+"\r\n"+fruit.getTime());
        //判断是否设置了监听
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }
        if (mOnItemLongClickListener!=null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position=holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount(){
        return mFruitList.size();
    }


    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }


    //移除数据
    public void removeData(int position) {
        mFruitList.remove(position);
        notifyItemRemoved(position);
    }
    //新增数据
    public void addData(int position){
       // mFruitList.add(position,new Fruit("AddOne", R.drawable.ic_launcher_background,"1","12"));
        notifyItemInserted(position);
    }
    //更改某个位置的数据
    public void changeData(int position){
       // mFruitList.set(position,new Fruit("Item has changed", R.drawable.ic_launcher_background,));
        notifyItemChanged(position);
    }


}

