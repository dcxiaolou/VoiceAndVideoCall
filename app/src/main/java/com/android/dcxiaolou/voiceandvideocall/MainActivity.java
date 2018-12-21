package com.android.dcxiaolou.voiceandvideocall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.dcxiaolou.voiceandvideocall.GroupVideoCall.openvcall.ui.VideoMainActivity;
import com.android.dcxiaolou.voiceandvideocall.GroupVoiceCall.openacall.ui.VoiceMainActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button voiceCallBtn, videoCallBtn, groupVoiceCallBtn, GroupVoideoCallBtn;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voiceCallBtn = (Button) findViewById(R.id.btn_voice_call);
        videoCallBtn = (Button) findViewById(R.id.btn_video_call);
        groupVoiceCallBtn = (Button) findViewById(R.id.btn_group_voice_call);
        GroupVoideoCallBtn = (Button) findViewById(R.id.btn_group_video_call);

        voiceCallBtn.setOnClickListener(this);
        videoCallBtn.setOnClickListener(this);
        groupVoiceCallBtn.setOnClickListener(this);
        GroupVoideoCallBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_voice_call:
                intent = new Intent(this, VoiceCallActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_video_call:
                intent = new Intent(this, VideoCallActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_group_voice_call:
                intent = new Intent(this, VoiceMainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_group_video_call:
                intent = new Intent(this, VideoMainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
