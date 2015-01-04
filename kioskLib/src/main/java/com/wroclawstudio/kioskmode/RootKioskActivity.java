package com.wroclawstudio.kioskmode;

import android.content.ComponentName;
import android.content.pm.PackageManager;

/**
 * Created by jakubszczygiel on 04/01/15.
 */
public class RootKioskActivity extends KioskActivity {
    @Override
    protected void onDestroy() {
        ComponentName cn = new ComponentName(getPackageName(), this.getClass().getName());
        getPackageManager().setComponentEnabledSetting(cn, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        super.onDestroy();
    }
}
