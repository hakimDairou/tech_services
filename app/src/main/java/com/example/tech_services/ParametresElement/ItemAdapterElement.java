
package com.example.tech_services.ParametresElement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tech_services.R;

import java.util.List;

public class ItemAdapterElement  extends ArrayAdapter<ItemElement>   {
        private LayoutInflater inflater;

        public ItemAdapterElement(Context context, List<ItemElement> itemList) {
                super(context, 0, itemList);
                inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                ViewHolder viewHolder;

                if (convertView == null) {
                        convertView = inflater.inflate(R.layout.item_icon_elementparametre, parent, false);
                        viewHolder = new ViewHolder();
                        viewHolder.iconImageView = convertView.findViewById(R.id.elementIcon);
                        viewHolder.nameTextView = convertView.findViewById(R.id.elementName);
                        convertView.setTag(viewHolder);
                } else {
                        viewHolder = (ViewHolder) convertView.getTag();
                }

                ItemElement item = getItem(position);
                viewHolder.nameTextView.setText(item.getName());
                viewHolder.iconImageView.setImageResource(item.getIconResId());

                return convertView;
        }

        private static class ViewHolder {
                ImageView iconImageView;

                TextView nameTextView;
        }
}
