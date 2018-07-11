package com.laughing.wulianwang;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.laughing.wulianwang.singleton.Singleton;
import com.laughing.wulianwang.singleton.Singleton1;
import com.laughing.wulianwang.singleton.Singleton2;
import com.laughing.wulianwang.singleton.Singleton3;
import com.laughing.wulianwang.singleton.Singleton4;
import com.laughing.wulianwang.singleton.Singleton5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import androidkun.com.versionupdatelibrary.entity.VersionUpdateConfig;

public class MainActivity extends AppCompatActivity {
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.bt);
//        testSingleton();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TAG", "laughing---------------------->   ");

//                    Socket socket = new Socket("192.168.4.1", 80);
                //连接服务器 并设置连接超时为10秒
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = new Socket();
                            socket.connect(new InetSocketAddress("192.168.4.1", 80), 10000); //端口号为80
                            //获取输入输出流
                            OutputStream ou = socket.getOutputStream();
                            BufferedReader bff = new BufferedReader(new InputStreamReader(
                                    socket.getInputStream()));
                            //读取发来服务器信息
                            String line = null;
                            String buffer = "";
                            while ((line = bff.readLine()) != null) {
                                buffer = line + buffer;
                                Log.e("TAG", "laughing---------------------->   " + buffer);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                showNoticeDialog("");


//                new UpdateAppManager
//                        .Builder()
//                        //当前Activity
//                        .setActivity(MainActivity.this)
//                        //更新地址
//                        .setUpdateUrl(mUpdateUrl)
//                        //实现httpManager接口的对象
//                        .setHttpManager(new UpdateAppHttpUtil())
//                        .build()
//                        .update();


            }
        });
    }

    private void testSingleton() {
        Singleton instance = Singleton.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        Singleton3 instance3 = Singleton3.getInstance();
        Singleton4 instance4 = Singleton4.getInstance();
        Singleton5 instance5 = Singleton5.getInstance();
    }


    /**
     * 显示软件更新对话框
     */
    public void showNoticeDialog(final String apkUrl) {
        // 构造对话框

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("软件更新");
        builder.setMessage("有新版本,建议更新!");
        // 更新
        builder.setPositiveButton("更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                // 显示下载对话框

                startDownload();


//                Intent serviceIntent = new Intent(mContext, DownUpdateApk.class);
//                serviceIntent.putExtra("url", apkUrl);
//                startService(serviceIntent);
            }
        });
        // 稍后更新
        builder.setNegativeButton("稍后更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }

    private void startDownload() {
        String url = new String("http://dl.360safe.com/mzm/360clockweather.apk");
        VersionUpdateConfig.getInstance()//获取配置实例
                .setContext(MainActivity.this)//设置上下文
                .setDownLoadURL(url)//设置文件下载链接
                .setNewVersion("1.0.1")//设置即将下载的APK的版本号,避免重复下载
//                        .setFileSavePath(savePath)//设置文件保存路径（可不设置）
                .setNotificationIconRes(R.mipmap.ic_launcher)//设置通知图标
                .setNotificationSmallIconRes(R.mipmap.ic_launcher)//设置通知小图标
                .setNotificationTitle("版本升级Demo")//设置通知标题
                .startDownLoad();//开始下载
    }

}
