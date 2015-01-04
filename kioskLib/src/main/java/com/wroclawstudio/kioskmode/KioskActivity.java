package com.wroclawstudio.kioskmode;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubszczygiel on 15/11/2014.
 */
public class KioskActivity extends Activity {

    private static final String HANDLE_BACK = "HANDLE_BACK";
    private boolean handleBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleBack = getIntent().getBooleanExtra(HANDLE_BACK, false);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ActivityManager activityManager = (ActivityManager) getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<String> whiteList=new ArrayList<>();
        whiteList.add(getPackageName());
        if(!isWhiteList(activityManager,whiteList)) {
            activityManager.moveTaskToFront(getTaskId(), 0);
        }
    }

    @Override
    public void onBackPressed() {
        if (!handleBack) {
            super.onBackPressed();
        }
    }

    public static void startKioskActivity(Context context, Class kioskActivityClass) {
        startKioskActivity(context, kioskActivityClass, true);
    }

    public static void startKioskActivity(Context context, Class kioskActivityClass, boolean handleBack) {
        ComponentName cn = new ComponentName(context.getPackageName(), kioskActivityClass.getName());
        context.getPackageManager().setComponentEnabledSetting(cn, PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        Intent i = new Intent(context, kioskActivityClass);
        i.putExtra(HANDLE_BACK, handleBack);
        if (!(context instanceof Activity)) {
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(i);
    }

    public static boolean isWhiteList(ActivityManager am, ArrayList<String> whiteList) {
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        ComponentName componentInfo = taskInfo.get(0).topActivity;
        for(String item : whiteList){
            if(item.contains(componentInfo.getPackageName())){
                return true;
            }
        }
        return false;
    }
}
