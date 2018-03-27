package com.caches.niupule.permission_demo;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {
    /**
     * Android6.0之后将权限分为两类，一类是安全权限，另外一类是危险权限
     * 如果是安全权限，可以直接在清单配置文件中执行，如果是危险权限，则需要在java代码中，动态申请
     *
     * @param savedInstanceState
     */

    // 要申请的权限
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 动态申请获取日历权限
         */
        findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 判断当前应用是否已经获取到日历权限如果没有则申请，并且在日历中添加一个待办事宜
                 */
                //判断当前手机系统是否大于23
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //判断当前应用是否已经获取到了权限
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                        //通过弹窗获取到当前的权限
                        showDialogToGetCalendar("获取日历权限", "申请获取日历权限，陛下是否恩准");
                    }
                }
            }
        });

        /**
         * 动态获取相机权限
         */
        findViewById(R.id.btn02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 判断当前手机系统是否大于23
                 */
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    /**
                     * 判断当前应用是否已经获取到了权限,如果没有则申请
                     */
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        showDialogToGetCamera("获取相机权限", "申请获取相机权限是否同意");
                    }
                }
            }
        });

        /**
         * 动态获取联系人权限
         */
        findViewById(R.id.btn03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 判断当前手机系统是否大于23
                 */
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                    /**
                     * 判断当前应用是否已经获取到了权限，如果没有则申请
                     */
                    if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED){
                        showDialogToGetContact("获取联系人权限","申请获取联系人权限是否同意");
                    }
                }
            }
        });

    }

    /**
     * 弹窗显示是否获取联系人权限
     */
    public void showDialogToGetContact(String title,String msg){
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("不同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    /**
     * 获取联系人权限
     */
    public void awardContactPerssion(){
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS
        },3);
    }

    /**
     * 弹窗获取是否获取相机权限
     */
    public void showDialogToGetCamera(String title, String msg) {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("不同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    /**
     * 获取相机权限
     */
    public void awardCameraPerssion() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CAMERA
        }, 2);
    }


    /**
     * 弹窗显示是否允许获取日历权限
     *
     * @param title
     * @param msg
     */
    public void showDialogToGetCalendar(String title, String msg) {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("准了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //调用系统的授予权限的按钮
                        awardCalendarPerssion();
                    }
                })
                .setNegativeButton("不准", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    /**
     * 允许获取日历权限
     */
    public void awardCalendarPerssion() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.READ_CALENDAR,
                Manifest.permission.WRITE_CALENDAR
        }, 1);
    }


    /**
     * 申请权限之后的回调方法
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                //获取日历权限
                //如果Android版本大于23
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    //判断当前页面是否已经获取了日历权限
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(MainActivity.this, permissions[i] + "权限获取失败", Toast.LENGTH_SHORT).show();
                            //判断是否可以重复获取权限
                            boolean b = shouldShowRequestPermissionRationale(permissions[i]);
                            if (!b) {
                                //用户依然想要继续使用，则必须开启当前权限
                                showDialogTipUserGoToAppSettting();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, permissions[i] + "权限获取成功", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
                break;
            case 2:
                //获取相机权限
                //如果SDK版本大于23
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, permissions[0] + "权限获取失败", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, permissions[0] + "获取权限成功", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    /**
     * 弹出让用户调转到设置页面的弹窗
     */
    public void showDialogTipUserGoToAppSettting() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("请前往设置页面，开启权限")
                .setMessage("请在-应用设置-权限-中")
                .setPositiveButton("准了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        goToAppSetting();
                    }
                })
                .setPositiveButton("不准", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    /**
     * 开始跳转到设置页面
     */
    public void goToAppSetting() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    int code = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR);
                    if (code != PackageManager.PERMISSION_GRANTED) {
                        //m没有获取响应的权限，则提示用户需要手动设置
                        showDialogTipUserGoToAppSettting();
                    } else {
                        Toast.makeText(this, "获取读取日历权限成功", Toast.LENGTH_SHORT).show();
                    }
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                        //没有获取响应的权限，提示用户去手动设置
                        showDialogTipUserGoToAppSettting();
                    } else {
                        Toast.makeText(this, "获取写入日历权限成功", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

}
