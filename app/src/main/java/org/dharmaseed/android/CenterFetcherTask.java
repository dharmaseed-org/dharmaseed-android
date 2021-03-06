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

package org.dharmaseed.android;


/**
 * Created by bbethke on 2/19/16.
 */
public class CenterFetcherTask extends DataFetcherTask {

    public CenterFetcherTask(DBManager dbManager, NavigationActivity navigationActivity) {
        super(dbManager, navigationActivity);
    }

    @Override
    protected Void doInBackground(Void... params) {

        updateTable(DBManager.C.Center.TABLE_NAME, DBManager.C.Center.ID,
                "venues/",
                new String[]{
                        DBManager.C.Center.WEBSITE,
                        DBManager.C.Center.DESCRIPTION,
                        DBManager.C.Center.NAME,
                        DBManager.C.Center.HAS_VENUE_VIEW
                });

        publishProgress();
        return null;
    }
}
