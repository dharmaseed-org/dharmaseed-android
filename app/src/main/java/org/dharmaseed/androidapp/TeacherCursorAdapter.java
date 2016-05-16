/*
 *     Dharmaseed Android app
 *     Copyright (C) 2016  Brett Bethke
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.dharmaseed.androidapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TeacherCursorAdapter extends StarCursorAdapter {


    public TeacherCursorAdapter(NavigationActivity context, int layout, Cursor c) {
        super(DBManager.C.TeacherStars.TABLE_NAME, context, layout, c);
    }

    @Override
    public View newView (Context context, Cursor cursor, ViewGroup parent) {
        return inflater.inflate(layout, null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Set teacher name
        TextView title=(TextView)view.findViewById(R.id.item_view_title);
        TextView subtitle=(TextView)view.findViewById(R.id.item_view_subtitle);
        title.setText(cursor.getString(cursor.getColumnIndexOrThrow(DBManager.C.Teacher.NAME)).trim());
        subtitle.setText("");

        // Set teacher photo
        String photoFilename = DBManager.getTeacherPhotoFilename(cursor.getInt(cursor.getColumnIndexOrThrow(DBManager.C.Teacher.ID)));
        ImageView photoView = (ImageView) view.findViewById(R.id.item_view_photo);
        try {
            FileInputStream photo = context.openFileInput(photoFilename);
            photoView.setImageBitmap(BitmapFactory.decodeStream(photo));
        } catch(FileNotFoundException e) {
            Drawable icon = ContextCompat.getDrawable(context, R.drawable.dharmaseed_icon);
            photoView.setImageDrawable(icon);
        }

        // Set stars
        handleStars(view, cursor.getInt(cursor.getColumnIndexOrThrow(DBManager.C.Teacher.ID)));

    }


}
