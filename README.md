AndroidKioskMode
================

Library for handling Kiosk Mode in your Android Application. It restricts device to be using only one activity without possibility to switch to other app.

Features:
---------

* Run activity of you choice in kiosk mode
* Blocks every application from going into foreground with activity manager (soon: support for whitelisted apps)
* Handles home button by being a Launcher App
* Multiactivity within one app support
* Work from API level 11

Todo:
-----

* whitelisting apps that can be run in kiosk mode (example opening camera)


How to Use:
-----------

1. Extend your activity from RootKioskActivity
2. Add your activity declaration in AndroidManifest.xml in following manner:

```
  <activity
      android:name=".YourActivity"
      android:enabled="false"
      android:launchMode="singleTask"
      android:stateNotNeeded="true">
      <intent-filter>
          <action android:name="android.intent.action.MAIN" />
          <category android:name="android.intent.category.HOME" />
          <category android:name="android.intent.category.DEFAULT" />
      </intent-filter>
  </activity>
```
intent filter is for handling home button. Remember to set stateNotNeeded, launchMode and enabled properties as in example above. Activity has to be disabled in order to default launcher to work properly. 
3. Start activity with call KioskActivity.startKioskActivity().
4. After first launch of activity press home button and choose your app to handle home button. After you switch off activity default launcher is taking over.

5. If you wish to start other activities of your app while kiosk mode is enabled make sure their extend KioskModeActivity

Acknowledgments:
----------------

Thanks to Clifford answer at [stackoverflow](http://stackoverflow.com/questions/14233304/develop-app-run-in-kiosk-mode-in-android)

