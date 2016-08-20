package com.example.administrator.yizhudemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.administrator.yizhudemo.R;
import com.example.administrator.yizhudemo.activities.datamanager.Doc_Nur_Main;
import com.example.administrator.yizhudemo.beans.Doc_Nur;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class Doc_NurAdapter extends BaseAdapter implements Filterable {
    Context _context;
    String[] _id, _name, _phone;
    public static LayoutInflater _my_layoutInflater = null;
    ArrayList<Doc_Nur> orig;
    ArrayList<Doc_Nur> doc_nurArrayList;
    /* LayoutInflater inflater;
     ArrayList<Doc_Nur> doc_nurArrayList;
     ArrayList<Doc_Nur> orig;*/
    /*public Doc_NurAdapter(LayoutInflater inf, ArrayList<Doc_Nur> doc_nurArrayList) {
        this.inflater=inf;
        this.doc_nurArrayList=doc_nurArrayList;
    }*/
    public Doc_NurAdapter(Doc_Nur_Main context, String[] id, String[] name, String[] phone) {

        _context = context;
        _id = id;
        _name = name;
        _phone = phone;


        _my_layoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    /* public class Doc_NurHolder{
         TextView textView_list_item_name;
         TextView textView_list_item_phone;
     }*/
    public class HolderClass{
        TextView textView_list_item_id;
        TextView textView_list_item_name;
        TextView textView_list_item_phone;
    }
    @Override
    public int getCount() {
        return _id.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*Doc_NurHolder holder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.doc_nur_line, null);
            holder=new Doc_NurHolder();
            holder.textView_list_item_name=(TextView)convertView.findViewById(R.id.textView_list_item_name);
            holder.textView_list_item_phone=(TextView)convertView.findViewById(R.id.textView_list_item_phone);
            convertView.setTag(holder);
        }
        else
        {
            holder=(Doc_NurHolder) convertView.getTag();
        }
        holder.textView_list_item_name.setText(doc_nurArrayList.get(position).getName());
        holder.textView_list_item_phone.setText(doc_nurArrayList.get(position).getMobile());
        return convertView;*/
        HolderClass myHolder = new HolderClass();
        View myView = _my_layoutInflater.inflate(R.layout.doc_nur_line, null);

        myHolder.textView_list_item_id = (TextView) myView.findViewById(R.id.textView_list_item_id);
        myHolder.textView_list_item_name = (TextView) myView.findViewById(R.id.textView_list_item_name);
        myHolder.textView_list_item_phone = (TextView) myView.findViewById(R.id.textView_list_item_phone);

        myHolder.textView_list_item_id.setText(_id[position]);
        myHolder.textView_list_item_name.setText(_name[position]);
        myHolder.textView_list_item_phone.setText(_phone[position]);




        return myView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<Doc_Nur> results = new ArrayList<Doc_Nur>();
                if (orig == null)
                    orig = doc_nurArrayList;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final Doc_Nur g : orig) {
                            if (g.getName().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                doc_nurArrayList = (ArrayList<Doc_Nur>) results.values;
                notifyDataSetChanged();

            }
        };

    }
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
