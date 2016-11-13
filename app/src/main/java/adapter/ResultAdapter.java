package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.cehua.nicestars.activity.R;
import model.Datasss;


/**
 * Created by nicestars  on 2016/6/26 0026.
 */
public class ResultAdapter extends BaseAdapter {
    private LayoutInflater minflater;//布局加载器
    private Context context;//上下文
    private List<Datasss> infos = new ArrayList();
    private TextView date, fengli, fengxiang, hightemp, lowtemp, type, week;

    public ResultAdapter(Context context) {
        this.context = context;
        minflater = LayoutInflater.from(context);

        Log.e("111111111111112", "6");
    }

    public void setInfos(List<Datasss> infos) {
        this.infos = infos;
    }

    @Override
    public int getCount() {
        return infos == null ? 0 : infos.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = minflater.inflate(R.layout.list_items, null);
        date = (TextView) convertView.findViewById(R.id.date);
        fengli = (TextView) convertView.findViewById(R.id.fengli);
        fengxiang = (TextView) convertView.findViewById(R.id.fengxiang);
        hightemp = (TextView) convertView.findViewById(R.id.hightemp);
        lowtemp = (TextView) convertView.findViewById(R.id.lowtemp);
        type = (TextView) convertView.findViewById(R.id.type);
        week = (TextView) convertView.findViewById(R.id.week);


        date.setText(infos.get(position).date);
        fengli.setText(infos.get(position).fengli);
        fengxiang.setText(infos.get(position).fengxiang);
        hightemp.setText(infos.get(position).hightemp);
        lowtemp.setText(infos.get(position).lowtemp);
        type.setText(infos.get(position).type);
        week.setText(infos.get(position).week);
        return convertView;
    }
*/
    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            Log.e("111111111111112", "7");
            holder = new ViewHolder();
            convertView = minflater.inflate(R.layout.list_items, null);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.fengli = (TextView) convertView.findViewById(R.id.fengli);
            holder.fengxiang = (TextView) convertView.findViewById(R.id.fengxiang);
            holder.hightemp = (TextView) convertView.findViewById(R.id.hightemp);
            holder.lowtemp = (TextView) convertView.findViewById(R.id.lowtemp);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.week = (TextView) convertView.findViewById(R.id.week);
            convertView.setTag(holder);
        } else {
            Log.e("111111111111112", "8");
            holder = (ViewHolder) convertView.getTag();
            holder.date.setText(infos.get(position).date);
            holder.fengli.setText(infos.get(position).fengli);
            holder.fengxiang.setText(infos.get(position).fengxiang);
            holder.hightemp.setText(infos.get(position).hightemp);
            holder.lowtemp.setText(infos.get(position).lowtemp);
            holder.type.setText(infos.get(position).type);
            holder.week.setText(infos.get(position).week);


        }


        return convertView;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            Log.e("111111111111112", "7");
            holder = new ViewHolder();
            convertView = minflater.inflate(R.layout.list_items, null);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.fengli = (TextView) convertView.findViewById(R.id.fengli);
            holder.fengxiang = (TextView) convertView.findViewById(R.id.fengxiang);
            holder.hightemp = (TextView) convertView.findViewById(R.id.hightemp);
            holder.lowtemp = (TextView) convertView.findViewById(R.id.lowtemp);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.week = (TextView) convertView.findViewById(R.id.week);
            convertView.setTag(holder);
        } else {
            Log.e("111111111111112", "8");
            holder = (ViewHolder) convertView.getTag();
        }
         holder.date.setText(infos.get(position).date);
        holder.fengli.setText(infos.get(position).fengli);
        holder.fengxiang.setText(infos.get(position).fengxiang);
        holder.hightemp.setText(infos.get(position).hightemp);
        holder.lowtemp.setText(infos.get(position).lowtemp);
        holder.type.setText(infos.get(position).type);
        holder.week.setText(infos.get(position).week);


        return convertView;
    }

    public final class ViewHolder {//控件管理者
        private TextView date, fengli, fengxiang, hightemp, lowtemp, type, week;


    }


}
