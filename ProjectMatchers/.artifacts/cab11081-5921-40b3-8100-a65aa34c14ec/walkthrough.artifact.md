# Walkthrough - Fixing SecurityException (Missing INTERNET permission)

I have resolved the `java.lang.SecurityException: Permission denied` error by adding the required `INTERNET` permission to the application's manifest.

## Changes Made

### Android Manifest
#### [MODIFY] [AndroidManifest.xml](file:///E:/WorkSpace/DatingAppAi/ProjectMatchers/app/src/main/AndroidManifest.xml)
- Added `<uses-permission android:name="android.permission.INTERNET" />` to allow the application to perform network operations.

## Verification Results

### Automated Tests
- Ran `gradlew app:assembleDebug` to ensure the project still builds correctly with the manifest change.
- **Status**: Build finished successfully.

### Manual Verification
- The user should now be able to run the application without encountering the `SecurityException` during host lookups or network requests.
