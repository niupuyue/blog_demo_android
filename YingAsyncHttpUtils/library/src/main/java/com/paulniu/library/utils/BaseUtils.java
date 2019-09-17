package com.paulniu.library.utils;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;

import com.paulniu.library.LibrariesCons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/**
 * Coder: niupuyue
 * Date: 2019/9/17
 * Time: 18:12
 * Desc:
 * Version:
 */
public class BaseUtils {

    /**
     * @return 获取UUID
     */
    public static String getUUID() {
        String uuID = "";

        try {
            uuID = getLocalUUID();
            if (TextUtils.isEmpty(uuID)) {
                // 如果有READ_PHONE_STATE权限,则获取 UUID, 否则生成的唯一码
                String[] arrRequestPermission = PermissionUtils.getRequestPermission(Manifest.permission.READ_PHONE_STATE);
                if (arrRequestPermission == null || arrRequestPermission.length < 1) {
                    uuID = BaseUtils.getUUID(LibrariesCons.getContext());
                } else {
                    uuID = getAppOnlySign(LibrariesCons.getContext());
                }

                setLocalUUID(uuID);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return uuID;
    }

    /**
     * 获取UUID
     */
    private static String getUUID(Context mContext) {
        String uniqueId;

        try {
            TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);

            String tmDevice, tmSerial, androidId;
            tmDevice = "" + tm.getDeviceId();
            tmSerial = "" + tm.getSimSerialNumber();
            androidId = "" + android.provider.Settings.Secure.getString(mContext.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

            UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
            uniqueId = deviceUuid.toString();
        } catch (Exception ex) {
            uniqueId = "";
        }

        return uniqueId;
    }

    /**
     * 优先读sd卡的uuid，其次读Preferences
     */
    public static String getLocalUUID() {

        String uuid = "";

        try {
            // 如果有读sd卡的权限，则优先读sd卡中的uuid
            final String[] arrRequestPermission = PermissionUtils.getRequestPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            if (arrRequestPermission == null || arrRequestPermission.length < 1) {

                File file = new File(PermissionUtils.uuidDefaultPath);
                if (file.exists()) {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String readline;
                    StringBuffer sb = new StringBuffer();
                    while ((readline = br.readLine()) != null) {
                        sb.append(readline);
                    }
                    br.close();

                    if (sb != null && !TextUtils.isEmpty(sb.toString())) {
                        uuid = new String(Base64.decode(sb.toString(), Base64.NO_PADDING));

                        // 如果解密字符串中没有'-'，代表解密失败
                        if (uuid.indexOf("-") != -1) {
                            uuid = "";
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (TextUtils.isEmpty(uuid)) {
            uuid = SharedUtils.readString(SharedUtils.string_app_uuid);
        }

        return uuid;
    }

    /**
     * 分别写入sd卡和Preferences
     */
    private static void setLocalUUID(String uuid) {
        try {
            // 如果有写入权限，并且sd卡允许读写   就写到sd中
            final String[] arrRequestPermission = PermissionUtils.getRequestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if ((arrRequestPermission == null || arrRequestPermission.length < 1) && Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED)) {
                File file = new File(PermissionUtils.uuidDefaultPath);
                FileOutputStream fos = new FileOutputStream(file);
                String info = Base64.encodeToString(uuid.getBytes(), Base64.NO_PADDING);
                fos.write(info.getBytes());
                fos.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SharedUtils.writeString(SharedUtils.string_app_uuid, uuid);
    }

    /**
     * 获取app唯一码
     */
    public synchronized static String getAppOnlySign(Context context) {
        String sign;

        File installation = new File(context.getFilesDir(), "INSTALLATION");
        try {
            if (!installation.exists()) {
                writeInstallationFile(installation);
            }

            sign = readInstallationFile(installation);
        } catch (Exception e) {
            e.printStackTrace();
            sign = "";
        }

        return sign;
    }

    private static String readInstallationFile(File installation) throws IOException {
        RandomAccessFile f = new RandomAccessFile(installation, "r");
        byte[] bytes = new byte[(int) f.length()];
        f.readFully(bytes);
        f.close();
        return new String(bytes);
    }

    private static void writeInstallationFile(File installation) throws IOException {
        FileOutputStream out = new FileOutputStream(installation);
        String id = UUID.randomUUID().toString();
        out.write(id.getBytes());
        out.close();
    }

    /**
     * 当前网络连接是否可用
     */
    public static boolean isNetworkAvailable() {

        boolean isAvailable;

        try {
            ConnectivityManager cm = (ConnectivityManager) LibrariesCons.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

            if (cm == null) {
                isAvailable = false;
            } else {
                isAvailable = cm.getActiveNetworkInfo().isAvailable();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            isAvailable = false;
        }

        return isAvailable;
    }

}
