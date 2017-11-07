package com.example.oneuse.filmpopuler.features.main.main.model;

import com.example.oneuse.filmpopuler.R;

/**
 * Created by ONEUSE on 24/10/2017.
 */

public class HeaderItem implements MainItem {

    public final String headerTitle;

    public HeaderItem(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    @Override
    public int getType() {
        return R.layout.main_header_item;
    }

    @Override
    public int getItemSize() {
        return 2;
    }
}