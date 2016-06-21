package com.example.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.HttpGet;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;


/**
 * This is a common class for used every where.
 *
 * @author Mayank
 * @since 1.4
 */
@SuppressWarnings("ResourceType")
public class Utils {
    public static final String IS_SOCIAL_REGISTER = "Register";
    public static final String SOCIAL_IS_REGISTER_TYPE = "RegisterType";
    public static final String SOCIAL_PROVIDER = "SocialProvider";
    public static final String IS_SOCIAL_LOGIN = "SocialType";
    public static final String TAG = "SelfieSoapBox";
    public static final String APP_PREFS = "app_prefs";
    public static final String APP_PREFS_NOTIFICATION_KEY = "app_prefs_notification";
    public static final String NOTIFICATION_KEY = "notification_key";
    public static final String ACCESS_KEY = "access_key";
    public static final String ACCESS_KEY_NOT_FOUND = "access_key_not_defined";
    public static final String USER_KEY = "user_key";
    public static final String USER_KEY_NOT_FOUND = "user_key_not_defined";
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public static final String IMAGE_DIRECTORY_NAME = "SelfieSoapBox";
    public static final int MEDIA_TYPE_AUDIO = 3;
    public static final String root = "/mnt/sdcard/Android/data";
    public static final String TWITTER_KEY = "AkTtbcE1eWxaGyZQ0FMCPFNZq";
    public static final String TWITTER_SECRET = "HBq1KNV4Yrh29uzx60uRgR1LGGYtD5pbnlcOIjwHyH1dOFiK3W";
    private static final float BLUR_RADIUS = 25f;
    public static String PREFS_FILE_NAME = "Flipped";
    public static ProgressDialog loadingDialogGlobal;
    public static Uri fileUri;
    static SharedPreferences prefs;
    static String msg = "";
    private static File audioFolder;
    private static File videoFolder;
    private static File imageFolder;

    public static String PREFS_LOGIN = "pref_login";
    public static String PREFS_USER_ID = "pref_user_id";
    public static String RESPOSIBILITY = "responsibility";

