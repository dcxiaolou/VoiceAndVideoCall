package com.android.dcxiaolou.voiceandvideocall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.dcxiaolou.voiceandvideocall.GroupVideoCall.openvcall.ui.VideoMainActivity;
import com.android.dcxiaolou.voiceandvideocall.GroupVoiceCall.openacall.ui.VoiceMainActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView voiceCallTv, videoCallTv, groupVoiceCallTv, GroupVoideoCallTv;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voiceCallTv = (TextView) findViewById(R.id.tv_voice_call);
        videoCallTv = (TextView) findViewById(R.id.tv_video_call);
        groupVoiceCallTv = (TextView) findViewById(R.id.tv_group_voice_call);
        GroupVoideoCallTv = (TextView) findViewById(R.id.tv_group_video_call);

        voiceCallTv.setOnClickListener(this);
        videoCallTv.setOnClickListener(this);
        groupVoiceCallTv.setOnClickListener(this);
        GroupVoideoCallTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_voice_call:
                intent = new Intent(this, VoiceCallActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_video_call:
                intent = new Intent(this, VideoCallActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_group_voice_call:
                intent = new Intent(this, VoiceMainActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_group_video_call:
                intent = new Intent(this, VideoMainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
