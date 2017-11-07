package com.example.oneuse.filmpopuler.features.main.main.view;

import android.view.View;
import android.widget.TextView;

import com.example.oneuse.filmpopuler.R;
import com.example.oneuse.filmpopuler.features.main.main.model.HeaderItem;
import com.example.oneuse.filmpopuler.features.main.main.model.MainItem;

public class HeaderViewHolder extends BaseViewHolder {
    TextView headerField;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        headerField = itemView.findViewById(R.id.main_header_field);
    }

    @Override
    public void bindView(MainItem item) {
        final HeaderItem headerItem = (HeaderItem) item;
        headerField.setText(headerItem.getHeaderTitle());
    }
}