    /**
     * save API access key from here
     *
     * @param access_key value of the access key
     * @param context
     */
    public static void setAPIAccessKey(String access_key, Context context) {
        SharedPreferences prefs;
        prefs = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ACCESS_KEY, access_key);
        editor.commit();
    }

    /**
     * check EditText is empty or not
     *
     * @param edText pass EditText for check is empty or not
     * @return true or false
     */
    public static boolean isEmptyEditText(EditText edText) {
        if (edText.getText().toString().trim().length() > 0)
            return false;
        else
            return true;
    }


    /**
     * set custom fonts for custom text changes
     *
     * @param mContext
     * @param mTextView for set the font face
     * @param font      font for the set text
     */
    public static void setCustomFontStyle(Context mContext, TextView mTextView, String font) {
        try {
            Typeface face = Typeface.createFromAsset(mContext.getAssets(), "fonts/" + font + ".ttf");
            mTextView.setTypeface(face);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set font face to the edittext
     *
     * @param mContext
     * @param mEditText
     */
    public static void setTypeface(Context mContext, EditText mEditText) {
        Typeface face = Typeface.createFromAsset(mContext.getAssets(), "SEGOEUIL.ttf");
        mEditText.setTypeface(face);
    }

    // -----------------------------------------------

    /**
     * set font face to the TextView
     *
     * @param mContext
     * @param mTextView
     */
    public static void setTypeface(Context mContext, TextView mTextView) {
        Typeface face = Typeface.createFromAsset(mContext.getAssets(), "SEGOEUIL.ttf");
        mTextView.setTypeface(face);
    }

    // -----------------------------------------------

    /**
     * set font face to the button
     *
     * @param mContext
     * @param mbButton
     */
    public static void setTypeface(Context mContext, Button mbButton) {
        Typeface face = Typeface.createFromAsset(mContext.getAssets(), "SEGOEUIL.ttf");
        mbButton.setTypeface(face);
    }

    // -----------------------------------------------

    /**
     * Get the access key from shared preferences
     *
     * @param context application context
     * @return access key
     */
    public static String getAPIAccessKey(Context context) {
        SharedPreferences prefs;
        prefs = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(ACCESS_KEY, ACCESS_KEY_NOT_FOUND);
//        return "58623a74e11d56d61a2ee098fe993d1754e5a5fc737b7";
    }

    /**
     * Set the user key on shared preferences
     *
     * @param context application context
     */
    public static void setUserAccessKey(String user_key, Context context) {
        SharedPreferences prefs;
        prefs = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_KEY, user_key);
        editor.commit();
    }

    /**
     * Get the user key from shared preferences
     *
     * @param context application context
     * @return user key
     */
    public static String getUserAccessKey(Context context) {
        SharedPreferences prefs;
        prefs = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return prefs.getString(USER_KEY, USER_KEY_NOT_FOUND);

//        return "f0cec1614a73303267f22ce6050ee09954e5dcb8c0c7a";
    }

    /**
     * set String Preference Value
     *
     * @param context
     * @param prefName Preference name
     * @param Value    Preference value
     */
    public static void setPrefrencesString(Context context, String prefName, String Value) {
        System.out.println("value:" + Value + ":" + prefName);
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(prefName, Value);
        editor.commit();
    }

    /**
     * get String Preference Value
     *
     * @param context
     * @param prefName
     * @return
     */
    public static String getPrefrencesString(Context context, String prefName) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        if (prefs.contains(prefName))
            return prefs.getString(prefName, "");
        else
            return "";
    }

    /**
     * set Integer Preference Value
     *
     * @param context
     * @param prefName
     * @param Value
     */
    public static void setPrefrencesInteger(Context context, String prefName, int Value) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(prefName, Value);
        editor.commit();
    }

    /**
     * get Integer Preference Value
     *
     * @param context
     * @param prefName
     * @return
     */
    public static int getPrefrencesInteger(Context context, String prefName) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getInt(prefName, 0);
    }

    /**
     * remove all the preferences of your app. Note: only remove all which set
     * by using this sdk.
     *
     * @param context
     */
    public static void clearAllPrefrencesData(Context context) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * Network operations of HttpClient
     *
     * @param serverUrl
     * @return
     */
    public static String NetworkOperation(String serverUrl) {
        String result = null;
        JSONObject jsonResult;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(serverUrl);
//            System.out.println("Link: " + serverUrl);
            HttpResponse response = client.execute(get);
            HttpEntity resp_entity = response.getEntity();
            result = EntityUtils.toString(resp_entity);

            if (response.getStatusLine().getStatusCode() != 200) {
                jsonResult = new JSONObject();
                jsonResult.put("response_code", "9999");
                jsonResult.put("response_message", "Server error occurred while processing request. Please try again.");
                result = jsonResult.toString();
                return result;
            }
        } catch (Exception e) {
            try {
                jsonResult = new JSONObject();
                jsonResult.put("response_code", "9999");
                jsonResult.put("response_message", "Server error occurred while processing request. Please try again.");
                result = jsonResult.toString();
                return result;
            } catch (JSONException jsone) {
            }
        }
        return result;
    }

    /**
     * save notification key for the notification in preference
     *
     * @param access_key
     * @param context
     */
    public static void setNotificationKey(String access_key, Context context) {
        SharedPreferences prefs;
        prefs = context.getSharedPreferences(APP_PREFS_NOTIFICATION_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(NOTIFICATION_KEY, access_key);
        editor.commit();
    }

    /**
     * get saved notification key from preference
     *
     * @param context
     * @return
     */
    public static String getNotificationKey(Context context) {
        SharedPreferences prefs;
        prefs = context.getSharedPreferences(APP_PREFS_NOTIFICATION_KEY, Context.MODE_PRIVATE);
        return prefs.getString(NOTIFICATION_KEY, null);
    }

    /**
     * Checks whether network (WIFI/mobile) is available or not.
     *
     * @param context application context.
     * @return true if network available,false otherwise.
     */
    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    /**
     * check the email address is valid or not.
     *
     * @param email pass email id in string
     * @return true when its valid otherwise false
     */
    public static boolean isEmailIdValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }

    /**
     * get unique id
     *
     * @param context
     * @return
     */
    public static String getUniqueId(Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId;
    }


