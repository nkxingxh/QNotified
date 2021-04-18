/*
 * QNotified - An Xposed module for QQ/TIM
 * Copyright (C) 2019-2021 dmca@ioctl.cc
 * https://github.com/ferredoxin/QNotified
 *
 * This software is non-free but opensource software: you can redistribute it
 * and/or modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either
 * version 3 of the License, or any later version and our eula as published
 * by ferredoxin.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * and eula along with this software.  If not, see
 * <https://www.gnu.org/licenses/>
 * <https://github.com/ferredoxin/QNotified/blob/master/LICENSE.md>.
 */
package nil.nadph.qnotified.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import nil.nadph.qnotified.util.Initiator;

public class IsolatedLayoutSaveState extends View.BaseSavedState {

    public static final Parcelable.Creator<IsolatedLayoutSaveState> CREATOR
        = new Creator<IsolatedLayoutSaveState>() {
        @Override
        public IsolatedLayoutSaveState createFromParcel(Parcel source) {
            return new IsolatedLayoutSaveState(source);
        }

        @Override
        public IsolatedLayoutSaveState[] newArray(int size) {
            return new IsolatedLayoutSaveState[size];
        }
    };

    public final SparseArray<Parcelable> childStates;

    public IsolatedLayoutSaveState(Parcel source) {
        super(source);
        childStates = source.readSparseArray(Initiator.getPluginClassLoader());
    }

    public IsolatedLayoutSaveState(Parcelable superState) {
        super(superState);
        childStates = new SparseArray<>();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeSparseArray(childStates);
    }
}
