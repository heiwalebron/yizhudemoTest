package com.example.administrator.yizhudemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yizhudemo.R;
import com.example.administrator.yizhudemo.beans.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class PictureAdapter extends BaseAdapter {
    private LayoutInflater inflater;// 创建LayoutInflater对象
    private List<Picture> pictures;// 创建List泛型集合

    // 为类创建构造函数
    public PictureAdapter(String[] titles, int[] images, Context context) {
        super();
        pictures = new ArrayList<Picture>();// 初始化泛型集合对象
        inflater = LayoutInflater.from(context);// 初始化LayoutInflater对象
        for (int i = 0; i < images.length; i++)// 遍历图像数组
        {
            Picture picture = new Picture(titles[i], images[i]);// 使用标题和图像生成Picture对象
            pictures.add(picture);// 将Picture对象添加到泛型集合中
        }
    }
    @Override
    public int getCount() {
        if (null != pictures) {// 如果泛型集合不为空
            return pictures.size();// 返回泛型长度
        } else {
            return 0;// 返回0
        }
    }

    @Override
    public Object getItem(int position) {
        return pictures.get(position);// 获取泛型集合指定索引处的项
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;// 创建ViewHolder对象
        if (convertView == null)// 判断图像标识是否为空
        {
            convertView = inflater.inflate(R.layout.gv_item, null);// 设置图像标识
            viewHolder = new ViewHolder();// 初始化ViewHolder对象
            viewHolder.title = (TextView) convertView.findViewById(R.id.ItemTitle);// 设置图像标题
            viewHolder.image = (ImageView) convertView.findViewById(R.id.ItemImage);// 设置图像的二进制值
            convertView.setTag(viewHolder);// 设置提示
        } else {
            viewHolder = (ViewHolder) convertView.getTag();// 设置提示
        }
        viewHolder.title.setText(pictures.get(position).getTitle());// 设置图像标题
        viewHolder.image.setImageResource(pictures.get(position).getImageId());// 设置图像的二进制值
        return convertView;// 返回图像标识
    }
    class ViewHolder// 创建ViewHolder类
    {
        public TextView title;// 创建TextView对象
        public ImageView image;// 创建ImageView对象
    }
}