//    Sanjay Added methods for image and video capture or pick from gallery 18/2/2015

    /**
     * get device id
     *
     * @param context
     * @return
     */
    public static String getDeviceID(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    /**
     * show no internet available dialog
     *
     * @param mContext
     */
    public static void ShowNoInternetDialog(final Context mContext) {
        new AlertDialog.Builder(mContext, AlertDialog.THEME_HOLO_LIGHT)
                .setMessage("No internet available.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mContext.startActivity(new Intent(Settings.ACTION_SETTINGS));
                    }
                }).create().show();
    }


    /**
     * for close the keyboard
     *
     * @param mContext
     * @param v
     */
    public static void closeKeyboard(Context mContext, View v) {
        InputMethodManager inputManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void showGlobalLoading(Context mContext) {
        // TODO Auto-generated method stub
        loadingDialogGlobal = new ProgressDialog(mContext, ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
        loadingDialogGlobal.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingDialogGlobal.setMessage("Loading...");
        loadingDialogGlobal.setCancelable(false);
        loadingDialogGlobal.setCanceledOnTouchOutside(false);
        loadingDialogGlobal.show();
    }

    /**
     * Captures image in Common Directory
     *
     * @param mContext
     * @param CAMERA_CAPTURE_IMAGE_REQUEST_CODE
     * @param camera
     */
    public static void captureImage(Context mContext, int CAMERA_CAPTURE_IMAGE_REQUEST_CODE, String camera) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        if (camera.equalsIgnoreCase("Front")) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", Camera.CameraInfo.CAMERA_FACING_FRONT);
        } else if (camera.equalsIgnoreCase("Back")) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", Camera.CameraInfo.CAMERA_FACING_BACK);
        }

        ((Activity) mContext).startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }

    /**
     * get URI of the file
     *
     * @param type
     * @return
     */
    public static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * get the media file from directory
     *
     * @param type
     * @return
     */
    public static File getOutputMediaFile(int type) {
        // External sdcard location
        createFolderDirectory();
//        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), IMAGE_DIRECTORY_NAME);
//        // Create the storage directory if it does not exist
//        if (!mediaStorageDir.exists()) {
//            if (!mediaStorageDir.mkdirs()) {
//                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
//                        + IMAGE_DIRECTORY_NAME + " directory");
//                return null;
//            }
//        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CANADA).format(new Date());
        File mediaFile;
        /*if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(imageFolder.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(videoFolder.getPath() + File.separator + "VID_" + timeStamp + ".mp4");
        } else if (type == MEDIA_TYPE_AUDIO) {
            mediaFile = new File(audioFolder.getPath() + File.separator + "AUD_" + timeStamp + ".mp3");
        } else {
            return null;
        }*/
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(imageFolder.getPath() + File.separator + "IMG_" + "soapbox" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(videoFolder.getPath() + File.separator + "VID_" + "soapbox" + timeStamp + ".mp4");
        } else if (type == MEDIA_TYPE_AUDIO) {
            mediaFile = new File(audioFolder.getPath() + File.separator + "AUD_" + "soapbox" + timeStamp + ".mp3");
        } else {
            return null;
        }
        System.out.println("mediafile :" + mediaFile);
        return mediaFile;
    }

    /**
     * create folder directory to the application package
     */
    public static void createFolderDirectory() {
        // root/ pkg/ type/ lang/ gender/

        File packageFolder = createFolder(root, "bluefusion.selfie.socialrating");
        createFolder(packageFolder.getPath(), IMAGE_DIRECTORY_NAME);
        audioFolder = createFolder(root + "/bluefusion.selfie.socialrating/" + IMAGE_DIRECTORY_NAME, "audio");
        videoFolder = createFolder(root + "/bluefusion.selfie.socialrating/" + IMAGE_DIRECTORY_NAME, "video");
        imageFolder = createFolder(root + "/bluefusion.selfie.socialrating/" + IMAGE_DIRECTORY_NAME, "images");
        System.out.println("file directory created...");
    }

    /**
     * create folder to the path
     *
     * @param path       path fot the creating folder
     * @param folderName folcer name for creating
     * @return
     */
    public static File createFolder(String path, String folderName) {
        File SDCardRoot = new File(path, folderName);
        if (!SDCardRoot.exists()) {
            SDCardRoot.mkdir();
        }
        return SDCardRoot;
    }

    /**
     * pic images using intent call
     *
     * @param mContext
     * @param CAMERA_PICK_IMAGE_REQUEST_CODE
     */
    public static void pickImage(Context mContext, int CAMERA_PICK_IMAGE_REQUEST_CODE) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        ((Activity) mContext).startActivityForResult(intent, CAMERA_PICK_IMAGE_REQUEST_CODE);
    }

    /**
     * record the video using intent by front and rear camera
     *
     * @param mContext
     * @param CAMERA_CAPTURE_VIDEO_REQUEST_CODE
     * @param camera
     */
    public static void recordVideo(Context mContext, int CAMERA_CAPTURE_VIDEO_REQUEST_CODE, String camera) {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 60);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        if (camera.equalsIgnoreCase("Front")) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", Camera.CameraInfo.CAMERA_FACING_FRONT);
        } else if (camera.equalsIgnoreCase("Back")) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", Camera.CameraInfo.CAMERA_FACING_BACK);
        }
        ((Activity) mContext).startActivityForResult(intent, CAMERA_CAPTURE_VIDEO_REQUEST_CODE);
    }

    /**
     * pic the video file from the directory using intent
     *
     * @param mContext
     * @param CAMERA_PICK_VIDEO_REQUEST_CODE
     */
    public static void pickVideo(Context mContext, int CAMERA_PICK_VIDEO_REQUEST_CODE) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("video/*");
        ((Activity) mContext).startActivityForResult(intent, CAMERA_PICK_VIDEO_REQUEST_CODE);
    }


    /**
     * get image URL from the URI
     *
     * @param context
     * @param uri
     * @return
     */
    public static Uri getImageUrlWithAuthority(Context context, Uri uri) {
        InputStream is = null;
        if (uri.getAuthority() != null) {
            try {
                is = context.getContentResolver().openInputStream(uri);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                return writeToTempImageAndGetPathUri(context, bmp);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * write temp image to storage and get path URI
     *
     * @param inContext
     * @param inImage
     * @return
     */
    public static Uri writeToTempImageAndGetPathUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.PNG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    /**
     * getpath of picked image or video
     *
     * @param context
     * @param uri
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }

            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {

            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();

            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /**
     * Function to display simple Alert Dialog or Toast
     *
     * @param context - application context
     * @param title   - alert dialog title
     * @param message - alert message
     * @param toast   - show as toast or dialog
     */
    public static void showAlertDialog(Context context, String title, String message, boolean toast) {
        if (message.length() == 0) {
            message = "Something went wrong. Please try again.";
        }
        if (!(message.endsWith(".") || (message.endsWith("!"))))
            message += ".";
        if (toast) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        } else {

            AlertDialog alertDialog = null;
            if (!((Activity) context).isFinishing()) {
                if (alertDialog == null)
                    alertDialog = new AlertDialog.Builder(context).create();
                // Setting Dialog Title
                alertDialog.setTitle(title);
                // Setting Dialog Message
                alertDialog.setMessage(message);
                // Setting OK Button
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // Showing Alert Message
                alertDialog.show();
            }
        }
    }

    /**
     * use for getting device height
     *
     * @param mContext
     * @return height of your device
     */
    public static int getDeviceHeight(Context mContext) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay()
                .getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    /**
     * use for getting device width
     *
     * @param mContext
     * @return width of your device
     */
    public static int getDeviceWidth(Context mContext) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay()
                .getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    /**
     * hide the hard keyboard on view click
     *
     * @param mContext
     * @param v
     */
    public static void hideKeyboard(Context mContext, View v) {
        // TODO Auto-generated method stub
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static boolean isWebsiteUrlValid(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }

    /**
     * set login type
     *
     * @param mContext
     * @param string
     */
//    public static void setLoginStatus(Context mContext, String string) {
//        setPrefrencesBoolean(mContext, mContext.getResources().getString(R.string.pref_is_login_selfie), false);
//        setPrefrencesBoolean(mContext, mContext.getResources().getString(R.string.pref_is_login_google), false);
//        setPrefrencesBoolean(mContext, mContext.getResources().getString(R.string.pref_is_login_facebook), false);
//        setPrefrencesBoolean(mContext, mContext.getResources().getString(R.string.pref_is_login_twitter), false);
//
//        if (string.equals(mContext.getResources().getString(R.string.pref_is_login_selfie))) {
//            setPrefrencesBoolean(mContext, mContext.getResources().getString(R.string.pref_is_login_selfie), true);
//        } else if (string.equals(mContext.getResources().getString(R.string.pref_is_login_google))) {
//            setPrefrencesBoolean(mContext, mContext.getResources().getString(R.string.pref_is_login_google), true);
//        } else if (string.equals(mContext.getResources().getString(R.string.pref_is_login_facebook))) {
//            setPrefrencesBoolean(mContext, mContext.getResources().getString(R.string.pref_is_login_facebook), true);
//        } else if (string.equals(mContext.getResources().getString(R.string.pref_is_login_twitter))) {
//            setPrefrencesBoolean(mContext, mContext.getResources().getString(R.string.pref_is_login_twitter), true);
//        }
//    }

    /**
     * set Boolean Preference Value
     *
     * @param context
     * @param prefName
     * @param Value
     */
    public static void setPrefrencesBoolean(Context context, String prefName, Boolean Value) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(prefName, Value);
        editor.commit();
    }

    /**
     * get Boolean Preference Value
     *
     * @param context
     * @param prefName
     * @return
     */
    public static boolean getPrefrencesBoolean(Context context, String prefName) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(prefName, false);
    }

    /**
     * get Name and Email details from the contact
     *
     * @param context
     * @return
     */
    public static ArrayList<String> getNameEmailDetails(Context context) {
        ArrayList<String> emlRecs = new ArrayList<String>();
        HashSet<String> emlRecsHS = new HashSet<String>();
        ContentResolver cr = context.getContentResolver();
        String[] PROJECTION = new String[]{ContactsContract.RawContacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.PHOTO_ID,
                ContactsContract.CommonDataKinds.Email.DATA,
                ContactsContract.CommonDataKinds.Photo.CONTACT_ID};
        String order = "CASE WHEN "
                + ContactsContract.Contacts.DISPLAY_NAME
                + " NOT LIKE '%@%' THEN 1 ELSE 2 END, "
                + ContactsContract.Contacts.DISPLAY_NAME
                + ", "
                + ContactsContract.CommonDataKinds.Email.DATA
                + " COLLATE NOCASE";
        String filter = ContactsContract.CommonDataKinds.Email.DATA + " NOT LIKE ''";
        Cursor cur = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, PROJECTION, filter, null, order);
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    // names comes in hand sometimes
                    String name = cur.getString(1);
                    String emlAddr = cur.getString(3);

                    // keep unique only
                    if (emlRecsHS.add(emlAddr.toLowerCase())) {
                        emlRecs.add(name + ", " + emlAddr);
                    }
                } while (cur.moveToNext());
            }
            cur.close();
        }
        return emlRecs;
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    //----------------------------------Methods for Set Previews------------------------------------
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    /**
     * use to show datepicker
     *
     * @param mContext
     * @param format    of the date format
     * @param mTextView in which you have to set selected date
     */
    public static void showDatePickerDialog(final Context mContext, final String format, final TextView mTextView) {

        final Calendar dateTime = Calendar.getInstance();

        new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

//                SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
                dateTime.set(year, monthOfYear, dayOfMonth);

                String dateText = dayOfMonth + "-" + monthOfYear + "-" + year + " " + dateTime.get(Calendar.HOUR) + ":" + new DecimalFormat("#0").format(dateTime.get(Calendar.MINUTE));
                mTextView.setText(dateText);

                new DecimalFormat("#0").format(dateTime.get(Calendar.MINUTE));
            }
        }, dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH),
                dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    /**
     * get the Hash Key signature
     *
     * @param context
     * @return
     */
    public static String printKeyHash(Activity context) {
        PackageInfo packageInfo;
        String key = null;
        try {
            //getting application package name, as defined in manifest
            String packageName = context.getApplicationContext().getPackageName();

            //Retriving package info
            packageInfo = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES);

            Log.e("Package Name=", context.getApplicationContext().getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));

                // String key = new String(Base64.encodeBytes(md.digest()));
                Log.e("Key Hash=", key);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("Name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        return key;
    }


    /**
     * create byte array of thumb
     *
     * @param d
     * @return
     */
    public static byte[] CreateAudioThumb(Drawable d) {
        Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }

    /**
     * get video length in mb from sdcard
     *
     * @param videoPath
     * @return
     */
    public static long getVideoSize(String videoPath) {
        long size = 0;
        try {
            File file = new File(videoPath);
            long length = file.length();
            size = length / 1024;
        } catch (Exception e) {
            System.out.println("File not found :" + e.getMessage() + e);
        }
        return size;
    }

    /**
     * get application messages by parameter
     *
     * @param param
     * @param context
     * @return
     */
    public static String getMessages(Context context, String param) {
        String message = "";
        JSONObject jobM = null;
        try {
            String msgObj = Utils.getPrefrencesString(context, "prefMessages");
            jobM = new JSONObject(msgObj);
            message = jobM.getJSONObject("messageData").getString(param);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (message.trim().length() > 0) {
            return message;
        } else {
            Utils.setPrefrencesString(context, "prefMessages", "{\"messageData\":{\"SMALL TEST\":\"test message.\",\"EMAILINVALID\":\"Email is invalid.\",\"ALLFIELDSREQUIRED\":\"All fields are required.\",\"RESETPASSLINKSEND\":\"A password reset link has been sent to your email.\",\"EMAILISREQUIRED\":\"Email is required.\",\"CONFIRMNEWPASSWORDNOTMATCHED\":\"New password and re-typed password do not match.\",\"BUSINESSNAMEREQUIRED\":\"Business name is required.\",\"ERRORSMALLPASSWORD\":\"Password is too small.\",\"ACCOUNTEMAILREQUIRED\":\"Accounts payable email is required.\",\"POSTALCODEREQUIRED\":\"Postal code is required.\",\"ADDRESSREQUIRED\":\"Address is required.\",\"PHONENUMBERREQUIRED\":\"Phone number is required.\",\"DEALERNUMBERREQUIRED\":\"Dealer registration number is required.\",\"TAXNUMBERREQUIRED\":\"Tax number is required.\",\"PASSWORDISREQUIRED\":\"Password is required.\",\"ACCOUNTEMAMILINVALID\":\"Account email is invalid.\",\"RECONFIRMEMAILREQUIRED\":\"Reconfirm email is required.\",\"POSTALCODEISTOOSMALL\":\"Postal code is too small.\",\"RECONFIRMPASSWORDNOTMATCH\":\"Reconfirm email not match with email.\",\"SELECTREPRESENTINGBRAND\":\"Please select representing brand.\",\"NONETWORKAVAILABLE\":\"No network available!\",\"INVALIDVINCODE\":\"Enter valid VIN barcode.\",\"VINREQUIRED\":\"VIN barcode is required.\",\"SELECTMAKE\":\"Please select vehicle's make.\",\"SELECTYEAR\":\"Please select vehicle's year.\",\"SELECTMODEL\":\"Please select vehicle's model.\",\"SELECTSUBMODEL\":\"Please select vehicle's submodel.\",\"SELECTMILEGE\":\"Please enter vehicle's mileage.\",\"SELECTFUELTYPE\":\"Please select vehicle's fuel type.\",\"SELECTTRANSMISSION\":\"Please select vehicle's transmission.\",\"SELECTDRIVETRAIN\":\"Please select vehicle's drive train.\",\"SELECTCYLINDERS\":\"Please select vehicle's cylinders.\",\"SELECTINTERIORCOLOR\":\"Please select vehicle's Interior colour.\",\"SELECTINTERIORMATERIAL\":\"Please select vehicle's interior material.\",\"SELECTEXTERIORCOLOR\":\"Please select vehicle's exterior colour.\",\"ADDVEHICLEIMAGE\":\"Please select vehicle images.\",\"ADDVEHICLEVIDEO\":\"Please select vehicle video.\",\"SELECTLISTING\":\"Please select listing type.\",\"SELECTTYPE\":\"Please select inventory type.\",\"SELECTARRIVINGDATE\":\"Please select arriving date.\",\"SELECTRETAILMARKUP\":\"Please enter retail markup.\",\"SELECTRESERVEPRICE\":\"Please enter reserve price.\",\"SELECTAUCTIONLENGTH\":\"Please select auction length.\",\"SELECTBIDINCREMENT\":\"Please select BID increment.\",\"ISEXIST\":\"Is data exist.\",\"ZIPCODEREQUIRED\":\"Zip code is required.\",\"ZIPCODEISTOOSMALL\":\"Zip code is too small.\",\"VALIDCARPROOFURL\":\"Please enter valid carproof URL.\",\"SELECTTIRES\":\"Please select needed tires.\",\"VEHICLEDATASAVED\":\"Vehicle data is saved in draft.\",\"SELECTENGINESIZE\":\"Please select engine size.\",\"RECIVINGPREVALICLEDATA\":\"Retrieving vehicle data...\",\"PUBLISHVEHICLE\":\"Publishing vehicle...\",\"DESCRIPTIONREQUIRED\":\"Description is required.\",\"ENGINESIZEREQUIRED\":\"Engine size is required.\"},\"response_code\":1111}");
            try {
                String msgObj = Utils.getPrefrencesString(context, "prefMessages");
                jobM = new JSONObject(msgObj);
                message = jobM.getJSONObject("messageData").getString(param);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (message.trim().length() > 0)
                return message;
            else
                return "Something went wrong! Please try again.";
        }
    }


    /**
     * for check string is url or not
     *
     * @param stringURL
     * @return
     */
    public static boolean isUrlValid(String stringURL) {
//        String URL_REGEX = "^((https?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$";
//
//        Pattern p = Pattern.compile(URL_REGEX);
//        Matcher m = p.matcher(stringURL);//replace with string to compare
//        if (m.find()) {
        if (URLUtil.isValidUrl(stringURL)) {
            System.out.println("String contains URL");
            return true;
        } else {
            return false;
        }
    }

//    public static int getActionBarHeight(Context context) {
//        int actionBarHeight = 0;
//        TypedValue tv = new TypedValue();
//        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
//                actionBarHeight = TypedValue.complexToDimensionPixelSize(
//                        tv.data, context.getResources().getDisplayMetrics());
//            }
//        } else {
//            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,
//                    context.getResources().getDisplayMetrics());
//        }
////        System.out.println("actionbar height1:" + actionBarHeight + ":" + Math.round(actionBarHeight / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)));
////        actionBarHeight = Math.round(actionBarHeight / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
////        System.out.println("actionbar height2:" + actionBarHeight);
////        actionBarHeight = (int) (actionBarHeight * 1.25);
////        System.out.println("final actionbar height:" + actionBarHeight);
////        actionBarHeight = actionBarHeight / 2;
//        actionBarHeight = context.getResources().getDimensionPixelSize(R.dimen.actionbar_icon_height);
//        return actionBarHeight;
//    }

    /**
     * get actionbar heignt
     *
     * @param context
     * @return
     */
    public static int getActionBarHeight(Context context) {
        final TypedArray ta = context.getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize});
        int actionBarHeight = (int) ta.getDimension(0, 0);
        System.out.println("actionbar height:" + actionBarHeight);
        actionBarHeight = actionBarHeight / 2;
        return actionBarHeight;
    }

    /**
     * change icon colors
     *
     * @param mDrawable
     * @param color
     * @return
     */
    public static Drawable setIconColor(Drawable mDrawable, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(mDrawable);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

//    ivHome.setImageDrawable(PrefUtils.setIconColor(getResources().getDrawable(R.drawable.home), Color.BLACK));
}