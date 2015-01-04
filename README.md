AndroidKioskMode
================

Library for handling Kiosk Mode in your Android Application. It restricts device to be using only one activity whitout possiblity to switch to other app.

Features:
---------

* Run activity of you choice in kiosk mode
* Blocks every application from going into foreground with activity manager (soon: support for whitelisted apps)
* Handles home button by being a Launcher App
* Work from API level 11

Todo:
-----

* whitelisting apps that can be run in kiosk mode (example opening camera)
* multiactivity within one app support


How to Use:
-----------

1. Extend your activity from KioskActivity
2. Add your activity declaraction in AndroidManifest.xml in following manner:

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
intent filter is for handling home button. Remember to set stateNotNeeded, launchMode and enabled properties as in example above. Activity has to be disabled in order to default launcher to work propely. 
3. Start activity with call KioskActivity.startKioskActivity().
4. After first launch of activity press home button and choose your app to handle home button. After you switch off activity default launcher is taking over.

Acknowledgments:
----------------

Thanks to Clifford answer at [stackoverflow](http://stackoverflow.com/questions/14233304/develop-app-run-in-kiosk-mode-in-android)

License:
-------

AndroidKioskMode for Android

Copyright (c) 2014 Wro Claw Studio SC

https://github.com/jszczygiel/AndroidKioskMode

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions
of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
IN THE SOFTWARE.