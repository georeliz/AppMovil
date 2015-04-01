package software2.appmovil.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import software2.appmovil.R;
import software2.appmovil.models.DrawerMenuItem;
/**
 * Created by Gerson de Leon on 24/03/2015.
 */
public class DrawerMenuAdapter  extends BaseAdapter{
    List<DrawerMenuItem> menuItems;
    Context mContext;

    public DrawerMenuAdapter(Context context,List<DrawerMenuItem> menuItems) {
        this.menuItems = menuItems;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_menu, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.img_drawer_menu_item_icon);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_drawer_menu_item_text);

        DrawerMenuItem item = menuItems.get(position);

        imgIcon.setImageResource(item.getmIcon());
        tvTitle.setText(item.getmText());

        return convertView;
    }

}
